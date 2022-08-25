package mao.customize_use;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Project name(项目名称)：java设计模式_自定义Spring框架
 * Package(包名): mao.use
 * Class(类名): UserDaoImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/24
 * Time(创建时间)： 20:47
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class UserDaoImpl implements UserDao
{
    private static final Log log = LogFactory.getLog(UserDaoImpl.class);

    @Override
    public void add()
    {
        log.info("UserDaoImpl(自定义spring)");
    }
}
