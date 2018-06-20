package com.moontech.util;

import java.util.ArrayList;
import java.util.List;

import com.moontech.entity.Page;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;
import com.moontech.entity.HouseModel;
import com.moontech.parser.HtmlParser;
/**
 * @author chenxw
 * @create 2018-06-01
 * @description  爬取实体 html或者json
 */
public class URLFecter {
    public static List<HouseModel> URLParser (HttpClient client, String url) throws Exception {
        // 页面转换
        Page page = new Page();
        //用来接收解析的数据
        List<HouseModel> parserData = new ArrayList<HouseModel>();
        //获取网站响应的html，这里调用了HTTPUtils类
        HttpResponse response = HTTPUtil.getRawHtml(client, url);
        page.setUrl(url);
        //获取响应状态码
        int StatusCode = response.getStatusLine().getStatusCode();
        page.setStatusCode(StatusCode);

        //如果状态响应码为200，则获取html实体内容或者json文件
        if(StatusCode == 200){
            String htmlEntity = EntityUtils.toString (response.getEntity(),"utf-8"); // 转换utf-8编码
            page.setHtml(htmlEntity);
            //输出实体内容，不会乱码，乱码解决办法。由于数据是通过zip压缩的
//            GzipDecompressingEntity zipRes = new GzipDecompressingEntity(response.getEntity());
//            String s = EntityUtils.toString(zipRes, "gb2312");
            // 获取解析数据
            parserData = HtmlParser.getData(page);
            EntityUtils.consume(response.getEntity());
        }else {
            //否则，消耗掉实体(消费者)  关闭HttpEntity的流实体
            EntityUtils.consume(response.getEntity());
        }
        return parserData;
    }
}