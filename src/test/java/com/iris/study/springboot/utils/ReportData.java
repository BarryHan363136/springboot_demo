package com.iris.study.springboot.utils;

import java.io.Serializable;

public class ReportData implements Serializable {

    private static final long serialVersionUID = 703595618233862643L;

    /**
     * 第一张表格的数据
     */
    /** 左侧统计中文显示 */
    private String item;

    /** 新增进店 */
    private String t1XinZengJInDian;

    /** 二次进店 */
    private String t1ErCiJinDian;

    /** 订单数 */
    private String t1DingDan;

    /** 交车 */
    private String t1JiaoChe;

    /** 订单 */
    private String t1DingDan2;

    /** 订单率 */
    private String t1DingDanLv;

    /** 留存 */
    private String t1LiuCun;

    /**
     * 第二张表格的数据
     */
    /** 新增进店 */
    private String t2XinZengJInDian;

    /** 二次进店 */
    private String t2ErCiJinDian;

    /** 二次进店率 */
    private String t2ErCiJinDianLv;

    /** 交车 */
    private String t2JiaoChe;

    /** 订单支付率 */
    private String t2DingDanZhiFuLv;

    /** 试驾数 */
    private String t2ShiJiaShu;

    /** 试驾率 */
    private String t2ShiJiaLv;

    /**
     * 第三张表格的数据
     */
    /** 退订 */
    private String t3TuiDing;

    /** 退订率 */
    private String t3TuiDingLv;

    /** 信息上传数 */
    private String t3XinxiShangChuanShu;

    /** 信息上传率 */
    private String t3XinxiShangChuanLv;

    /** 问卷填写 */
    private String t3WenJuanTianXie;

    /** 问卷填写率 */
    private String t3WenJuanTianXieLv;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getT1XinZengJInDian() {
        return t1XinZengJInDian;
    }

    public void setT1XinZengJInDian(String t1XinZengJInDian) {
        this.t1XinZengJInDian = t1XinZengJInDian;
    }

    public String getT1ErCiJinDian() {
        return t1ErCiJinDian;
    }

    public void setT1ErCiJinDian(String t1ErCiJinDian) {
        this.t1ErCiJinDian = t1ErCiJinDian;
    }

    public String getT1DingDan() {
        return t1DingDan;
    }

    public void setT1DingDan(String t1DingDan) {
        this.t1DingDan = t1DingDan;
    }

    public String getT1JiaoChe() {
        return t1JiaoChe;
    }

    public void setT1JiaoChe(String t1JiaoChe) {
        this.t1JiaoChe = t1JiaoChe;
    }

    public String getT1DingDan2() {
        return t1DingDan2;
    }

    public void setT1DingDan2(String t1DingDan2) {
        this.t1DingDan2 = t1DingDan2;
    }

    public String getT1DingDanLv() {
        return t1DingDanLv;
    }

    public void setT1DingDanLv(String t1DingDanLv) {
        this.t1DingDanLv = t1DingDanLv;
    }

    public String getT1LiuCun() {
        return t1LiuCun;
    }

    public void setT1LiuCun(String t1LiuCun) {
        this.t1LiuCun = t1LiuCun;
    }

    public String getT2XinZengJInDian() {
        return t2XinZengJInDian;
    }

    public void setT2XinZengJInDian(String t2XinZengJInDian) {
        this.t2XinZengJInDian = t2XinZengJInDian;
    }

    public String getT2ErCiJinDian() {
        return t2ErCiJinDian;
    }

    public void setT2ErCiJinDian(String t2ErCiJinDian) {
        this.t2ErCiJinDian = t2ErCiJinDian;
    }

    public String getT2ErCiJinDianLv() {
        return t2ErCiJinDianLv;
    }

    public void setT2ErCiJinDianLv(String t2ErCiJinDianLv) {
        this.t2ErCiJinDianLv = t2ErCiJinDianLv;
    }

    public String getT2JiaoChe() {
        return t2JiaoChe;
    }

    public void setT2JiaoChe(String t2JiaoChe) {
        this.t2JiaoChe = t2JiaoChe;
    }

    public String getT2DingDanZhiFuLv() {
        return t2DingDanZhiFuLv;
    }

    public void setT2DingDanZhiFuLv(String t2DingDanZhiFuLv) {
        this.t2DingDanZhiFuLv = t2DingDanZhiFuLv;
    }

    public String getT2ShiJiaShu() {
        return t2ShiJiaShu;
    }

    public void setT2ShiJiaShu(String t2ShiJiaShu) {
        this.t2ShiJiaShu = t2ShiJiaShu;
    }

    public String getT2ShiJiaLv() {
        return t2ShiJiaLv;
    }

    public void setT2ShiJiaLv(String t2ShiJiaLv) {
        this.t2ShiJiaLv = t2ShiJiaLv;
    }

    public String getT3TuiDing() {
        return t3TuiDing;
    }

    public void setT3TuiDing(String t3TuiDing) {
        this.t3TuiDing = t3TuiDing;
    }

    public String getT3TuiDingLv() {
        return t3TuiDingLv;
    }

    public void setT3TuiDingLv(String t3TuiDingLv) {
        this.t3TuiDingLv = t3TuiDingLv;
    }

    public String getT3XinxiShangChuanShu() {
        return t3XinxiShangChuanShu;
    }

    public void setT3XinxiShangChuanShu(String t3XinxiShangChuanShu) {
        this.t3XinxiShangChuanShu = t3XinxiShangChuanShu;
    }

    public String getT3XinxiShangChuanLv() {
        return t3XinxiShangChuanLv;
    }

    public void setT3XinxiShangChuanLv(String t3XinxiShangChuanLv) {
        this.t3XinxiShangChuanLv = t3XinxiShangChuanLv;
    }

    public String getT3WenJuanTianXie() {
        return t3WenJuanTianXie;
    }

    public void setT3WenJuanTianXie(String t3WenJuanTianXie) {
        this.t3WenJuanTianXie = t3WenJuanTianXie;
    }

    public String getT3WenJuanTianXieLv() {
        return t3WenJuanTianXieLv;
    }

    public void setT3WenJuanTianXieLv(String t3WenJuanTianXieLv) {
        this.t3WenJuanTianXieLv = t3WenJuanTianXieLv;
    }





}
