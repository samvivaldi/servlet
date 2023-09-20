package hello.core.scope;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class SingletonTest {

	@Test
	public void singletonBeanFind() {
		
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
		
		SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
		SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);
		
		System.out.println("singletonBean1 :" + singletonBean1);
		System.out.println("singletonBean2 :" + singletonBean2);
		
//		assertThat(singletonBean1).isSameAs(singletonBean2);
		
		ac.close();

	}

	//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	static class SingletonBean {

		@PostConstruct
		public void init() {
			System.out.println("SingletonBean.init");
		}

		@PreDestroy
		public void destroy() {
			System.out.println("SingletonBean.destroy");
		}
		
	}
}
