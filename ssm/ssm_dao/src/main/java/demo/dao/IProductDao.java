package demo.dao;

import demo.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * DAO层接口，实现查询功能
 */

public interface IProductDao {


    //根据id查询产品
    @Select("select * from product where id=#{id}")
    public Product findById(String id) throws Exception;

    //查询所有产品
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    //添加产品，将产品信息插入到product表中
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;
}
