package com.zyc.mapper;

import com.zyc.entity.Student;
import com.zyc.vo.StudentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 作者:ZYC
 * DATE:2024/8/5
 * 快捷键:ctrl+alt+l自动格式化 alt+a/w光标移至行首/行尾 alt+s 转换大小写
 * use:
 */
public interface StudentMapper {

    // 查询所有学生
    List<Student> findAllStudent();

    /**
     * 分页查询
     */
    List<Student> findStudentByPage();

    /**
     * 分页查询带参数
     * @param studentVO
     * @return
     */
    List<Student> findStudentByPageAndParam(StudentVO studentVO);

    /**
     * 根据id查询学生
     * @param id
     * @return
     */
    Student selectStudentById(String id);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    void deleteStudentById(String id);

    /**
     * 添加学生
     * @param student
     */
    void addStudent(Student student);

    /**
     * 修改学生
     * @param student
     */
    void updateStudent(Student student);

    /**
     * 批量删除
     * @param ids
     */
    void deleteAllStudentById(@Param("ids") List<String> ids);
}
