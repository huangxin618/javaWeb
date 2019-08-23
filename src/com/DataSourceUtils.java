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

    private static DataSource ds;
    static {
        Properties info = new Properties();
        try(InputStream in = DataSourceUtils.class.getResourceAsStream("/druid.properties")){
            info.load(in);
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
