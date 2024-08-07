package com.zyc.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyc.entity.Classes;
import com.zyc.entity.Student;
import com.zyc.mapper.ClassesMapper;
import com.zyc.mapper.StudentMapper;
import com.zyc.service.StudentService;
import com.zyc.utils.MySqlSessionFactory;
import com.zyc.utils.ResultPage;
import com.zyc.vo.StudentVO;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.*;

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
public class StudentServiceImpl implements StudentService {


    /**
     * 查找所有学生
     *
     * @return
     */
    @Override
    public List<Student> findAllStudent() throws IOException {
        // 获得sqlsession对象
        try (SqlSession sqlSession = MySqlSessionFactory.getSqlSession(true)) {
            // 获得mapper对象
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            // 执行sql
            List<Student> students = mapper.findAllStudent();
            return students;
        }
    }

    /**
     * 分页查询
     *
     * @return
     * @throws IOException
     */
    @Override
    public ResultPage<Student> findStudentByPage(Integer page, Integer pageSize) throws IOException {
        // 2.1 开始分页
        PageHelper.startPage(page, pageSize);
        // 2.2 开始查询
        List<Student> students = this.findAllStudent();
        // 2.3 使用PageInfo来包装分页信息
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        // 2.4 正确获取总记录数和结果列表
        long total = pageInfo.getTotal();
        List<Student> result = pageInfo.getList();
        return new ResultPage<>(total, result);
    }


    /**
     * 分页查询带参数
     *
     * @param page
     * @param pageSize
     * @param studentVO
     * @return
     */
    @Override
    public ResultPage<Student> findStudentByPageAndParam(Integer page, Integer pageSize, StudentVO studentVO) throws IOException {
        PageHelper.startPage(page, pageSize);
        try (SqlSession sqlSession = MySqlSessionFactory.getSqlSession(true)) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            // ClassesMapper classesMapper = sqlSession.getMapper(ClassesMapper.class);
            // List<Classes> classes = classesMapper.findAllClasses();
            List<Student> students = studentMapper.findStudentByPageAndParam(studentVO);
            for (Student student : students) {
                if ("M".equals(student.getSex())) {
                    student.setSex("男");
                } else student.setSex("女");
            }
            Page<Student> studentPage = (Page<Student>) students;
            long total = studentPage.getTotal();
            List<Student> result = studentPage.getResult();
            return new ResultPage<>(total, result);
        }
    }

    /**
     * 根据id删除学神
     *
     * @param id
     * @return
     */
    @Override
    public String deleteStudentById(String id) throws IOException {
        try (SqlSession sqlSession = MySqlSessionFactory.getSqlSession(true)) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Student student = mapper.selectStudentById(id);
            if (student == null) {
                return "该学生不存在";
            }
            mapper.deleteStudentById(id);
            Student s = mapper.selectStudentById(id);
            if (s == null) {
                return "删除成功";
            } else {
                return "删除失败";
            }
        }
    }

    /**
     * 添加或修改
     *
     * @param student
     * @return
     */
    @Override
    public String insertOrUpdateStudent(Student student) throws IOException {
        try (SqlSession sqlSession = MySqlSessionFactory.getSqlSession(true)) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            // 根据传入的学生id进行查找
            String stuno = student.getStuno();
            Student s = studentMapper.selectStudentById(stuno);
            // 如果不存在就添加
            if (s == null) {
                studentMapper.addStudent(student);
                return "添加成功";
            } else {
                // 存在就修改
                studentMapper.updateStudent(student);
                return "修改成功";
            }
        }
    }

    /**
     * 批量删除
     *
     * @param sids
     * @return
     */
    @Override
    public String deleteAllStudentById(String sids) throws IOException {
        try (SqlSession sqlSession = MySqlSessionFactory.getSqlSession(true)) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<String> sidList = Arrays.asList(sids.split(","));
            mapper.deleteAllStudentById(sidList);
            return "删除成功";
        }
    }
}
