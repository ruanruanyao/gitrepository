package dangdang;

import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.Category;
import com.baizhi.util.MybatisUtils;

public class TestCategoryDao {

	@Test
	public void test() {
		CategoryDao mapper = MybatisUtils.getSqlSession().getMapper(CategoryDao.class);
		List<Category> queryAllCategorys = mapper.queryAllCategorys();
		System.out.println(queryAllCategorys);
	}
	@Test
	public void test02(){
		Category category = new Category();
		category.setId(UUID.randomUUID().toString());
		category.setCate_name("Rx");
		CategoryDao mapper = MybatisUtils.getSqlSession().getMapper(CategoryDao.class);
		mapper.insertOneCategory(category);
		MybatisUtils.commit();
	}
	@Test
	public void test03(){
		Category category = new Category();
		category.setId(UUID.randomUUID().toString());
		category.setCate_name("Rx");
		category.setParent_id("1");
		CategoryDao mapper = MybatisUtils.getSqlSession().getMapper(CategoryDao.class);
		mapper.insertTwoCategory(category);
		MybatisUtils.commit();
	}
	@Test
	public void test04() {
		CategoryDao mapper = MybatisUtils.getSqlSession().getMapper(CategoryDao.class);
		List<Category> queryTwoCategorys = mapper.queryTwoCategorys();
		System.out.println(queryTwoCategorys);
	}
	@Test
	public void test05() {
		CategoryDao mapper = MybatisUtils.getSqlSession().getMapper(CategoryDao.class);
		Category queryTwoByOne = mapper.queryTwoByOne("1");
		System.out.println(queryTwoByOne);
	}

}
