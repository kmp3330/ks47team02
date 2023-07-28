package ks47team02.common.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ks47team02.common.interceptor.LoggerInterceptor;
import ks47team02.common.interceptor.LoginInterceptor;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class WebConfig implements WebMvcConfigurer{
	
	private final LoggerInterceptor loggerInterceptor;
	private final LoginInterceptor loginInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		List<String> excludePathList = new ArrayList<String>();
		excludePathList.add("/admin/build/**");
		excludePathList.add("/admin/dist/**");
		excludePathList.add("/admin/docs/**");
		excludePathList.add("/admin/pages/**");
		excludePathList.add("/admin/plugins/**");
		excludePathList.add("/js/**");
		excludePathList.add("/user/assets/**");
		excludePathList.add("/favicon.ico");
		
		registry.addInterceptor(loggerInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns(excludePathList);
		
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/")
				.excludePathPatterns("/login")
				.excludePathPatterns("/cpLogin")
				.excludePathPatterns("/logout")
				.excludePathPatterns("/addMember")
				.excludePathPatterns("/addNormalMember")
				.excludePathPatterns("/addCompanyMember")
				.excludePathPatterns("/checkId")
				.excludePathPatterns("#checkId")
				.excludePathPatterns("/checkCpId")
				.excludePathPatterns("#checkCpId")
				.excludePathPatterns("/checkRegNum")
				.excludePathPatterns("#checkRegNum")
				.excludePathPatterns("#readTerms")
				.excludePathPatterns("/admin/**")
				.excludePathPatterns(excludePathList);
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
