//package xdclass_springboot.study.testUnit;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import junit.framework.TestCase;
//import net.xdclass.demo.XdclassApplication;
//
//@RunWith(SpringRunner.class) // 底层用junit SpringJUnit4ClassRunner
//@SpringBootTest(classes = { XdclassApplication.class }) // 启动整个springboot工程
//
//
//public class SpringBootTestUnit {
//	
//	
//	@Test
//	public void testOne() {
//		System.out.println("test one");
//		TestCase.assertEquals(1, 1);
//	}
//	
//	@Test
//	public void testTwo() {
//		System.out.println("test two");
//		TestCase.assertEquals(1, 1);
//	}
//	
//	@Before
//	public void testBefore() {
//		System.out.println("test before......:");
//	}
//	
//	@After
//	public void testAfter() {
//		System.out.println("test after......:");
//	}
//}
