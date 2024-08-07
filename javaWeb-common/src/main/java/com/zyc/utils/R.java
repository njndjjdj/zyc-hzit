package com.zyc.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者:ZYC
 * DATE:2024/8/3
 * 快捷键:ctrl+alt+l自动格式化 alt+a/w光标移至行首/行尾 alt+s 转换大小写
 * use:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R {
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    //1. 成功时的方法
    public static R ok() {
        R r = new R();
        r.setCode(ResponseEnum.SUCCESS.getCode());
        r.setMessage(ResponseEnum.SUCCESS.getMessage());
        return r;
    }

    //2. 失败时的调用方法
    public static R error() {
        R r = new R();
        r.setCode(ResponseEnum.ERROR.getCode());
        r.setMessage(ResponseEnum.ERROR.getMessage());
        return r;
    }

    //3. 设置其它的响应结果
    public static R setResult(ResponseEnum responseEnum) {
        R r = new R();
        r.setCode(responseEnum.getCode());
        r.setMessage(responseEnum.getMessage());
        return r;
    }

    // 4. 修改出错信息
    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    // 5. 修改错误码
    public R code(Integer code) {
        this.setCode(code);
        return this;
    }

    //4. 设置添加数据
    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}
