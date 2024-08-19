package com.ch.lccode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.concurrent.*;

@SpringBootTest
class LcCodeApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void test5(){
		BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(5);
		Integer var1=new Integer(1);
		Integer var2=var1;
		doSomething(var2);
		System.out.print(var1.intValue());
		System.out.print(var2.intValue());
		System.out.print(var1==var2);
	}
	void doSomething(Integer integer){
		integer=new Integer(2);
	}

	@Test
	public void test6(){
		LocalTime now = LocalTime.now();
		ExecutorService es = Executors.newVirtualThreadPerTaskExecutor();
//		ExecutorService es = Executors.newFixedThreadPool(10);
		for (int i=0; i<1000; i++) {
			es.submit(() -> {
				Thread.sleep(10);
				return 0;
			});
		}
		es.close();
		LocalTime end = LocalTime.now();
		System.out.println("执行完毕,耗时:" + (end.toNanoOfDay() - now.toNanoOfDay()) + "ns");
	}
}
