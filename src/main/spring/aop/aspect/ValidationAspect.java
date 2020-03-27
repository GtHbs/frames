package spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author 李昭
 */
@Aspect
@Component
@Order(1)       //使用order改变切面的优先级,数字越小,优先级越高
public class ValidationAspect {

    @Pointcut("spring.aop.aspect.LogUtils.pointCut()")
    public void pointCut(){}

    @Before("pointCut()")
    public static void logStart(JoinPoint point) {
        Object[] args = point.getArgs();
        Signature signature = point.getSignature();
        System.out.println("[validation-前置]"+signature.getName() + "方法开始执行,参数为:" + Arrays.asList(args));
    }

    @After("pointCut()")
    public static void logEnd(JoinPoint point) {
        String name = point.getSignature().getName();
        System.out.println("[validation-后置]"+name + "方法执行结束");
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public static void returning(JoinPoint point, Object result) {
        String name = point.getSignature().getName();
        System.out.println("[validation-返回]"+name + "方法正常执行结束,结果为:" + result);
    }

    @AfterThrowing(value = "pointCut()",throwing = "e")
    public static void logError(JoinPoint point, Exception e) {
        System.out.println("[validation-异常]" + e.getCause());
    }
}
