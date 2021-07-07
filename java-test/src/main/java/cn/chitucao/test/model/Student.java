package cn.chitucao.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author DennyFly
 * @since 2021/4/8 15:03
 */
@Accessors(chain = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Integer id;

    private String name;

    private Integer age;

    // 0: 男、1：女
    private Integer sex;
}
