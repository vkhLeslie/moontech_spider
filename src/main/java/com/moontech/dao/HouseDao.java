package com.moontech.dao;

import com.moontech.entity.HouseModel;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by leslie on 2018/6/17.
 */
public interface HouseDao {
    boolean isExistRecord(String sql) throws SQLException;
    boolean isExistRecord(Connection cn, String sql) throws SQLException;

    boolean isExistHouse(String houseId);
    boolean isExistHouse(Connection cn, String houseId);

    boolean insertHouseModel(HouseModel houseModel);
    boolean insertHouseModel(Connection cn, HouseModel houseModel);

    /**
     * 插入url,插入成功返回true，若已存在该url则返回false
     * @param cn
     * @param md5Url
     * @return
     */
    boolean insertUrl(Connection cn, String md5Url);
}
