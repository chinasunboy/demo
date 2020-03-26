package demo.service.impl;

import demo.dao.IProductDao;
import demo.service.IProductService;
import demo.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * service是实现类，实现service接口，调用Dao接口实现方法
 * 事务一眼放在业务层
 * 通过Dao层接口对象来实现spring整合mybatis
 */
@Service//业务层注解
@Transactional//事务注解
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao iProductDao;

    public List<Product> findAll() throws Exception {
        return iProductDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        iProductDao.save(product);
    }
}
