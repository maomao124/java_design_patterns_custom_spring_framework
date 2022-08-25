package mao.customize.reader;

import mao.customize.pojo.BeanDefinition;
import mao.customize.pojo.MutablePropertyValues;
import mao.customize.pojo.PropertyValue;
import mao.customize.registry.BeanDefinitionRegistry;
import mao.customize.registry.SimpleBeanDefinitionRegistry;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

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
    private final BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader()
    {
        this.registry = new SimpleBeanDefinitionRegistry();
    }

    @Override
    public BeanDefinitionRegistry getRegistry()
    {
        return this.registry;
    }

    @Override
    public void loadBeanDefinitions(String configLocation) throws Exception
    {
        //获取类路径下的配置文件的输入流
        InputStream inputStream = XmlBeanDefinitionReader.class.getClassLoader().getResourceAsStream(configLocation);
        //构建SAXReader对象
        SAXReader saxReader = new SAXReader();
        //加载dom树
        Document document = saxReader.read(inputStream);
        //获取根元素（beans）
        Element rootElement = document.getRootElement();
        //解析bean标签
        parseBean(rootElement);
    }

    /**
     * 解析bean标签
     *
     * @param rootElement Element对象
     */
    private void parseBean(Element rootElement)
    {
        //获取所有的bean标签
        List<Element> elements = rootElement.elements();
        for (Element element : elements)
        {
            //element就为每一个bean标签
            //获取标签的属性
            //id
            String id = element.attributeValue("id");
            //类名
            String className = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setId(id);
            beanDefinition.setClassName(className);
            //解析子标签property，也就是对应的set方法
            List<Element> properties = element.elements("property");
            MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
            //遍历
            for (Element property : properties)
            {
                //获取标签的属性
                String name = property.attributeValue("name");
                String ref = property.attributeValue("ref");
                String value = property.attributeValue("value");
                //封装
                PropertyValue propertyValue = new PropertyValue();
                propertyValue.setName(name);
                propertyValue.setRef(ref);
                propertyValue.setValue(value);
                //加入到MutablePropertyValues对象中
                mutablePropertyValues.addPropertyValue(propertyValue);
            }
            //将mutablePropertyValues加入到beanDefinition中
            beanDefinition.setPropertyValues(mutablePropertyValues);
            //注册到registry
            registry.registerBeanDefinition(id, beanDefinition);
        }
    }
}
