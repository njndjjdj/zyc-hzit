package com.zyc.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

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
public class MySqlSessionFactory {
    // 获取SqlSessionFactory
    private static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return (SqlSessionFactory) new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 获取sqlsession
     * @param autoCommit 是否自动提交事务
     * @return
     * @throws IOException
     */
    public static SqlSession getSqlSession(boolean autoCommit) throws IOException {
        return getSqlSessionFactory().openSession(autoCommit);
    }
}