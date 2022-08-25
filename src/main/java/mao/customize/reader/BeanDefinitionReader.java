package mao.customize.reader;

import mao.customize.registry.BeanDefinitionRegistry;

/**
 * Project name(项目名称)：java设计模式_自定义Spring框架
 * Package(包名): mao.customize.reader
 * Interface(接口名): BeanDefinitionReader
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/25
 * Time(创建时间)： 15:36
 * Version(版本): 1.0
 * Description(描述)：
 * BeanDefinitionReader是用来解析配置文件并在注册表中注册bean的信息。定义了两个规范：
 * <p>
 * 获取注册表的功能，让外界可以通过该对象获取注册表对象。
 * 加载配置文件，并注册bean数据。
 */

public interface BeanDefinitionReader
{
    /**
     * 获取注册表对象
     *
     * @return BeanDefinitionRegistry的子实现类
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 加载配置文件并在注册表中进行注册
     *
     * @param configLocation 文件的路径，一般都为类路径，具体看实现类
     * @throws Exception 异常
     */
    void loadBeanDefinitions(String configLocation) throws Exception;
}
