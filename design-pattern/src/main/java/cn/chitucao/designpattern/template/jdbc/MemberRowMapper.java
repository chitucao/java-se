package cn.chitucao.designpattern.template.jdbc;

import java.sql.ResultSet;

/**
 * @author DennyFly
 * @since 2020/3/20 16:46
 */
public class MemberRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws Exception {
        Member member = new Member();
        //字段过多，原型模式
        member.setUsername(rs.getString("username"));
        member.setPassword(rs.getString("password"));
        member.setAge(rs.getInt("age"));
        member.setAddr(rs.getString("addr"));
        return member;
    }
}
