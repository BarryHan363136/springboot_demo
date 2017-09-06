package com.iris.study.springboot.utils;

import com.alibaba.fastjson.JSON;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;

public class JsoupTest {

    private static final Logger logger = LoggerFactory.getLogger(JsoupTest.class);

    @Test
    public void testparseHtml(){
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Document document = Jsoup.parse(html);
        logger.info("获取document信息,doc:"+ JSON.toJSONString(document));
        String title = document.title();
        logger.info("====================>title:"+title);
        logger.info("====================>body-text:"+document.body().text());
    }

    @Test
    public void  AnalysisHTMLByString(){
        String  html = "<p><a href=\"a.html\">a</p><p> 文本</p>";
        Document doc = Jsoup.parse(html);
        Elements ele = doc.getElementsByTag("p");
        for(Element e : ele){
            logger.info(e.text());
        }
    }

    @Test
    public void AnlysisHTMLByFile() throws IOException {
        File file=new File(System.getProperty("user.dir")+"\\a.html");
        Document doc=Jsoup.parse(file, "UTF-8");
        Elements eles=doc.getElementsByTag("a");
        for(Element e :eles){
            logger.info(e.text());
            logger.info(e.attr("href"));
        }
        Element ele =doc.getElementById("btn");
        logger.info(ele.html());
    }

    @Test
    public void  AnlysisHTMLByURL() throws IOException {
        int  timeout=3000;
        Document doc=  Jsoup.connect("http://www.cnblogs.com/rhythmK/").get();
        //获取A标签个数
        logger.info("共有超链接："+ doc.getElementsByTag("a").size());
        logger.info("获取指定ID:"+ doc.getElementById("navigator").html());
        Elements eles= doc.select("#navigator");
        for(Element ele :eles){
            logger.info("=================>"+ele.html());
        }
    }

    @Test
    public void testParseUrl(){

        try {
            Document document = Jsoup.connect("").get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
