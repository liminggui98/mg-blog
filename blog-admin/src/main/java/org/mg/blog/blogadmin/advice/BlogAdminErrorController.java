package org.mg.blog.blogadmin.advice;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.web.tags.NotAuthenticatedTag;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 统一异常处理
 */
@ControllerAdvice
public class BlogAdminErrorController implements ErrorController {

    @ExceptionHandler(value = Exception.class)
    public String error(Exception e) {
        if (e != null) {
            e.printStackTrace();
        }
        return "error";
    }

    @ExceptionHandler(value = AuthorizationException.class)
    public String noAuthorization(){
        return "error/401";
    }

    @Override
    public String getErrorPath() {
        return "error";
    }
}
