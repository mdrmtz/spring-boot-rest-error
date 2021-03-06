package globant.svp.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "globant.svp.rest.controller",
		"globant.svp.rest.exception", "globant.svp.core" })
public class Application /* extends SpringBootServletInitializer */{
	
	private static final String MESSAGE_SOURCE_BASE_NAME = "i18n/messages";

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*
	 * @Override protected final SpringApplicationBuilder configure( final
	 * SpringApplicationBuilder application) { return
	 * application.sources(Application.class); }
	 */

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

		messageSource.setBasename(MESSAGE_SOURCE_BASE_NAME);
		messageSource.setUseCodeAsDefaultMessage(true);

		return messageSource;
	}
}
