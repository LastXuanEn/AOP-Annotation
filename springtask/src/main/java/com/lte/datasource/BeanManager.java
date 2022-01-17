package com.lte.datasource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Auther: laite
 * @Date: 2022/1/18 - 01 - 18 - 0:15
 * @Description: com.lte.datasource
 * @version: 1.0
 */
public class BeanManager {
    //这是一个main方法，程序的入口
    public static void main(String[] args) throws SQLException {
        //加载配置文件 src下的一级目录
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //获取连接池
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        //获取连接
        Connection connection = dataSource.getConnection();
        //sql语句
        String sql = "select * from user";
        //预编译
        PreparedStatement statement = connection.prepareStatement(sql);
        //执行
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            System.out.println("username:" + resultSet.getString(1));
            System.out.println("parssword:" + resultSet.getString(2));
            System.out.println("id:" + resultSet.getInt(3));
            System.out.println("realname:" + resultSet.getString(4));
        }

    }
}
