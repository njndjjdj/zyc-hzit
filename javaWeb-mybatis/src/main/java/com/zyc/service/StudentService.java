package com.zyc.service;

import com.zyc.entity.Student;
import com.zyc.utils.ResultPage;
import com.zyc.vo.StudentVO;

import java.io.IOException;
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
public interface StudentService {

    /**
     * 查找所有学生
     * @return
     */
    List<Student> findAllStudent() throws IOException;

    /**
     * 分页查询
     * @return
     * @throws IOException
     */
    ResultPage<Student> findStudentByPage(Integer page, Integer pageSize) throws IOException;

    /**
     * 分页查询带参数
     * @param page
     * @param pageSize
     * @param studentVO
     * @return
     */
    ResultPage<Student> findStudentByPageAndParam(Integer page, Integer pageSize, StudentVO studentVO) throws IOException;

    /**
     * 根据id删除学生
     * @param id
     * @return
     */
    String deleteStudentById(String id) throws IOException;

    /**
     * 添加或修改
     * @param student
     * @return
     */
    String insertOrUpdateStudent(Student student) throws IOException;

    /**
     * 批量删除
     * @param sids
     * @return
     */
    String deleteAllStudentById(String sids) throws IOException;
}
