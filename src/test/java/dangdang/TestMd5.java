package dangdang;

import static org.junit.Assert.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestMd5 {

	@Test
	public void test() {
		String md5Hex = DigestUtils.md5Hex("123456");
		System.out.println(md5Hex);
	}

}
