package com.zyc;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.entity.Category;
import com.entity.Sort;
import com.util.JDBCUtil;
import com.vo.CategoryVO;
import com.zyc.utils.R;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 作者:ZYC
 * DATE:2024/8/3
 * 快捷键:ctrl+alt+l自动格式化 alt+a/w光标移至行首/行尾 alt+s 转换大小写
 * use:
 */
@WebServlet("/findAll")
public class TestServlet extends HttpServlet {
    private List<Category> categoryList = new ArrayList<>();
    private List<Sort> sortList = new ArrayList<>();
    private List<CategoryVO> categoryVOList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        System.out.println("init...");
        /*
        广告实例
         */
        Category c1 = new Category(5, 1, "test广告1", "hdashasdhahl", "aodsoahdasdlaskdl", 1, 1);
        Category c2 = new Category(8, 2, "test广告2", "hdashasdhahl", "aodsoahdasdlaskdl", 0, 2);
        Category c3 = new Category(9, 3, "test广告3", "hdashasdhahl", "aodsoahdasdlaskdl", 0, 2);
        Category c4 = new Category(10, 4, "test广告4", "hdashasdhahl", "aodsoahdasdlaskdl", 1, 1);
        Collections.addAll(categoryList, c1, c2, c3, c4);
        /*
        广告分类实列
         */
        Sort s1 = new Sort(1, "分类1");
        Sort s2 = new Sort(2, "分类2");
        Collections.addAll(sortList, s1, s2);
        /*
        封装为vo对象
         */
        for (Category category : categoryList) {
            CategoryVO v = new CategoryVO();
            v.setCategoryId(category.getCategory_id());
            v.setSortId(category.getSort_order());
            v.setTitle(category.getTitle());
            v.setUrl(category.getUrl());
            v.setPic(category.getPic());
            v.setStatus(v.getStatus(category.getStatus()));

            for (Sort sort : sortList) {
                if (sort.getId() == category.getSort_order()) {
                    v.setSortName(sort.getName());
                }
            }
            categoryVOList.add(v);
        }
        Connection con = null;
        try {
            con = JDBCUtil.getCon();
            System.out.println("初始化成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("初始化失败");
        }


    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("server...");
        resp.setContentType("application/json;charset=utf-8");
        String cmd = req.getParameter("cmd");
        if (StrUtil.isNotBlank(cmd)) {
            if("list".equals(cmd)){
                list(req,resp);
            }
        }
    }
    // 1. 列表
    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 指定响应类型为json
        R r = R.ok().data("list", categoryVOList);
        String str = JSON.toJSONString(r);
        // 将字符串输出
        resp.getWriter().print(str);
        resp.getWriter().flush();
    }
}
