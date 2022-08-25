package mao.test4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Project name(项目名称)：java设计模式_自定义Spring框架
 * Package(包名): mao.test4
 * Class(类名): TestBySpring
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/25
 * Time(创建时间)： 18:33
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class TestBySpring
{
    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans4.xml");

        B b = applicationContext.getBean("b", B.class);
        System.out.println(b.getA().getName());
        System.out.println(b.getName());
    }
}
