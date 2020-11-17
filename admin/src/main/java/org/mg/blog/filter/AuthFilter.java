
package org.mg.blog.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.mg.blog.system.dto.User;
import org.mg.blog.utils.CookieUtils;
import org.mg.blog.utils.SessionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 认证过滤器
 *
 * @since 2020-06-16
 */
@Data
@Slf4j
@Component
@WebFilter(urlPatterns = "*")
public class AuthFilter implements Filter {

    @Resource
    RedisTemplate<String, Serializable> redisTemplate;

    /**
     * 用戶会话 id
     */
    public static final String SESSION_ID_FIELD = "JSESSIONID";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = null;
        HttpServletResponse response = null;

        if (servletRequest instanceof HttpServletRequest) {
            request = (HttpServletRequest) servletRequest;
        }
        if (servletResponse instanceof HttpServletResponse) {
            response = (HttpServletResponse) servletResponse;
        }

        String sessionId = CookieUtils.get(request, SESSION_ID_FIELD);
        if (StringUtils.isEmpty(sessionId)) {
            CookieUtils.set(response, SESSION_ID_FIELD, SessionUtils.getSessionId());
        }
        User user = (User) redisTemplate.opsForValue().get(sessionId);
        if (Objects.isNull(user)) {
            log.info("user info is null");
        }
        request.setAttribute("user", user);

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
