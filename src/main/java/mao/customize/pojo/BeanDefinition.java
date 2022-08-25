package mao.customize.pojo;

/**
 * Project name(项目名称)：java设计模式_自定义Spring框架
 * Package(包名): mao.customize.pojo
 * Class(类名): BeanDefinition
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/25
 * Time(创建时间)： 15:09
 * Version(版本): 1.0
 * Description(描述)： BeanDefinition类用来封装bean信息的，主要包含id（即bean对象的名称）、class（需要交由spring管理的类的全类名）及子标签property数据。
 * <p>
 * 例如：
 * <br>
 *
 * <bean id="userService" class="mao.use.UserServiceImpl">
 * <property name="userDao" ref="userDao"/>
 * </bean>
 */


public class BeanDefinition
{
    //id，id唯一
    private String id;
    //类的全路径名称，String类型
    private String className;
    //MutablePropertyValues对象，也就是多个property数据
    private MutablePropertyValues propertyValues;

    /**
     * Instantiates a new Bean definition.
     */
    public BeanDefinition()
    {
        this.propertyValues = new MutablePropertyValues();
    }

    /**
     * Instantiates a new Bean definition.
     *
     * @param id             the id
     * @param className      the class name
     * @param propertyValues the property values
     */
    public BeanDefinition(String id, String className, MutablePropertyValues propertyValues)
    {
        this.id = id;
        this.className = className;
        this.propertyValues = propertyValues;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId()
    {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * Gets class name.
     *
     * @return the class name
     */
    public String getClassName()
    {
        return className;
    }

    /**
     * Sets class name.
     *
     * @param className the class name
     */
    public void setClassName(String className)
    {
        this.className = className;
    }

    /**
     * Gets property values.
     *
     * @return the property values
     */
    public MutablePropertyValues getPropertyValues()
    {
        return propertyValues;
    }

    /**
     * Sets property values.
     *
     * @param propertyValues the property values
     */
    public void setPropertyValues(MutablePropertyValues propertyValues)
    {
        this.propertyValues = propertyValues;
    }
}
