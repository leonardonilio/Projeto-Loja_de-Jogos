package br.com.umbrellaGames.controller.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfig implements WebMvcConfigurer {
	
	//Isso aqui é pro thymeleaf ser capaz de pegar imagens que não estão nem na pasta static nem na templates
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/imagem/**").addResourceLocations("classpath:/imagem/");
	}

}
