package com.ch.stringOrList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LcCodeApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void test7(){
		byte[] bytes =  {109, 107, 3, 1, 0, 80, -128};
		String[] s = new String[bytes.length];
		for (int i = 0; i < bytes.length; i++) {
			s[i] = String.valueOf(bytes[i]);
			System.out.println(s[i]);
		}

	}
}
