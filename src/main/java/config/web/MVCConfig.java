package config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import rest.common.AuthCheckInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "rest" })
public class MVCConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*");
	}

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/main").setViewName("main");
//	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authCheckInterceptor())
				.addPathPatterns("/board/**")
				.excludePathPatterns("/member/**");
	}

	@Bean
	public AuthCheckInterceptor authCheckInterceptor() {
		return new AuthCheckInterceptor();
	}
	
	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
	
//	@Bean
//	public static PropertySourcesPlaceholderConfigurer properties() {
//		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
//		configurer.setLocations(
//				new ClassPathResource("db.properties"),
//				new ClassPathResource("info.properties"));
//		return configurer;
//	}

//	@Bean
//	public MessageSource messageSource() {
//		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
//		ms.setBasenames("message.label");
//		ms.setDefaultEncoding("UTF-8");
//		return ms;
//	}

//	@Override
//	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//		ObjectMapper objectMapper = Jackson2ObjectMapperBuilder
//				.json()
//				//.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
//				//.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(formatter))
//				.deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(formatter))
//				//.simpleDateFormat("yyyy-MM-dd HH:mm:ss")
//				.build();
//		converters.add(0, new MappingJackson2HttpMessageConverter(objectMapper));
//	}
}
