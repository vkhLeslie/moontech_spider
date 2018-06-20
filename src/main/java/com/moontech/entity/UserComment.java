package com.moontech.entity;

/**
 * @description 评论实体
 * Created by leslie on 2018/6/17.
 */
public class UserComment {
    // id
    private int id;
    // 订单id
    private String orderId;
    //用户id
    private String userId;
    //用户名
    private String username;
    //用户电话
    private String mobile;
    // 用户省份
    private String provinceName;
    //用户城市
    private String cityName;
    // 用户详细地址
    private String location;
    //性别
    private String sex;
    // 商品品类
    private String goodType;
    // 商品型号
    private String productName;
    // 商品价格
    private String price;
    // 商铺
    private String shopName;
    // 评论
    private String comment;
    // 评论时间
    private String commentTime;
    // 付款时间
    private String payTime;
    // 创建时间
    private String createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
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
                "orderId='" + orderId + '\'' +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", cityName=" + cityName +
                ", location=" + location +
                ", sex=" + sex +
                ", goodType=" + goodType +
                ", productName=" + productName +
                ", price=" + price +
                ", shopName=" + shopName +
                ", comment='" + comment + '\'' +
                ", commentTime=" + commentTime +
                ", payTime=" + payTime +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
