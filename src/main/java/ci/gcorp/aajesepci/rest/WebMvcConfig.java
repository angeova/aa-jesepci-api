
/*
 * Created on 2019-06-17 ( Time 13:09:01 )
 * Generator tool : Telosys Tools Generator ( version 3.0.0 )
 * Copyright 2017 Savoir Faire Linux. All Rights Reserved.
 */

package ci.gcorp.aajesepci.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RestInterceptor());
	}
}
