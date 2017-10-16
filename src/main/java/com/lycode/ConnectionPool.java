package com.lycode;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    //数据源接口
    private DataSource ds;
    //连接池，目的在于判断是否已经存在连接池用
    private static ConnectionPool pool;
    //在构造方法中为数据源接口定义实现（该数据源已经使用了C3P0连接池）
    private ConnectionPool(){
        ds=new ComboPooledDataSource();
    }
    //单例模式创建连接池（连接池只需要一个即可）
    public static final ConnectionPool getInstance(){
        if(pool==null){
            pool=new ConnectionPool();
        }
        return pool;
    }
    //通过已经建立好的数据源获取连接
    public synchronized final Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}