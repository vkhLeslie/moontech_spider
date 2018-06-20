package com.moontech.entity;

/**
 * @description 此实体类获取数据是html 还是 json
 * Created by leslie on 2018/6/17.
 */
public class Page {
    private String url;
    private int statusCode;//响应状态码
    private String html;//response content
//    private Proxy proxy;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

//    public Proxy getProxy() {
//        return proxy;
//    }
//
//    public void setProxy(Proxy proxy) {
//        this.proxy = proxy;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Page page = (Page) o;

        return url.equals(page.url);
    }

    @Override
    public int hashCode() {
        return url.hashCode();
    }
}