package mao.customize.context;

/**
 * Project name(项目名称)：java设计模式_自定义Spring框架
 * Package(包名): mao.customize.context
 * Interface(接口名): BeanFactory
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/25
 * Time(创建时间)： 16:25
 * Version(版本): 1.0
 * Description(描述)： 在该接口中定义IOC容器的统一规范即获取bean对象
 */

public interface BeanFactory
{
    /**
     * 根据bean对象的名称获取bean对象
     *
     * @param name bean的名称，也就是bean标签的id
     * @return Object类型的对象
     * @throws Exception 异常
     */
    Object getBean(String name) throws Exception;

    /**
     * 根据bean对象的名称获取bean对象，并进行类型转换
     *
     * @param name  bean的名称，也就是bean标签的id
     * @param clazz 类的字节码
     * @param <T>   要转换的类型
     * @return 一个clazz类型的对象
     * @throws Exception 异常
     */
    <T> T getBean(String name, Class<? extends T> clazz) throws Exception;
}
