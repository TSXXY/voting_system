package com.tan.voting_system.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author TanShan
 * @date 2022/12/27 21:02
 */
public class JDBCUtils {
    private static final DruidDataSource druidDataSource;

    static {

        try {
            Properties properties = new Properties();
            //从配置文件里面获得相应配置
            InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(resourceAsStream);
            //创建德鲁伊链接池
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //获取连接对象
    public static Connection getConnection() {

        try {
            return druidDataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //关闭连接对象
    public static void close(AutoCloseable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
