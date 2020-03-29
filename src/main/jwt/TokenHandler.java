package jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: 李昭
 * @Date: 2020/3/29 21:18
 */
@Slf4j
@Component(value = "tokenHandler")
public class TokenHandler implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        if (authorization != null) {
            boolean verify = TokenUtil.verify(authorization);
            if (verify) {
                log.info("通过拦截器");
                return true;
            }
        }
        log.info("认证失败");
        return false;
    }
}
