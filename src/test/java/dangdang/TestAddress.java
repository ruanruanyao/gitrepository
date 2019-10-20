package dangdang;

import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.baizhi.dao.AddressDao;
import com.baizhi.entity.Address;
import com.baizhi.util.MybatisUtils;

public class TestAddress {

	@Test
	public void test() {
		AddressDao mapper = MybatisUtils.getSqlSession().getMapper(AddressDao.class);
		List<Address> queryAddressesById = mapper.queryAddressesById("1");
		System.out.println(queryAddressesById);
	}
	@Test
	public void test02() {
		AddressDao mapper = MybatisUtils.getSqlSession().getMapper(AddressDao.class);
		Address address = new Address(UUID.randomUUID().toString(),"123","123","123","123","123","123");
		mapper.insertAddress(address);
		MybatisUtils.commit();
	}

}
