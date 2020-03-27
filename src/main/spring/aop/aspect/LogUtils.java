package spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author 李昭
 *
 * 多个切面共同切入一个方法,执行顺序为按切入类的首字母比较,小的在前大的在后
 */
@Aspect
@Component
public class LogUtils {

    /**
     * 抽取可重用切入点
     */
    @Pointcut("execution( * spring.aop.bean.Calculate.*(..))")
    public void pointCut() {
    }

    /**
     * 执行顺序没有出现异常
     *
     * @Before
     * @After
     * @AfterReturning
     *
     * 出现异常
     * @Before
     * @After
     * @AfterThrowing
     */
    @Before("pointCut()")
    public static void logStart(JoinPoint point) {
        //获取参数列表
        Object[] args = point.getArgs();
        //获取方法的签名
        Signature signature = point.getSignature();
        //2
        System.out.println("[log-前置]" + signature.getName() + "方法开始执行,参数为:" + Arrays.asList(args));
    }


    @After("pointCut()")
    public static void logEnd(JoinPoint point) {
        String name = point.getSignature().getName();
        //5
        System.out.println("[log-后置]" + name + "方法执行结束");
    }

    /**
     * 抛出异常
     * 使用加入点控制详细信息
     *
     * @param point
     */
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public static void logError(JoinPoint point, Exception e) {
        System.out.println("[log-异常]" + e.getCause());
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public static void returning(JoinPoint point, Object result) {
        String name = point.getSignature().getName();
        //6
        System.out.println("[log-返回]" + name + "方法正常执行结束,结果为:" + result);
    }

    /**
     * 环绕通知是优先于普通通知执行的
     * 执行顺序
     * 正常:
     * 环绕前置:div参数为:[1, 1]
     * [log-前置]div方法开始执行,参数为:[1, 1]
     * 环绕返回:div结果为:1.0
     * 环绕方法正常结束
     * [log-后置]div方法执行结束
     * [log-返回]div方法正常执行结束,结果为:1.0
     * 异常:
     * 环绕前置:div参数为:[1, 0]
     * [log-前置]div方法开始执行,参数为:[1, 0]
     * 环绕出现异常null
     * 环绕方法正常结束
     * [log-后置]div方法执行结束
     * [log-异常]方法执行出错java.lang.ArithmeticException: / by zero
     *
     * @param point
     * @return
     */
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) {
        Object[] args = point.getArgs();
        String name = point.getSignature().getName();
        Object result = null;
        try {
            //1
            System.out.println("环绕前置:" + name + "参数为:" + Arrays.asList(args));
            //调用目标方法
            result = point.proceed(args);
            //3
            System.out.println("环绕返回:" + name + "结果为:" + result);
        } catch (Throwable throwable) {
            System.out.println("环绕异常" + throwable.getCause());
            throw new RuntimeException(throwable);
        } finally {
            //4
            System.out.println("环绕后置");
        }
        return result;
    }
}
