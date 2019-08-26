package com;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author hx
 * @date 2019-08-23 12:18
 */
public class DataSourceUtils {

    //创建私有静态数据源成员变量
    private static DataSource ds;

    //在静态代码块中连接池
    static {
        //创建属性对象
        Properties info = new Properties();
        try(InputStream in = DataSourceUtils.class.getResourceAsStream("/druid.properties")){
        //从类路径下加载属性文件，得到输入流对象
            info.load(in);
            //通过工厂类创建一个数据源
            ds = DruidDataSourceFactory.createDataSource(info);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){
        return ds;
    }

    public static Connection getConnection() throws SQLException{
        return ds.getConnection();
    }

}
