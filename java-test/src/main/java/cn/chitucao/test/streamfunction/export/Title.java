package cn.chitucao.test.streamfunction.export;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Data
public class Title implements Serializable {


    /**
     * 属性名
     */
    private String fieldName;

    /**
     * 中文名
     */
    private String title;

    /**
     * 格式
     * eg: 0.00
     * eg: yyyy-MM-dd
     */
    private String format;
}
