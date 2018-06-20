package com.moontech.dao;

import com.moontech.db.ConnectionManager;
import com.moontech.entity.HouseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by leslie on 2018/6/17.
 */
public class HouseDaoImp implements  HouseDao {
    private static Logger logger = LoggerFactory.getLogger(HouseDao.class);


    public static void DBTablesInit() {
        ResultSet rs = null;
        Properties p = new Properties();
        Connection cn = ConnectionManager.getConnection();
        try {
            //加载properties文件
            p.load(HouseDaoImp.class.getResourceAsStream("/config.properties"));
            rs = cn.getMetaData().getTables(null, null, "url", null);
            Statement st = cn.createStatement();
            //不存在url表
            if(!rs.next()){
                //创建url表
                st.execute(p.getProperty("createUrlTable"));
                logger.info("url表创建成功");
//                st.execute(p.getProperty("createUrlIndex"));
//                logger.info("url表索引创建成功");
            }
            else{
                logger.info("url表已存在");
            }
            rs = cn.getMetaData().getTables(null, null, "user_house_content", null);
            //不存在user_house_content表
            if(!rs.next()){
                //创建user表
                st.execute(p.getProperty("createHouseTable"));
                logger.info("user_house_content表创建成功");
//                st.execute(p.getProperty("createHouseModelIndex"));
//                logger.info("user表索引创建成功");
            }
            else{
                logger.info("user_house_content表已存在");
            }
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isExistRecord(String sql) throws SQLException {
        return isExistRecord(ConnectionManager.getConnection(), sql);
    }

    public boolean isExistRecord(Connection cn, String sql) throws SQLException {
        int num = 0;
        PreparedStatement pstmt;
        pstmt = cn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            num = rs.getInt("count(*)");
        }
        rs.close();
        pstmt.close();
        if(num == 0){
            return false;
        }else{
            return true;
        }
    }

    public boolean isExistHouse(String houseId) {
        return isExistHouse(ConnectionManager.getConnection(), houseId);
    }

    public boolean isExistHouse(Connection cn, String houseId) {
        String isContainSql = "select count(*) from user_house_content WHERE house_id ='" + houseId + "'";
        try {
            if(isExistRecord(isContainSql)){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertHouseModel(HouseModel houseModel) {
        return insertHouseModel(ConnectionManager.getConnection(), houseModel);
    }

    public boolean insertHouseModel(Connection cn, HouseModel houseModel) {
        String houseId = houseModel.getHouseId();
        try {
            if(isExistHouse(houseId)){ // 如果数据库存在，则不再插入
                return  false;
            }
            String column = "house_id,house_name,house_type,house_selling,house_address,house_area,house_price,house_total_price";
            String values = "?,?,?,?,?,?,?,?";
            String sql = "insert into user_house_content (" + column + ") values(" +values+")";
            PreparedStatement pstmt;
            pstmt = cn.prepareStatement(sql);
            pstmt.setString(1,houseModel.getHouseId());
            pstmt.setString(2,houseModel.getHouseName());
            pstmt.setString(3,houseModel.getHouseType());
            pstmt.setString(4,houseModel.getHouseSelling());
            pstmt.setString(5,houseModel.getHouseAddress());
            pstmt.setString(6,houseModel.getHouseArea());
            pstmt.setString(7,houseModel.getHousePrice());
            pstmt.setString(8,houseModel.getHouseTotalPrice());
            pstmt.executeUpdate();
            pstmt.close();
            logger.info("插入数据库成功---" + houseModel.getHouseName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            ConnectionManager.close();
        }
        return true;
    }

    public boolean insertUrl(Connection cn, String md5Url) {
        return false;
    }


}
