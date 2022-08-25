package mao.test2;

/**
 * Project name(项目名称)：java设计模式_自定义Spring框架
 * Package(包名): mao.test2
 * Class(类名): Student
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/25
 * Time(创建时间)： 17:58
 * Version(版本): 1.0
 * Description(描述)： 值注入测试
 */


public class Student
{
    //学号
    private String id;
    //姓名
    private String name;
    //性别
    private String sex;
    //学校
    private School school;

    /**
     * Instantiates a new Student.
     */
    public Student()
    {

    }

    /**
     * Instantiates a new Student.
     *
     * @param id     the id
     * @param name   the name
     * @param sex    the sex
     * @param school the school
     */
    public Student(String id, String name, String sex, School school)
    {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.school = school;
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
     * Gets sex.
     *
     * @return the sex
     */
    public String getSex()
    {
        return sex;
    }

    /**
     * Sets sex.
     *
     * @param sex the sex
     */
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    /**
     * Gets school.
     *
     * @return the school
     */
    public School getSchool()
    {
        return school;
    }

    /**
     * Sets school.
     *
     * @param school the school
     */
    public void setSchool(School school)
    {
        this.school = school;
    }

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("id：").append(id).append('\n');
        stringbuilder.append("name：").append(name).append('\n');
        stringbuilder.append("sex：").append(sex).append('\n');
        stringbuilder.append("school：").append(school).append('\n');
        return stringbuilder.toString();
    }
}
