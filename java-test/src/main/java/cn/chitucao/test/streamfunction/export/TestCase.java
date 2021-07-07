package cn.chitucao.test.streamfunction.export;

import cn.chitucao.test.model.Student;
import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestCase {

    @Test
    public void testExport() {
        Student student1 = new Student(1, "张三", 12, 0);
        Student student2 = new Student(2, "李四", 16, 0);
        Student student3 = new Student(3, "王五", 18, 0);
        Student student4 = new Student(4, "小红", 20, 1);
        Student student5 = new Student(5, "狗贼", 25, -1);

        List<Student> students = Arrays.asList(student1, student2, student3, student4,student5);

        Title title1 = new Title().setFieldName("id").setTitle("主键");
        Title title2 = new Title().setFieldName("name").setTitle("姓名");
        Title title3 = new Title().setFieldName("age").setTitle("年龄");
        Title title4 = new Title().setFieldName("sex").setTitle("性别");

        List<Title> titles = Arrays.asList(title1, title2, title3, title4);


        List<Map<String, Object>> result = ExportUtil.stream(students)

                .titles(titles)
                .dict(StudentExportUtil.sex)
                .peek(StudentExportUtil::otherStatus)
                .translate();

        System.out.println(JSONUtil.toJsonPrettyStr(result));
    }

    public static class StudentExportUtil {

        public static Dict<Student, Integer> sex = new Dict<Student, Integer>()
                .defaultValue("不男不女")
                .add(0, "男")
                .add(1, "女")
                .by(Student::getSex)
                .in("sex");

        public static void otherStatus(Student result, Map<String, Object> map) {
            if (result.getAge() >= 18) {
                map.put("sexDesc", "已成年");
            } else {
                map.put("sexDesc", "未成年");
            }
        }
    }

}
