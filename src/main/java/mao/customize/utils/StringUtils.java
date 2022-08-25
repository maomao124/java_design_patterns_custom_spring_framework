package mao.customize.utils;

/**
 * Project name(项目名称)：java设计模式_自定义Spring框架
 * Package(包名): mao.customize.utils
 * Class(类名): StringUtils
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/25
 * Time(创建时间)： 17:15
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class StringUtils
{
    /**
     * 将属性名称转换成对应的set方法的名称
     * <p>
     * 比如：
     * name -> setName
     * <p>
     * age -> setAge
     *
     * @param propertyName 属性的名称
     * @return 对应的set方法的名称
     */
    public static String toSetMethodName(String propertyName)
    {
        return "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
    }

    public static void main(String[] args)
    {
        System.out.println(toSetMethodName("name"));
        System.out.println(toSetMethodName("age"));
        System.out.println(toSetMethodName("sex"));
        System.out.println(toSetMethodName("abc"));
    }
}
