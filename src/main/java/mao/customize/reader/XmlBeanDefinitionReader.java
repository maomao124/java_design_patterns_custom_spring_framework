package mao.customize.reader;

import mao.customize.registry.BeanDefinitionRegistry;

/**
 * Project name(项目名称)：java设计模式_自定义Spring框架
 * Package(包名): mao.customize.reader
 * Class(类名): XmlBeanDefinitionReader
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/25
 * Time(创建时间)： 15:42
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class XmlBeanDefinitionReader implements BeanDefinitionReader
{

    @Override
    public BeanDefinitionRegistry getRegistry()
    {
        return null;
    }

    @Override
    public void loadBeanDefinitions(String configLocation) throws Exception
    {

    }
}
