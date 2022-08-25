package mao.customize_use;

import mao.customize.context.ApplicationContext;
import mao.customize.context.ClassPathXmlApplicationContext;

/**
 * Project name(项目名称)：java设计模式_自定义Spring框架
 * Package(包名): mao.customize_use
 * Class(类名): UserController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/25
 * Time(创建时间)： 17:43
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class UserController
{
    public static void main(String[] args) throws Exception
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans1.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.add();
    }
}
