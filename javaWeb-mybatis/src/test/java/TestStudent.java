import com.zyc.entity.Student;
import com.zyc.service.StudentService;
import com.zyc.service.impl.StudentServiceImpl;
import org.junit.Before;
import org.junit.Test;

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
public class TestStudent {

    private StudentService studentService;

    @Before
    public void init() {
        studentService = new StudentServiceImpl();
    }

    @Test
    public void testFindAllStudent() throws IOException {
        List<Student> students = studentService.findAllStudent();
        students.forEach(System.out::println);
    }
}
