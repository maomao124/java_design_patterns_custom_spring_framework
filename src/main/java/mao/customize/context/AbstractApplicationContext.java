package mao.customize.context;

import mao.customize.pojo.BeanDefinition;
import mao.customize.reader.BeanDefinitionReader;
import mao.customize.registry.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * Project name(项目名称)：java设计模式_自定义Spring框架
 * Package(包名): mao.customize.context
 * Class(类名): AbstractApplicationContext
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/25
 * Time(创建时间)： 16:34
 * Version(版本): 1.0
 * Description(描述)： ApplicationContext接口的子类，该类也是非延时加载
 */

public abstract class AbstractApplicationContext implements ApplicationContext
{
    //BeanDefinitionReader对象，用于加载配置和获取注册表对象
    protected BeanDefinitionReader beanDefinitionReader;

    //存储bean对象的容器。key存储的是bean的id值，value存储的是bean对象
    protected Map<String, Object> singletonObjects = new HashMap<>();

    //存储配置文件的路径
    protected String configLocation;


    @Override
    public void refresh() throws IllegalStateException, Exception
    {
        //加载BeanDefinition
        //在此抽象类类调用会出现空指针异常？BeanDefinitionReader对象的创建要要交给子类，
        //而且此抽象类不能直接new，还有方法未重写，refresh由子类调用
        beanDefinitionReader.loadBeanDefinitions(configLocation);
        //初始化bean
        this.finishBeanInitialization();
    }

    /**
     * 初始化bean
     *
     * @throws Exception 异常
     */
    private void finishBeanInitialization() throws Exception
    {
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames)
        {
            //BeanDefinition beanDefinition = registry.getBeanDefinition(beanDefinitionName);
            //此方法交给子类来实现，模板方法模式
            this.getBean(beanDefinitionName);
        }
    }
}
