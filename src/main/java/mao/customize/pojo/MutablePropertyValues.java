package mao.customize.pojo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Project name(项目名称)：java设计模式_自定义Spring框架
 * Package(包名): mao.customize.pojo
 * Class(类名): MutablePropertyValues
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/25
 * Time(创建时间)： 14:49
 * Version(版本): 1.0
 * Description(描述)： 一个bean标签可以有多个property子标签，所以再定义一个MutablePropertyValues类，用来存储并管理多个PropertyValue对象
 */


public class MutablePropertyValues implements Iterable<PropertyValue>
{
    private final List<PropertyValue> propertyValueList;

    /**
     * Instantiates a new Mutable property values.
     */
    public MutablePropertyValues()
    {
        this.propertyValueList = new ArrayList<>();
    }

    /**
     * Instantiates a new Mutable property values.
     *
     * @param propertyValueList the property value list
     */
    public MutablePropertyValues(List<PropertyValue> propertyValueList)
    {
        //this.propertyValueList = Objects.requireNonNullElseGet(propertyValueList, ArrayList::new);
        if (propertyValueList != null)
        {
            this.propertyValueList = propertyValueList;
        }
        else
        {
            this.propertyValueList = new ArrayList<>();
        }
    }

    @Override
    public Iterator<PropertyValue> iterator()
    {
        //获取迭代器并返回
        return this.propertyValueList.iterator();
    }

    /**
     * 将List<PropertyValue>转数组后返回
     *
     * @return PropertyValue[] property value [ ]
     */
    public PropertyValue[] getPropertyValues()
    {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    /**
     * 根据属性的名称获取属性的值，也就是PropertyValue对象
     *
     * @param propertyName 属性的名称
     * @return PropertyValue对象 ，也可能会返回null
     */
    public PropertyValue getPropertyValue(String propertyName)
    {
        for (PropertyValue propertyValue : propertyValueList)
        {
            if (propertyValue.getName().equals(propertyName))
            {
                //获取到名字，直接返回
                return propertyValue;
            }
        }
        //没有获取到，返回null
        return null;
    }

    /**
     * 判断集合是否为空
     *
     * @return boolean类型 boolean
     */
    public boolean isEmpty()
    {
        return this.propertyValueList.isEmpty();
    }

    /**
     * 往集合里添加一个PropertyValue对象
     *
     * @param propertyValue PropertyValue对象
     * @return MutablePropertyValues （当前对象），链式调用
     */
    public MutablePropertyValues addPropertyValue(PropertyValue propertyValue)
    {
        if (propertyValue == null)
        {
            return this;
        }
        for (int i = 0; i < this.propertyValueList.size(); i++)
        {
            //从集合里获取，判断是否有名字冲突的，也就是id，id唯一
            PropertyValue propertyValue1 = this.propertyValueList.get(i);
            if (propertyValue1.getName().equals(propertyValue.getName()))
            {
                //id冲突
                //这里直接就替换
                this.propertyValueList.set(i, new PropertyValue(propertyValue.getName(), propertyValue.getRef(), propertyValue.getValue()));
            }
        }
        //没有id冲突，直接添加
        this.propertyValueList.add(propertyValue);
        return this;
    }

    /**
     * 判断propertyName是否存在
     *
     * @param propertyName propertyName
     * @return boolean类型 boolean
     */
    public boolean contains(String propertyName)
    {
        return this.getPropertyValue(propertyName) != null;
    }
}
