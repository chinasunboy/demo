package demo.dao;

import demo.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {
    //多表查询
    //先从中间表中order_traveller查ordersId相同的travellerId，在查traveller
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    public List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
