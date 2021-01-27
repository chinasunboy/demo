package demo.springbootreviewtestmybatis.Service;

import demo.springbootreviewtestmybatis.Dao.AccountDao;
import demo.springbootreviewtestmybatis.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements AccountDao {

    @Autowired
    AccountDao accountDao;


    @Override
    public Account findId(Integer id) {
        return accountDao.findId(id);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public void addAccount(Account account) {
        accountDao.addAccount(account);
    }

    @Override
    public Integer updateAccount(Account account) {
        return accountDao.updateAccount(account);
    }


    @Override
    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }
}
