package demo.dao;

import demo.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {

    //通过id查询会员信息
    @Select("select * from member where id=#{id}")
    public Member findById(String id) throws Exception;
}
