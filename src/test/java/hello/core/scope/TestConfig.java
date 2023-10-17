package hello.core.scope;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;

//@Configuration
public class TestConfig {
	
	@Bean
	public String name() {
		return "sam";
	}
	
	@Bean
	@Qualifier("dddd")
	public String test() {
		return "55";
	}	
	

	@Bean
	//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public MemberVo testMem(@Nullable String name, @Qualifier("dddd") String age) {
		return new MemberVo(name, age);
	}
}
