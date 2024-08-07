package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作者:ZYC
 * DATE:2024/8/3
 * 快捷键:ctrl+alt+l自动格式化 alt+a/w光标移至行首/行尾 alt+s 转换大小写
 * use:广告内容实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private int id;
    private Integer category_id;
    private String title;
    private String url;
    private String pic;
    private Integer status;
    private Integer sort_order;
}
