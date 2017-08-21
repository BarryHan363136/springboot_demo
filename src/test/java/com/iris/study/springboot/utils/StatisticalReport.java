package com.iris.study.springboot.utils;

import java.io.Serializable;
import java.util.List;

public class StatisticalReport implements Serializable {

    private static final long serialVersionUID = -5757776992911541502L;

    private ReportData reportData;

    private List<ReportData> reportDataList;

    public ReportData getReportData() {
        return reportData;
    }

    public void setReportData(ReportData reportData) {
        this.reportData = reportData;
    }

    public List<ReportData> getReportDataList() {
        return reportDataList;
    }

    public void setReportDataList(List<ReportData> reportDataList) {
        this.reportDataList = reportDataList;
    }

}
