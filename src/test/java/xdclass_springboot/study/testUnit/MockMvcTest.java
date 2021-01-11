//package xdclass_springboot.study.testUnit;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import net.xdclass.demo.XdclassApplication;
//
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes={XdclassApplication.class})
//@AutoConfigureMockMvc      //自动配置MockMvc
//public class MockMvcTest {
//
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@Test 
//	public void apiTest() throws Exception{
//		
//		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/hello"))/*
//		 * Copyright 2020 the original author or authors.
//		 *
//		 * Licensed under the Apache License, Version 2.0 (the "License");
//		 * you may not use this file except in compliance with the License.
//		 * You may obtain a copy of the License at
//		 *
//		 *      https://www.apache.org/licenses/LICENSE-2.0
//		 *
//		 * Unless required by applicable law or agreed to in writing, software
//		 * distributed under the License is distributed on an "AS IS" BASIS,
//		 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//		 * See the License for the specific language governing permissions and
//		 * limitations under the License.
//		 */
//				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
//		
//		int statuss = mvcResult.getResponse().getStatus();
//		System.out.println(statuss);
//	}
//}
