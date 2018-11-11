package com.hykj.liuzhi.androidcomponents.bean;

import java.util.List;

/**
 * @author: lujialei
 * @date: 2018/11/11
 * @describe:
 */


public class BannerBean {

    /**
     * code : 0
     * msg : 访问成功
     * data : [{"sowing_url":"123.jpg"}]
     * total : 1
     * amount : 1
     * page : 1
     * number : 10
     */

    private int code;
    private String msg;
    private int total;
    private int amount;
    private int page;
    private int number;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * sowing_url : 123.jpg
         */

        private String sowing_url;

        public String getSowing_url() {
            return sowing_url;
        }

        public void setSowing_url(String sowing_url) {
            this.sowing_url = sowing_url;
        }
    }
}
