package mao.test4;

/**
 * Project name(项目名称)：java设计模式_自定义Spring框架
 * Package(包名): mao.test4
 * Class(类名): A
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/25
 * Time(创建时间)： 18:26
 * Version(版本): 1.0
 * Description(描述)： A依赖于B
 */

public class A
{
    private String name;
    private B b;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public B getB()
    {
        return b;
    }

    public void setB(B b)
    {
        this.b = b;
    }
}
