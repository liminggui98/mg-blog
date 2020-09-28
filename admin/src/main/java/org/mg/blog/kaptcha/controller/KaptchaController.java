package org.mg.blog.kaptcha.controller;

import com.wf.captcha.utils.CaptchaUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class KaptchaController {
    @GetMapping("/kaptcha")
    public void getKaptcha(HttpServletRequest request, HttpServletResponse response) {
        try {
            CaptchaUtil.out(request, response);
        } catch (Exception e) {
            log.error("获取验证码异常：{}", e.getMessage());
        }
    }
}
