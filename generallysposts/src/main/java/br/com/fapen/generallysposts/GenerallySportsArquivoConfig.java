package br.com.fapen.generallysposts;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.fapen.generallysposts.services.ArquivoService;

@Configuration
public class GenerallySportsArquivoConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/media/**").addResourceLocations("file://" + ArquivoService.DIRETORIO_BASE);
	}
}
