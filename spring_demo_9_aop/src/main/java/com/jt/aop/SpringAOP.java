package com.jt.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//1.AOP需要被Spring容器管理
@Component
//2.标识该类为AOP的切面  Spring容器默认不能识别切面的注解,需要手动配置
@Aspect
public class SpringAOP {
    /*切入点表达式练习
    * 1.within(com.jt.*.DeptServiceImp)
    * 2.within(com..jt.*.DeptServiceImp)一个点代表一级.两个点是2级包下
    * 3.within(com..jt..*)2级包下的所有类
    *4 @Before("execution(* com.jt..*.DeptServiceImp.add*())")
    *  返回值类型任意,com.jt下的所有包中的DeptServiceImp的类
    * 的add开头的方法,并且没有参数.
    * 5. @Before("execution(* com.jt..*.*(..))")
    * 返回值类型任意,com.jt包下的所有包的所有类的所有方法任一参数.
    *在Spring表达式中没有自动拆装箱功能!注意参数类型
    *
    * @annotation(包名.注解名)
    *@Before("@annotation(com.jt.anno.Cache)")
    * 只拦截特定注解的内容
    * */
    //1.定义before通知
   // @Before("bean(deptServiceImp)")

    /**
     * Spring为了AOP动态获取目标对象及方法中的数据,则通过JoinPoint对象
     * 进行数据的传递
     * getSignature:方法签名 获取方法的参数
     * @param joinPoint
     */
   // @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("获取目标对象"+joinPoint.getTarget().getClass());
        System.out.println("获取目标:"+joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("获取目标对象方法名:"+joinPoint.getSignature().getName());
        System.out.println("获取方法参数:"+ Arrays.toString(joinPoint.getArgs()));
        System.out.println("我是before的通知");
    }

   // @Before("within(com.jt.service.DeptServiceImp)")
    //@Before("execution(* com.jt..*.DeptServiceImp.add*())")
//    @Before("@annotation(com.jt.anno.Cache)")
//    public void before1() {
//        System.out.println("我是before的通知");
//    }
    @Pointcut("@annotation(com.jt.anno.Cache)")//定义切入点表达式
    public void pointcut(){

    }
    /*记录方法的返回值
    * pointcut:关联的切入点表达式
    * returning:将方法的返回值,通过形参result进行传递
    * 注意事项:
    * 如果参数中需要添加joinPoint 对象时,参数必须位于第一位
    * Spring在进行参数赋值时,采用index[0] 下标的方式赋值
    *
    * */

   // @AfterReturning(pointcut = "pointcut()",returning = "result")

    public void AfterReturning(JoinPoint joinPoint,Object result){
        System.out.println("我是AfterReturning通知");
        System.out.println("用户的方法返回值结果"+result);
    }


    /*
    throwing ="e"动态接收程序的报错信息
    利用异常通知进行记录
     */
    //@AfterThrowing(pointcut = "pointcut()",throwing = "e")
    public void AfterThrowing(Exception e){
        System.out.println("获取异常信息:"+e.getMessage());
        System.out.println("获取异常信息:"+e.getClass());
        System.out.println("获取去异常的通知afterThrowing");

    }
    //@After("pointcut()")
    public void After(){
        System.out.println("我是After");
    }

    /**
     * Around
     * 1.规则:在目标方法执行前后都要执行
     * 实际作用:可以控制目标方法是否执行.
     *
     * 关于环绕通知的说明
     * 作用:可以控制目标方是否执行
     * 参数:ProceedingJoinPoint  通过proceed方法控制目标方法执行.
     * 注意事项:
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint){
        System.out.println("环绕通知开始");
        //1.执行下一个通知  2.执行目标方法 3.接收返回值
        Object result = null;
        try {
            Long start = System.currentTimeMillis();
            result = joinPoint.proceed();
            Long end = System.currentTimeMillis();
            System.out.println("耗时:"+(end-start)+"ms");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕通知结束");
        return result;
    }


}
