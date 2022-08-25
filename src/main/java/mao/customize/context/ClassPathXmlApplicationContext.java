package mao.customize.context;

import mao.customize.pojo.BeanDefinition;
import mao.customize.pojo.MutablePropertyValues;
import mao.customize.pojo.PropertyValue;
import mao.customize.reader.XmlBeanDefinitionReader;
import mao.customize.registry.BeanDefinitionRegistry;
import mao.customize.utils.StringUtils;

import java.lang.reflect.Method;

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

            //标签有ref属性
            if (ref != null && !"".equals(ref))
            {
                //ref不为空
                //递归调用getBean方法
                Object bean1 = this.getBean(ref);
                //获取对应的set方法的名称
                String setMethodName = StringUtils.toSetMethodName(propertyName);
                //获取所有方法
                Method[] methods = aClass.getMethods();
                //遍历
                for (Method method : methods)
                {
                    if (method.getName().equals(setMethodName))
                    {
                        //方法名称一致
                        //执行bean对象的set方法，将对象bean1注入到bean对象中
                        method.invoke(bean, bean1);
                    }
                }
            }

            //标签有value属性，不用管既有ref又有value的情况，比如<property name="userDao" ref="userDao" value="hello"/>
            if (value != null && !"".equals(value))
            {
                //获取对应的set方法的名称
                String setMethodName = StringUtils.toSetMethodName(propertyName);
                //获取所有方法
                Method[] methods = aClass.getMethods();
                //遍历
                for (Method method : methods)
                {
                    if (method.getName().equals(setMethodName))
                    {
                        //方法名称一致
                        //执行bean对象的set方法，将value的值注入到bean对象中
                        method.invoke(bean, value);
                    }
                }
            }
        }
        //放入到map集合里
        this.singletonObjects.put(name, bean);
        //返回
        return bean;
    }

    @Override
    public <T> T getBean(String name, Class<? extends T> clazz) throws Exception
    {
        //获取bean
        Object bean = this.getBean(name);
        if (bean == null)
        {
            return null;
        }
        //转换再返回
        return clazz.cast(bean);
    }
}
