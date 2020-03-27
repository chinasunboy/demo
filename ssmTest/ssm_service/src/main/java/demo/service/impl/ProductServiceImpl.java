package demo.service.impl;

import demo.dao.IProductDao;
import demo.service.IProductService;
import demo.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service//业务层注解
@Transactional//事务注解
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao iProductDao;

    public List<Product> findAll() throws Exception {
        return iProductDao.findAll();
    }
}
