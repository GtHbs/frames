package jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 李昭
 * @Date: 2020/3/29 21:17
 */
@SuppressWarnings("all")
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private TokenHandler tokenHandler;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePath = new ArrayList<>();
        String login = "/jwt/login";
        excludePath.add(login);
        registry.addInterceptor(tokenHandler).excludePathPatterns(excludePath);
    }
}
