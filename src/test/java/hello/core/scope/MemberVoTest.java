package hello.core.scope;

import java.util.Iterator;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberVoTest {

	@Test
	@DisplayName("Bean test")
	public void test() {
	
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		MemberVo bean = ac.getBean(MemberVo.class);
		System.out.println("bean :" + bean);
		
		MemberVo bean2 = ac.getBean(MemberVo.class);
		System.out.println("bean2 :" + bean2);
		
		TestConfig testConfig = ac.getBean(TestConfig.class);
		
		System.out.println("testConfig :" + testConfig);
		System.out.println("testConfig.getClass :" + testConfig.getClass());
		
		
		System.out.println("bean == bean2 = " + (bean == bean2));
		
		
	}
	
	@Test
	void findAll() {
		
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		
		for (String definitionName : beanDefinitionNames) {
			System.out.println("definitionName :" + definitionName);
			Object bean = ac.getBean(definitionName);
			System.out.println("bean :" + bean);
			
			BeanDefinition beanDefinition = ac.getBeanDefinition(definitionName);
			if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				System.out.println(beanDefinition.getScope());
			}
			
		}
		
//		Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
//		beansOfType.forEach((key, object) -> {
//			System.out.println(key + ":" +  object);
//		});
		
		
	}
}
