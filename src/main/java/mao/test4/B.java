package mao.test4;

/**
 * Project name(项目名称)：java设计模式_自定义Spring框架
 * Package(包名): mao.test4
 * Class(类名): B
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/25
 * Time(创建时间)： 18:26
 * Version(版本): 1.0
 * Description(描述)： B依赖于A
 */

public class B
{
    private String name;
    private A a;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public A getA()
    {
        return a;
    }

    public void setA(A a)
    {
        this.a = a;
    }
}
