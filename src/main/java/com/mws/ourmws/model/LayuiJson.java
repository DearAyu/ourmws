package com.mws.ourmws.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LayuiJson {
    private int code;
    private String msg;
    private long count;
    private List data=new ArrayList();

    public static LayuiJson success(long count){
        LayuiJson result=new LayuiJson();
        result.setCode(0);
        result.setMsg("处理成功!");
        result.setCount(count);
        return result;
    }

    public static LayuiJson fail(){
        LayuiJson result=new LayuiJson();
        result.setCode(100);
        result.setMsg("处理失败!");
        return result;
    }

    public LayuiJson add(List value){
        this.data=value;
        return this;
    }
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

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
