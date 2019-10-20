package dangdang;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.baizhi.dao.BookDao;
import com.baizhi.entity.Book;
import com.baizhi.util.MybatisUtils;

public class TestBook {

	@Test
	public void test() {
		BookDao mapper = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		List<Book> queryAllBooks = mapper.queryAllBooks();
		System.out.println(queryAllBooks);
	}
	
	@Test
	public void test02() {
		BookDao mapper = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		List<Book> queryByLike = mapper.queryByLike("name", "悲伤");
		System.out.println(queryByLike);
	}
	@Test
	public void test03(){
		BookDao mapper = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		Book book = new Book(UUID.randomUUID().toString(), "ABC", "ABC", 10.0, 8.0, "ABC", new Date(), "123456", "123456", new Date(), "123456", 0, "3", "A", "213");
		mapper.insertBook(book);
		MybatisUtils.commit();
	}
	@Test
	public void test04(){
		BookDao mapper = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		List<Book> queryHotAndNew = mapper.queryHotAndNew();
		System.out.println(queryHotAndNew);
	}
	@Test
	public void test05(){
		BookDao mapper = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		List<Book> queryBooksByOne = mapper.queryBooksByOne("1",1,2);
		System.out.println(queryBooksByOne);
	}
	@Test
	public void test06(){
		BookDao mapper = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		List<Book> queryBooksByOne = mapper.queryBooksByTwo("2");
		System.out.println(queryBooksByOne);
	}
	@Test
	public void test07(){
		BookDao mapper = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		Integer queryCountByOne = mapper.queryCountByOne("1");
		Integer queryCountByTwo = mapper.queryCountByTwo("3");
		System.out.println(queryCountByOne);
		System.out.println(queryCountByTwo);
	}
	@Test
	public void test08(){
		BookDao mapper = MybatisUtils.getSqlSession().getMapper(BookDao.class);
		Book queryBookById = mapper.queryBookById("108");
		System.out.println(queryBookById);
	}


}
