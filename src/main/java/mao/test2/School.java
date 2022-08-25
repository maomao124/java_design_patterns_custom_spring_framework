package mao.test2;

/**
 * Project name(项目名称)：java设计模式_自定义Spring框架
 * Package(包名): mao.test2
 * Class(类名): School
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/25
 * Time(创建时间)： 17:59
 * Version(版本): 1.0
 * Description(描述)： 无
 */


public class School
{
    //学校名称
    private String name;
    //学校地址
    private String address;

    /**
     * Instantiates a new School.
     */
    public School()
    {
    }

    /**
     * Instantiates a new School.
     *
     * @param name    the name
     * @param address the address
     */
    public School(String name, String address)
    {
        this.name = name;
        this.address = address;
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
     * Gets address.
     *
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("name：").append(name).append('\n');
        stringbuilder.append("address：").append(address).append('\n');
        return stringbuilder.toString();
    }
}
