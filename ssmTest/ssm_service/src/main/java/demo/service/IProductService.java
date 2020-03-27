package demo.service;

import demo.domain.Product;

import java.util.List;

public interface IProductService {



    public List<Product> findAll() throws Exception;

}
