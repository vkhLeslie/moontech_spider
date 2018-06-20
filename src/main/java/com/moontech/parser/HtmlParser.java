package com.moontech.parser;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import com.moontech.entity.Page;
import com.moontech.util.MD5Util;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.moontech.entity.HouseModel;
/**
 * @author chenxw
 * 用于将上面传下来的html解析，获取我们需要的内容
 * 解析方式，采用Jsoup解析，有不明白Jsoup的可以上网搜索API文档
 * Jsoup是一款很简单的html解析器
 */
public class HtmlParser {

    private static HtmlParser instance;
    public static HtmlParser getInstance(){
        if (instance == null){
            synchronized (HtmlParser.class){
                if (instance == null){
                    instance = new HtmlParser();
                }
            }
        }
        return instance;
    }

    public static List<HouseModel> getData (Page page) throws Exception{ // String html
        //获取的数据，存放在集合中
        List<HouseModel> data = new ArrayList<HouseModel>();
        //采用Jsoup解析 获取html
        Document doc = Jsoup.parse(page.getHtml());
        //json数据
        String baseJsonPath = "$.data.length()";

//        System.out.print(doc);
        //获取html标签中的内容
        Elements elements=doc.select("ul[class=resblock-list-wrapper]").select("li[class=resblock-list]");

        for (Element ele:elements) {
            // 数据内容格式转换实体
            //创建一个对象，这里可以看出，使用Model的优势，直接进行封装
            HouseModel  houseModel  = new HouseModel();
//            String commonJsonPath = "$.data[" + i + "]";
//            setDataByJsonPth(houseModel, "houseName", doc, commonJsonPath + ".houseName");
//            setDataByJsonPth(houseModel, "houseType", doc, commonJsonPath + ".id");
//            setDataByJsonPth(houseModel, "houseSelling", doc, commonJsonPath + ".followingCount");
//            setDataByJsonPth(houseModel, "houseAddress", doc, commonJsonPath + ".locations[0].name");
//            setDataByJsonPth(houseModel, "houseArea", doc, commonJsonPath + ".business.name");
//            setDataByJsonPth(houseModel, "housePrice", doc, commonJsonPath + ".employments[0].company.name");
//            setDataByJsonPth(houseModel, "houseTotalPrice", doc, commonJsonPath + ".employments[0].job.name");

            String houseName=ele.select("a[class=name]").text();
            String houseType=ele.select("span[class=resblock-type]").text();
            String houseSelling=ele.select("span[class=sale-status]").text();
            String houseAddress=ele.select("div[class=resblock-location]").select("a").text();
            String houseArea=ele.select("div[class=resblock-area").select("span").text();
            String housePrice=ele.select("div[class=main-price").select("span[class=number]").text();
            String houseTotalPrice=ele.select("div[class=second]").text();
            Thread.sleep(1000);
            Date nowTime = new Date(System.currentTimeMillis());
            SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
            String retStrFormatNowDate = sdFormatter.format(nowTime);
            String houseId = MD5Util.Convert2Md5(retStrFormatNowDate);
            houseModel.setHouseId(houseId);
            //对象的值
            houseModel.setHouseName(houseName);
            houseModel.setHouseType(houseType);
            houseModel.setHouseSelling(houseSelling);
            houseModel.setHouseAddress(houseAddress);
            houseModel.setHouseArea(houseArea);
            houseModel.setHousePrice(housePrice);
            houseModel.setHouseTotalPrice(houseTotalPrice);

            //将每一个对象的值，保存到List集合中
            data.add(houseModel);
        }
        //返回数据
        return data;
    }

    /**
     * jsonPath获取值，并通过反射直接注入到实体类中
     * @param houseModel
     * @param fieldName
     * @param doc
     * @param jsonPath
     */
    private void setDataByJsonPth(HouseModel houseModel, String fieldName, DocumentContext doc , String jsonPath){
        try {
            Object o = JsonPath.parse(doc).read(jsonPath);
            Field field = houseModel.getClass().getDeclaredField(fieldName);
            // 取消Java的权限控制检查
            field.setAccessible(true);
            field.set(houseModel, o);
        } catch (PathNotFoundException e1) {
            //no results
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}