package mao.use;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Project name(项目名称)：java设计模式_自定义Spring框架
 * Package(包名): mao.use
 * Class(类名): UserController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/24
 * Time(创建时间)： 20:51
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class UserController
{
    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = applicationContext.getBean(UserServiceImpl.class);
        userService.add();
    }
}
