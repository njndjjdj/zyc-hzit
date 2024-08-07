package com.zyc.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 作者:ZYC
 * DATE:2024/8/3
 * 快捷键:ctrl+alt+l自动格式化 alt+a/w光标移至行首/行尾 alt+s 转换大小写
 * use:
 */
@Getter
@AllArgsConstructor
public enum ResponseEnum {
    SUCCESS(0,"成功"),
    ERROR(-1,"失败");

    private Integer code;
    private String message;
}

