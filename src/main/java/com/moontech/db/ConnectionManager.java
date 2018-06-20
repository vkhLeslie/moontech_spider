package com.moontech.db;

import com.moontech.util.ConfigUtil;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @description 数据库连接管理
 * @author chenxw
 * Created by leslie on 2018/6/17.
 */

public class ConnectionManager {
    private static Logger logger = LoggerFactory.getLogger(ConnectionManager.class);
    private static Connection conn;
    public static Connection getConnection(){
        //获取数据库连接
        try {
            if(conn == null || conn.isClosed()){
                conn = createConnection();
            }
            else{
                return conn;
            }
        } catch (SQLException e) {
            logger.error("SQLException",e);
        }
        return conn;
    }
    static {
        try {
            Class.forName("org.gjt.mm.mysql.Driver") ;//加载驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static void close(){
        if(conn != null){
            logger.info("关闭连接中");
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error("SQLException",e);
            }
        }
    }
    public static Connection createConnection(){
        String host = ConfigUtil.dbHost; // ip
        String user = ConfigUtil.dbUsername;  //  用户名
        String password = ConfigUtil.dbPassword;  // 密码
        String dbName = ConfigUtil.dbName;  // 数据库名称
        String url="jdbc:mysql://" + host + ":3306/" + dbName + "?characterEncoding=utf8&useSSL=false";
        Connection con=null;
        try{
            con = DriverManager.getConnection(url,user,password);//建立mysql的连接
            logger.debug("success!");
        } catch(MySQLSyntaxErrorException e){
            logger.error("数据库不存在..请先手动创建创建数据库:" + dbName);
            e.printStackTrace();
        } catch(SQLException e2){
            logger.error("SQLException",e2);
        }
        return con;
    }
    public static void main(String [] args) throws Exception{
        getConnection();
        getConnection();
        close();
    }
}
