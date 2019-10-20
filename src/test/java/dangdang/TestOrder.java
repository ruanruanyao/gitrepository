package dangdang;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.baizhi.dao.OrderDao;
import com.baizhi.dao.OrderItemDao;
import com.baizhi.entity.Order;
import com.baizhi.entity.OrderItem;
import com.baizhi.entity.OrderItemVo;
import com.baizhi.entity.OrderVo;
import com.baizhi.util.MybatisUtils;

public class TestOrder {

	@Test
	public void test() {
		OrderDao mapper = MybatisUtils.getSqlSession().getMapper(OrderDao.class);
		mapper.insertOrder(new Order("213","213",new Date(),13.0,"213","213"));
		MybatisUtils.commit();
	}

	@Test
	public void test02() {
		OrderItemDao mapper = MybatisUtils.getSqlSession().getMapper(OrderItemDao.class);
		List<OrderItemVo> queryItemsById = mapper.queryItemsById("f8cd4378-c93e-4b66-bd30-f13bf49bad87");
		System.out.println(queryItemsById);
	}
	@Test
	public void test03() {
		OrderDao mapper = MybatisUtils.getSqlSession().getMapper(OrderDao.class);
		List<OrderVo> queryOrders = mapper.queryOrders();
		System.out.println(queryOrders);
	}
	@Test
	public void test04() {
		for (int i = 0; i < 10; i++) {
			int a = (int)(Math.random()*10) % 8;
			System.out.println(a+1);
		}
	}


}
