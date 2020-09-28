
package org.mg.blog.utils;

import org.apache.commons.lang.StringUtils;

import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie 工具类
 *
 * @since 2020-09-23
 */
public class CookieUtils {
    private CookieUtils() {
    }

    /**
     * 获取 cookie 值
     *
     * @param request 请求对象
     * @param key cookie 字段
     * @return cookie 值
     */
    public static String get(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return StringUtils.EMPTY;
        }
        for (Cookie cookie : cookies) {
            if (StringUtils.equals(cookie.getName(), key)) {
                return Optional.of(cookie.getValue()).orElse(StringUtils.EMPTY);
            }
        }
        return StringUtils.EMPTY;
    }

    public static void set(HttpServletResponse response, String key, String value) {
        set(response, key, value, -1, "/");
    }

    public static void set(HttpServletResponse response, String key, String value, int expiry) {
        set(response, key, value, expiry, "/");
    }

    public static void set(HttpServletResponse response, String key, String value, int expiry, String path) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(expiry);
        cookie.setPath(path);
        response.addCookie(cookie);
    }

    public static void set(HttpServletResponse response, Cookie cookie) {
        response.addCookie(cookie);
    }

    public static void remove(HttpServletResponse response, String key) {
        set(response, key, (String) null, 0);
    }
}
