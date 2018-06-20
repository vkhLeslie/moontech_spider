package com.moontech.entity;
/**
 * @author chenxw
 * @create 2018-06-01
 * @description  爬取实体
 */
public class HouseModel {
    private int id;
    private String houseId;
    private String houseName;
    private String houseType;
    private String houseSelling;
    private String houseAddress;
    private String houseArea;
    private String housePrice;
    private String houseTotalPrice;
    private String createTime;

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getHouseSelling() {
        return houseSelling;
    }

    public void setHouseSelling(String houseSelling) {
        this.houseSelling = houseSelling;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea;
    }

    public String getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(String housePrice) {
        this.housePrice = housePrice;
    }

    public String getHouseTotalPrice() {
        return houseTotalPrice;
    }

    public void setHouseTotalPrice(String houseTotalPrice) {
        this.houseTotalPrice = houseTotalPrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserComment{" +
                "id='" + id + '\'' +
                ", houseId='" + houseId + '\'' +
                ", houseName=" + houseName +
                ", houseType=" + houseType +
                ", houseSelling=" + houseSelling +
                ", houseAddress=" + houseAddress +
                ", houseArea='" + houseArea + '\'' +
                ", housePrice=" + housePrice +
                ", houseTotalPrice=" + houseTotalPrice +
                ", createTime='" + createTime + '\'' +
                '}';
    }

}