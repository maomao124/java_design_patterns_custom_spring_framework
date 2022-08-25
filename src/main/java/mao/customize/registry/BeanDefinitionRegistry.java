package mao.customize.registry;

import mao.customize.pojo.BeanDefinition;

/**
 * Project name(项目名称)：java设计模式_自定义Spring框架
 * Package(包名): mao.customize.registry
 * Interface(接口名): BeanDefinitionRegistry
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/25
 * Time(创建时间)： 15:16
 * Version(版本): 1.0
 * Description(描述)： BeanDefinitionRegistry接口定义了注册表的相关操作
 */

public interface BeanDefinitionRegistry
{
    /**
     * 注册BeanDefinition对象到注册表中
     *
     * @param beanName       bean的名称（bean的id属性）
     * @param beanDefinition BeanDefinition对象
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 从注册表中删除指定名称的BeanDefinition对象
     *
     * @param beanName bean的名称（bean的id属性）
     * @throws Exception 异常
     */
    void removeBeanDefinition(String beanName) throws Exception;

    /**
     * 根据名称从注册表中获取BeanDefinition对象
     *
     * @param beanName bean的名称（bean的id属性）
     * @return BeanDefinition对象
     * @throws Exception 异常
     */
    BeanDefinition getBeanDefinition(String beanName) throws Exception;

    /**
     * 根据bean的名称判断是否包含指定的BeanDefinition对象
     *
     * @param beanName bean的名称（bean的id属性）
     * @return boolean类型
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回BeanDefinition的个数
     *
     * @return BeanDefinition的个数，int型
     */
    int getBeanDefinitionCount();

    /**
     * 获取所有的名称列表
     *
     * @return String数组
     */
    String[] getBeanDefinitionNames();
}
