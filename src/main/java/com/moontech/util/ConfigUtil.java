package com.moontech.util;

import java.io.IOException;
import java.util.Properties;

/**
 * @description 读取配置文件，识别配置   多线程
 * Created by leslie on 2018/6/17.
 */
public class ConfigUtil {
    /**
     * 是否持久化到数据库
     */
    public static boolean dbEnable;
    /**
     * 是否使用代理抓取
     */
    public static boolean isProxy;
    /**
     * 下载网页线程数
     */
    public static int downloadThreadSize;
    /**
     * 验证码路径
     */
    public static String verificationCodePath;

    /**
     * 爬虫入口
     */
    public static String  startURL;

    public static String startUserToken;
    /**
     * 下载网页数
     */
    public static int downloadPageCount;
    /**
     * db.name
     */
    public static String dbName;
    /**
     * db.username
     */
    public static String dbUsername;
    /**
     * db.host
     */
    public static String dbHost;
    /**
     * db.password
     */
    public static String dbPassword;
    /**
     * 创建Url表语句
     */
    public static String createUrlTable;

    /**
     * 创建user表语句
     */
    public static String createUserTable;

    /**
     * cookie路径
     */
    public static String cookiePath;
    /**
     * proxyPath
     */
    public static String proxyPath;
    static {
        Properties p = new Properties();
        try {// 读取配置文件
            p.load(ConfigUtil.class.getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dbEnable = Boolean.parseBoolean(p.getProperty("db.enable"));
        verificationCodePath = p.getProperty("verificationCodePath");
        startURL = p.getProperty("startURL");
        startUserToken = p.getProperty("startUserToken");
        downloadPageCount = Integer.valueOf(p.getProperty("downloadPageCount"));
        downloadThreadSize = Integer.valueOf(p.getProperty("downloadThreadSize"));
        cookiePath = p.getProperty("cookiePath");
        proxyPath = p.getProperty("proxyPath");
        isProxy = Boolean.valueOf(p.getProperty("isProxy"));
        if (dbEnable){
            dbName = p.getProperty("db.name");
            dbHost = p.getProperty("db.host");
            dbUsername = p.getProperty("db.username");
            dbPassword = p.getProperty("db.password");
            createUrlTable = p.getProperty("createUrlTable");
            createUserTable = p.getProperty("createUserTable");
        }
    }
}
