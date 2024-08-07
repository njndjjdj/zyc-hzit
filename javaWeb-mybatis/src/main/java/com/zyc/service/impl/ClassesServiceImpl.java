package com.zyc.service.impl;

import com.zyc.entity.Classes;
import com.zyc.mapper.ClassesMapper;
import com.zyc.service.ClassesService;
import com.zyc.utils.MySqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.Collections;
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
public class ClassesServiceImpl implements ClassesService {

    /**
     * 查询所有班级信息
     *
     * @return
     */
    @Override
    public List<Classes> findAllClasses() throws IOException {
        try (SqlSession sqlSession = MySqlSessionFactory.getSqlSession(true)) {
            ClassesMapper mapper = sqlSession.getMapper(ClassesMapper.class);
            List<Classes> classesList = mapper.findAllClasses();
            return classesList;
        }
    }
}
