package com.zyc.servlet;/**
 * 作者:ZYC
 * DATE:2024/8/5
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:
 */

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.zyc.entity.Classes;
import com.zyc.service.ClassesService;
import com.zyc.service.impl.ClassesServiceImpl;
import com.zyc.utils.R;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/classes")
public class ClassesServlet extends HttpServlet {
    private ClassesService classesService;

    @Override
    public void init() throws ServletException {
        classesService = new ClassesServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet...");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost...");
        doGet(request, response);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("service...");
        response.setContentType("application/json;charset=utf-8");
        String cmd = request.getParameter("cmd");
        if (!StrUtil.isBlank(cmd)) {
            if ("findAllClasess".equals(cmd)) {
                list(request, response);
            }
        }
    }

    /**
     * 查询所有班级信息
     *
     * @param request
     * @param response
     */
    private void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Classes> classesList = classesService.findAllClasses();
        PrintWriter printWriter = response.getWriter();
        R r = R.ok().data("classesList", classesList);
        printWriter.print(JSON.toJSONString(r));
        printWriter.flush();
    }
}
