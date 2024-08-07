package com.zyc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作者:ZYC
 * DATE:2024/8/5
 * 快捷键:ctrl+alt+l自动格式化 alt+a/w光标移至行首/行尾 alt+s 转换大小写
 * use:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String stuno;
    private String stuname;
    private String classno;
    private String sex;
    private Integer age;
}