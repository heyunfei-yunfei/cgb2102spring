package test;

import com.jt.config.SpringConfig;
import com.jt.pojo.User;
import com.jt.proxy.JDKProxyFactory;
import com.jt.service.UserService;
import com.jt.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {
    /*Spring中規定:
    * 如果传入的是接口类型,则自动查找/注入,该接口的实现类,但该接口有且只有一个实现类
    * */
    @Test
    public void test01(){

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserServiceImpl  userService = (UserServiceImpl) context.getBean(UserService.class);
        User user = new User();
        user.setId(101);
        user.setName("刘德华");
        userService.addUser(user);
    }

    @Test
    public void test02(){

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService  userService = (UserService) context.getBean("userService");
        User user = new User();
        user.setId(101);
        user.setName("刘德华");
        userService.addUser(user);
    }



    /*测试JDK动态代理*/
    @Test
    public void testJDKProxy(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        //获取用户目标对象
        UserService target = (UserService) context.getBean("target");
        //2.获取代理对象
        UserService userService = (UserService) JDKProxyFactory.getProxy(target);
        System.out.println(userService.getClass());

        //用户完成调用
        User user = new User();
        user.setId(108);
        user.setName("JDK动态代理完成");
        userService.addUser(user);
        //动态代理对方法进行优化
        //删除用户的方法
        userService.deleteUser(user);
    }
}
