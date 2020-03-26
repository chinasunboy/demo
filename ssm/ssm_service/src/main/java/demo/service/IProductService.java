package demo.service;

import demo.domain.Product;

import java.util.List;

/**
 * service层接口跟DAO层接口方法一样
 */
public interface IProductService {



    public List<Product> findAll() throws Exception;

    void save(Product product) throws Exception;
}
