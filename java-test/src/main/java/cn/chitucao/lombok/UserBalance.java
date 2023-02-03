package cn.chitucao.lombok;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author chitucao
 * @since 2022/8/17 15:10
 */
@Data
public class UserBalance {

    private String name;

    @JsonSerialize(using= ToStringSerializer.class)
    private BigDecimal money;
}
