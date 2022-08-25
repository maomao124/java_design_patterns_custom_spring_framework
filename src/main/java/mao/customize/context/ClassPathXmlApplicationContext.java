package mao.customize.context;

/**
 * Project name(项目名称)：java设计模式_自定义Spring框架
 * Package(包名): mao.customize.context
 * Class(类名): ClassPathXmlApplicationContext
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/25
 * Time(创建时间)： 16:52
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class ClassPathXmlApplicationContext extends AbstractApplicationContext
{

    @Override
    public Object getBean(String name) throws Exception
    {
        return null;
    }

    @Override
    public <T> T getBean(String name, Class<? extends T> clazz) throws Exception
    {
        return null;
    }
}
