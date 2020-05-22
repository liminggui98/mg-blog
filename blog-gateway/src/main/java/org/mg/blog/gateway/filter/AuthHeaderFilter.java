package org.mg.blog.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class AuthHeaderFilter extends ZuulFilter {

    private static final String BEARER_TOKEN_TYPE = "bearer ";
    private static final String OPTIONS = "OPTIONS";
    private static final String AUTH_PATH = "/auth";
    private static final String LOGOUT_URI = "/oauth/token";
    private static final String ALIPAY_CALL_URI = "/pay/alipayCallback";

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        log.info("AuthHeaderFilter - 开始鉴权...");
        RequestContext requestContext = RequestContext.getCurrentContext();
        try {
            doSomething(requestContext);
        } catch (Exception e) {
            log.error("AuthHeaderFilter - [FAIL] EXCEPTION={}", e.getMessage(), e);
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            return null;
        }
        return null;
    }

    private void doSomething(RequestContext requestContext) throws ZuulException {
        HttpServletRequest request = requestContext.getRequest();

        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.isEmpty(authHeader)) {
            throw new ZuulException("刷新页面重试", 403, "check token fail");
        }
        if (authHeader.startsWith(BEARER_TOKEN_TYPE)) {
            log.info("authHeader={} ", authHeader);

            requestContext.addZuulRequestHeader(HttpHeaders.AUTHORIZATION, authHeader);
            requestContext.addZuulRequestHeader("x-label", authHeader);
        }
    }

}
