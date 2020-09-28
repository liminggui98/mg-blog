
package org.mg.blog.filter;

import org.apache.commons.lang.StringUtils;
import org.mg.blog.utils.CookieUtils;
import org.mg.blog.utils.SessionUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
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
@WebFilter(urlPatterns = "/")
public class AuthFilter implements Filter {

    /**
     * 用戶会话 id
     */
    public static final String SESSION_ID_FIELD = "JSESSIONID";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
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
    }
}
