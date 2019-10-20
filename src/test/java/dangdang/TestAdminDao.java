package dangdang;

import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.util.MybatisUtils;

public class TestAdminDao {

	@Test
	public void test() {
		AdminDao mapper = MybatisUtils.getSqlSession().getMapper(AdminDao.class);
		Admin queryAdminByUsername = mapper.queryAdminByUsername("admin");
		System.out.println(queryAdminByUsername);
	}
	@Test
	public void test02(){
		Admin admin = new Admin();
		admin.setId(UUID.randomUUID().toString());
		System.out.println(UUID.randomUUID().toString());
	}

}
