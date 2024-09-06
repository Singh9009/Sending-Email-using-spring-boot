package in.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.spring.service.IShopping;
import in.spring.service.ShoppingServiceImpl;

@SpringBootApplication
public class BootMailProj01SendingEmailUsingSpringBootApplication {

	public static void main(String[] args) {
		//Get IOC container
		ApplicationContext ctx = SpringApplication.run(BootMailProj01SendingEmailUsingSpringBootApplication.class, args);
		//Get service class obj
		IShopping shoppingService = ctx.getBean("shopping", IShopping.class);
		try {
		String result = shoppingService.shopping(new String[]{"shirt","T-Shirt", "Trousers"},
				                                 new Float[] {1200.0f, 770.0f,1450.0f},
				                                 new String[] {"jvians.cluster@gmail.com"});
		System.out.println(result);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
