package com.moontech.main;

import java.sql.Connection;
import java.util.List;

import com.moontech.dao.HouseDaoImp;
import com.moontech.db.ConnectionManager;
import com.moontech.util.ConfigUtil;
import com.moontech.util.ConstantsUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
//import org.apache.commons.httpclient.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import com.moontech.db.MYSQLController;
import com.moontech.entity.HouseModel;
import com.moontech.util.URLFecter;
import org.apache.http.impl.client.HttpClients;

/**
 * @author chenxw
 * @create 2018-06-01
 * @description 爬虫主入口
 */
public class SpiderMain {
    //log4j的是使用
    static final Log logger = LogFactory.getLog(SpiderMain.class);

    public static void main(String[] args) throws Exception {
        //初始化一个httpclient
        HttpClient client = new DefaultHttpClient();
//        HttpClient httpClient = new HttpClient();
        // 初始化数据持久化
        if(ConfigUtil.dbEnable){
            HouseDaoImp.DBTablesInit();
        }
        HouseDaoImp houseDaoImp = new HouseDaoImp();
        Connection cn = null;
        // 我们要爬取的一个地址，这里可以从数据库中抽取数据，然后利用循环，可以爬取一个URL队列 测试
        // 抓取的数据 爬取路径 ConstantsUtil.HOUSE_URL
        List<HouseModel> datas = null;
        datas = URLFecter.URLParser(client, ConstantsUtil.HOUSE_LIST_URL);
        //循环输出抓取的数据
        for (HouseModel houseModel : datas) {
            logger.info("解析数据成功:" + houseModel.toString());
            //将抓取的数据插入数据库
            if(ConfigUtil.dbEnable) { // 数据保存，存mysql
                cn = ConnectionManager.createConnection();
                houseDaoImp.insertHouseModel(cn, houseModel);
                //        MYSQLController.executeInsert(datas);
            }
        }
    }

}