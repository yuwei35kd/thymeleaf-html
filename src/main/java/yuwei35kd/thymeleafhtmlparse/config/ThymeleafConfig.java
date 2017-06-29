package yuwei35kd.thymeleafhtmlparse.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class ThymeleafConfig {
	@Bean
	public SpringTemplateEngine templateEngine(){
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		Set<ITemplateResolver> resolvers = new HashSet<ITemplateResolver>();
		resolvers.add(emailTemplateResolver());
		templateEngine.setTemplateResolvers(resolvers);
		return templateEngine;
	}
	
	@Bean
	public ClassLoaderTemplateResolver emailTemplateResolver(){
		ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
		resolver.setPrefix("mail/");
		resolver.setTemplateMode("HTML5");
		resolver.setOrder(1);
		resolver.setCharacterEncoding("UTF-8");
		resolver.setCacheable(true);
		return resolver;
	}
}
