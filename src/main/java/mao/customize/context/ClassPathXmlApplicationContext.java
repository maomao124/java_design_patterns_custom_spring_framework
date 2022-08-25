package mao.customize.context;

import mao.customize.pojo.BeanDefinition;
import mao.customize.pojo.MutablePropertyValues;
import mao.customize.pojo.PropertyValue;
import mao.customize.reader.XmlBeanDefinitionReader;
import mao.customize.registry.BeanDefinitionRegistry;

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
 * Description(描述)： 该类主要是加载类路径下的配置文件，并进行bean对象的创建
 */

public class ClassPathXmlApplicationContext extends AbstractApplicationContext
{

    public ClassPathXmlApplicationContext(String configLocation)
    {
        if (configLocation == null)
        {
            throw new NullPointerException("configLocation不能为null!");
        }
        this.configLocation = configLocation;
        this.beanDefinitionReader = new XmlBeanDefinitionReader();
        try
        {
            //进行配置文件加载
            this.refresh();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String name) throws Exception
    {
        if (name == null)
        {
            throw new NullPointerException("name不能为null!");
        }
        Object o = this.singletonObjects.get(name);
        if (o != null)
        {
            //singletonObjects里存在，直接返回
            return o;
        }
        //singletonObjects里不存在，需要创建，并放入到singletonObjects里，再返回
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        //根据名字获取BeanDefinition对象
        BeanDefinition beanDefinition = registry.getBeanDefinition(name);
        if (beanDefinition == null)
        {
            //配置文件里不存在bean的id为name的标签，直接返回null
            return null;
        }
        //配置文件里存在bean的id为name的标签
        //获取类名称
        String className = beanDefinition.getClassName();
        //通过反射创建类的对象
        Class<?> aClass = Class.forName(className);
        //调用无参构造方法
        Object bean = aClass.getDeclaredConstructor().newInstance();
        //获取MutablePropertyValues对象，里面封装了多个bean的属性
        MutablePropertyValues mutablePropertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue propertyValue : mutablePropertyValues)
        {
            //name
            String propertyName = propertyValue.getName();
            //引用
            String ref = propertyValue.getRef();
            //值
            String value = propertyValue.getValue();

            if (ref != null && !"".equals(ref))
            {
                //ref不为空
                //递归调用getBean方法
                Object bean1 = this.getBean(name);
            }
        }

        return null;
    }

    @Override
    public <T> T getBean(String name, Class<? extends T> clazz) throws Exception
    {
        return null;
    }
}
