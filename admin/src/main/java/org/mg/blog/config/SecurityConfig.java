
package org.mg.blog.config;

import org.mg.blog.dto.Result;
import org.mg.blog.system.api.UserApi;
import org.mg.blog.system.dto.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.util.Objects;

import javax.annotation.Resource;

/**
 * 功能描述
 *
 * @since 2020-06-19
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserApi userApi;

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return username -> {
            Result<User> result = userApi.queryByUserName(username);
            User user = result.getResult();
            if (Objects.isNull(user)) {
                throw new UsernameNotFoundException(username);
            }
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                    AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/assets/**", "/kaptcha", "/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/casLogin")  // 定义登录页面，未登录时，访问一个需要登录之后才能访问的接口，会自动跳转到该页面
                .loginProcessingUrl("/casLogin")
                .usernameParameter("username") // 定义登录时，用户名的 key，默认为 username
                .passwordParameter("passwd") // 定义登录时，用户密码的 key，默认为 password
                .failureUrl("/casLogin?error=true")
                .successHandler(authenticationSuccessHandler()) // 登录成功的处理器
                .failureHandler(authenticationFailureHandler()) // 登录失败的处理器
                .permitAll() // 和表单登录相关的接口统统都直接通过
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(logoutSuccessHandler())
                .permitAll()
                .and()
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable();
    }

    /**
     * 登录失败处理器
     *
     * @return 处理器
     */
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return (req, resp, exception) -> {
            // 登录失败后，再次跳转到登录页面，并携带错误信息
            resp.sendRedirect("/casLogin?error=true&message=" + exception.getMessage());
        };
    }

    /**
     * 登录成功处理器
     *
     * @return 登录成功处理器
     */
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return (req, resp, exception) -> {
            // 重定向到首页
            resp.sendRedirect("/");
        };
    }

    /**
     * 登出成功处理器
     *
     * @return 登出成功处理器
     */
    public LogoutSuccessHandler logoutSuccessHandler() {
        return (req, resp, exception) -> {
            // 重定向到登录页
            resp.sendRedirect("/casLogin");
        };
    }
}
