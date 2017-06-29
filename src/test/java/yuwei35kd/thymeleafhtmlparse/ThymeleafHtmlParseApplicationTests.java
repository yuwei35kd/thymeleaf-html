package yuwei35kd.thymeleafhtmlparse;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import yuwei35kd.thymeleafhtmlparse.bean.Bean;
import yuwei35kd.thymeleafhtmlparse.bean.Bean1;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={ThymeleafHtmlParseApplication.class})
public class ThymeleafHtmlParseApplicationTests {
	@Resource
	private SpringTemplateEngine springTemplateEngine;

	@Test
	public void htmlContent(){
		Context context = new Context();
		context.setVariable("username", "李四");
		context.setVariable("age","100");
		context.setVariable("bean", new Bean());
		context.setVariable("bean1",new Bean1());
		System.out.println(springTemplateEngine.process("demo.html", context));
	}

}
