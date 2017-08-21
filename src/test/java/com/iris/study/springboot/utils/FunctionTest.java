package com.iris.study.springboot.utils;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by hantongshan on 2017/8/10.
 */
public class FunctionTest {

    private static final Logger logger = LoggerFactory.getLogger(FunctionTest.class);

    @Test
    public void testThreads(){
        List<StatisticalReport> list = new ArrayList<StatisticalReport>();
        StatisticalReport statisticalReport = new StatisticalReport();
        ReportData reportData = new ReportData();
        reportData.setItem("总计");
        reportData.setT1DingDan("135");
        statisticalReport.setReportData(reportData);
        List<ReportData> list1 = new ArrayList<>();
        ReportData reportData2 = new ReportData();
        reportData2.setItem("车型1");
        reportData2.setT1DingDan("112");
        list1.add(reportData2);
        statisticalReport.setReportDataList(list1);
        list.add(statisticalReport);
        logger.info("===============>"+ JSON.toJSONString(list));
    }

}
