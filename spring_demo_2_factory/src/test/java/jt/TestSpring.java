package jt;

import com.jt.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jws.soap.SOAPBinding;
import javax.sound.midi.Soundbank;
import java.applet.AppletContext;
import java.util.Calendar;

public class TestSpring {
    @Test
    public void test01(){
        ApplicationContext context  = new ClassPathXmlApplicationContext("application.xml");
        Calendar calendar1 = (Calendar) context.getBean("calendar1");
        System.out.println(calendar1.getTime());
    }
    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Calendar calendar2 = (Calendar) context.getBean("calendar2");
        System.out.println("获取当前时间:"+calendar2.getTime());

    }
    @Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Calendar calendar3 = (Calendar) context.getBean("calendar3");
        System.out.println("获取当前时间:"+calendar3.getTime());
    }

    //单例,多例,懒加载测试
    @Test
    public void test04(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        context.getBean("user");
        context.getBean("user");
        context.getBean("user");
        User user = (User)context.getBean("user");
        user.say();
    }
    //测试生命周期运行
    @Test
    public void test05(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        //获取对象
        User user = (User)context.getBean("user"); //User user1 = context.getBean(User.class);
        //用户调用方法
        user.say();
        //只要容器关闭,则对象销毁
        context.close();

    }

}
