package jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jdk.vm.ci.meta.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 李昭
 * @Date: 2020/3/29 21:05
 */
public class TokenUtil {
    //token过期时间
    private static final long EXPIRE_TIME = 30 * 60 * 1000;
    //token加密密钥
    private static final String TOKEN_SECRET = "token_secret";

    /**
     * 生成签名
     *
     * @param userInfo 用户信息
     * @param other    其他信息
     * @return
     */
    public static String sign(String userInfo, String other) {
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            //私钥加密
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String, Object> map = new HashMap<>(16);
            map.put("Type", "Jwt");
            map.put("alg", "HS256");
            //返回token字符串
            return JWT.create().withHeader(map).withClaim("userInfo", userInfo).
                    withClaim("other", other).withExpiresAt(date).sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 校验token是否正确
     *
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取用户信息
     *
     * @param token
     * @param info
     * @return
     */
    public static String getUserName(String token, String info) {
        try {
            DecodedJWT decode = JWT.decode(token);
            return decode.getClaim(info).asString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
