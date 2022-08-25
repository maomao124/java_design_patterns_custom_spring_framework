package mao.customize.pojo;

/**
 * Project name(项目名称)：java设计模式_自定义Spring框架
 * Package(包名): mao.customize.pojo
 * Class(类名): PropertyValue
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/25
 * Time(创建时间)： 14:46
 * Version(版本): 1.0
 * Description(描述)： 用于封装bean的属性
 *
 * <property name="userDao" ref="userDao"/>
 */


public class PropertyValue
{
    //属性名称
    private String name;
    //引用
    private String ref;
    //值
    private String value;

    /**
     * Instantiates a new Property value.
     */
    public PropertyValue()
    {

    }

    /**
     * Instantiates a new Property value.
     *
     * @param name  the name
     * @param ref   the ref
     * @param value the value
     */
    public PropertyValue(String name, String ref, String value)
    {
        this.name = name;
        this.ref = ref;
        this.value = value;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets ref.
     *
     * @return the ref
     */
    public String getRef()
    {
        return ref;
    }

    /**
     * Sets ref.
     *
     * @param ref the ref
     */
    public void setRef(String ref)
    {
        this.ref = ref;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue()
    {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(String value)
    {
        this.value = value;
    }
}
