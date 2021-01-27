package demo.springbootreviewtestmybatis.repository;

import demo.springbootreviewtestmybatis.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

//继承JpaRepository来完成对数据库的操作
public interface AccountRepository extends JpaRepository<Account,Integer> {
}
