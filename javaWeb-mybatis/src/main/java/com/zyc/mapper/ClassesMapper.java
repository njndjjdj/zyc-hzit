package com.zyc.mapper;

import com.zyc.entity.Classes;

import java.util.List;

/**
 * 作者:ZYC
 * DATE:2024/8/5
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:
 */
public interface ClassesMapper {
    /**
     * 查询所有班级信息
     * @return
     */
    List<Classes> findAllClasses();
}
