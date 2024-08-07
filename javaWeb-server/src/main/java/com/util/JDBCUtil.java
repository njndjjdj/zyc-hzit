package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * 作者:ZYC
 * DATE:2024/8/3
 * 快捷键:ctrl+alt+l自动格式化 alt+a/w光标移至行首/行尾 alt+s 转换大小写
 * use:
 */
public class JDBCUtil {
    private static String driver = "";
    private static String url = "";
    private static String user = "";
    private static String password = "";

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        driver = bundle.getString("jdbc.driver");
        url = bundle.getString("jdbc.url");
        user = bundle.getString("jdbc.user");
        password = bundle.getString("jdbc.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getCon() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
