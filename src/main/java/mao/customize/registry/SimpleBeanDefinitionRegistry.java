package mao.customize.registry;

import mao.customize.pojo.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * Project name(项目名称)：java设计模式_自定义Spring框架
 * Package(包名): mao.customize.registry
 * Class(类名): SimpleBeanDefinitionRegistry
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/25
 * Time(创建时间)： 15:22
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class SimpleBeanDefinitionRegistry implements BeanDefinitionRegistry
{

    private final Map<String, BeanDefinition> beanDefinitionMap;

    public SimpleBeanDefinitionRegistry()
    {
        this.beanDefinitionMap = new HashMap<>();
    }

    public SimpleBeanDefinitionRegistry(Map<String, BeanDefinition> beanDefinitionMap)
    {
        //this.beanDefinitionMap = Objects.requireNonNullElseGet(beanDefinitionMap, HashMap::new);
        if (beanDefinitionMap != null)
        {
            this.beanDefinitionMap = beanDefinitionMap;
        }
        else
        {
            this.beanDefinitionMap = new HashMap<>();
        }

    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition)
    {

    }

    @Override
    public void removeBeanDefinition(String beanName) throws Exception
    {

    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws Exception
    {
        return null;
    }

    @Override
    public boolean containsBeanDefinition(String beanName)
    {
        return false;
    }

    @Override
    public int getBeanDefinitionCount()
    {
        return 0;
    }

    @Override
    public String[] getBeanDefinitionNames()
    {
        return new String[0];
    }
}
