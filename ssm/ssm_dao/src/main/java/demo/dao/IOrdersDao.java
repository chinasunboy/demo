package demo.dao;


import demo.domain.Member;
import demo.domain.Orders;
import demo.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrdersDao {

    @Select("select * from orders")
    //通过result指定查询出来的数据的对印方式
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            //多表查询，通过product的findbyid将另一张表的结果赋值过来
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "demo.dao.IProductDao.findById")),
    })
    public List<Orders> findAll() throws Exception;


    //多表操作 通过ID查询，product产品信息，member会员信息，travellers旅客信息
    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            //查询ordersId后会返回产品id，会员id，旅客id，在调用以下的sql查询返回list
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "demo.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "demo.dao.IMemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType =java.util.List.class,many = @Many(select = "demo.dao.ITravellerDao.findByOrdersId"))
    })
    public Orders findById(String ordersId) throws Exception;

}
