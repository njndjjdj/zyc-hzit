package com.zyc.servlet;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyc.entity.Student;
import com.zyc.service.StudentService;
import com.zyc.service.impl.StudentServiceImpl;
import com.zyc.utils.R;
import com.zyc.utils.ResultPage;
import com.zyc.vo.StudentVO;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private StudentService studentService;

    /**
     * 初始化操作
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        studentService = new StudentServiceImpl();
    }

    /**
     * 接受请求
     *
     * @param req
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String cmd = req.getParameter("cmd");
        if (!StrUtil.isBlank(cmd)) {
            if ("findAllStudent".equals(cmd)) {
                list(req, response);
            }
            if ("findStudentByPage".equals(cmd)) {
                findStudentByPage(req, response);
            }
            if ("findStudentByPageAndParam".equals(cmd)) {
                findStudentByPageAndParam(req, response);
            }
            if (("deleteStudentById").equals(cmd)) {
                deleteStudentById(req, response);
            }
            // if ("selectStudentById".equals(cmd)) {
            //     selectStudentById(req, response);
            // }
            if ("insertOrUpdateStudent".equals(cmd)) {
                insertOrUpdateStudent(req, response);
            }
            if ("deleteAllStudentById".equals(cmd)) {
                deleteAllStudentById(req, response);
            }
        }
    }

    /**
     * 批量删除
     *
     * @param req
     * @param response
     */
    private void deleteAllStudentById(HttpServletRequest req, HttpServletResponse response) throws IOException {
        String sids = req.getParameter("sids");
        System.out.println(sids);
        String msg = studentService.deleteAllStudentById(sids);
        R r = R.ok().data("msg", msg);
        PrintWriter printWriter = response.getWriter();
        printWriter.print(r);
        printWriter.flush();
    }

    /**
     * 添加或修改学生
     *
     * @param req
     * @param response
     */
    private void insertOrUpdateStudent(HttpServletRequest req, HttpServletResponse response) throws IOException {
        ServletInputStream is = req.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(is, Student.class);
        String msg = studentService.insertOrUpdateStudent(student);
        R r = R.ok().data("msg", msg);
        PrintWriter printWriter = response.getWriter();
        printWriter.print(JSON.toJSONString(r));
        printWriter.flush();
    }

    // /**
    //  * 根据学生id查找学生
    //  *
    //  * @param req
    //  * @param response
    //  */
    // private void selectStudentById(HttpServletRequest req, HttpServletResponse response) {
    //     String id = req.getParameter("cmd");
    //     Student student = studentService.selectStudentById(id);
    //     R r = R.ok().data("student", student);
    // }

    /**
     * 根据学生id删除学生
     *
     * @param req
     * @param response
     */
    private void deleteStudentById(HttpServletRequest req, HttpServletResponse response) throws IOException {
        String id = req.getParameter("id");
        String delStudent = studentService.deleteStudentById(id);
        R r = R.ok().data("msg", delStudent);
        PrintWriter printWriter = response.getWriter();
        printWriter.print(JSON.toJSONString(r));
        printWriter.flush();
    }

    /**
     * 待条件的分页查询
     *
     * @param req
     * @param response
     */
    private void findStudentByPageAndParam(HttpServletRequest req, HttpServletResponse response) throws IOException {
        String pageStr = req.getParameter("page");
        Integer page = new Integer(pageStr);
        String pageSizeStr = req.getParameter("pageSize");
        Integer pageSize = new Integer(pageSizeStr);
        ServletInputStream is = req.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        StudentVO studentVO = mapper.readValue(is, StudentVO.class);
        ResultPage<Student> studentList = studentService.findStudentByPageAndParam(page, pageSize, studentVO);
        R r = R.ok().data("studentList", studentList);
        PrintWriter printWriter = response.getWriter();
        printWriter.print(JSON.toJSONString(r));
        printWriter.flush();
    }

    /**
     * 分页拆查询
     */
    private void findStudentByPage(HttpServletRequest req, HttpServletResponse response) throws IOException {
        String pageStr = req.getParameter("page");
        String pageSizeStr = req.getParameter("pageSize");
        Integer page = new Integer(pageStr);
        Integer pageSize = new Integer(pageSizeStr);
        ResultPage<Student> resultPage = studentService.findStudentByPage(page, pageSize);
        // 封装到R结果集里去
        R r = R.ok().data("findStudentByPage", resultPage);
        response.getWriter().print(JSON.toJSONString(r));
        response.getWriter().flush();
    }

    /**
     * 查询所有学生
     *
     * @param req
     * @param response
     */
    private void list(HttpServletRequest req, HttpServletResponse response) throws IOException {
        List<Student> students = studentService.findAllStudent();
        R r = R.ok().data("students", students);
        response.getWriter().print(JSON.toJSONString(r));
        response.getWriter().flush();
    }
}
