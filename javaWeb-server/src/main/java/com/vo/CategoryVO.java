package com.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作者:ZYC
 * DATE:2024/8/3
 * 快捷键:ctrl+alt+l自动格式化 alt+a/w光标移至行首/行尾 alt+s 转换大小写
 * use:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVO {

    // 广告id
    private Integer categoryId;
    // 分类id
    private Integer sortId;
    // 标题
    private String title;
    // url
    private String url;
    // 广告图片
    private String pic;
    // 状态
    private String status;
    // 分类名称
    private String sortName;

    public String getStatus(Integer s) {
        if (s.equals(1)) {
            return "启用";
        }
        return "禁用";
    }
}
