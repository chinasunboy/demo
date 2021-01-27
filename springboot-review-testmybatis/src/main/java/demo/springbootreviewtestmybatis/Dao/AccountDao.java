package demo.springbootreviewtestmybatis.Dao;


import demo.springbootreviewtestmybatis.entity.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountDao {

    @Select("select * from account where id = #{id}")
    Account findId(Integer id);

    @Select("select * from account")
    List<Account> findAll();

    @Insert("insert into  account(`name`,`money`) values(#{name},#{money})")
    void addAccount(Account account);

    @Update("update account a set a.name = #{name},a.money = #{money} where id = #{id}")
    Integer updateAccount(Account account);


    @Delete("delete  from account where id = #{id}")
    void deleteAccount(Integer id);

}
