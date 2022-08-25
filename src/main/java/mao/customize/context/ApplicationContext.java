package mao.customize.context;

/**
 * Project name(项目名称)：java设计模式_自定义Spring框架
 * Package(包名): mao.customize.context
 * Interface(接口名): ApplicationContext
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/25
 * Time(创建时间)： 16:28
 * Version(版本): 1.0
 * Description(描述)： 该接口的所以的子实现类对bean对象的创建都是非延时的，所以在该接口中定义 refresh() 方法
 */

public interface ApplicationContext extends BeanFactory
{
    /**
     * refresh方法
     * 进行配置文件加载并进行对象创建
     * 方法的功能：
     * <p>
     * 1. 加载配置文件
     * <p>
     * 2. 根据注册表中的BeanDefinition对象封装的数据进行bean对象的创建
     *
     * @throws IllegalStateException 非法状态异常
     * @throws Exception             异常
     */
    void refresh() throws IllegalStateException, Exception;

}
