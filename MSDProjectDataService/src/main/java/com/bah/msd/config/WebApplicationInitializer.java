package com.bah.msd.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	 @Override
	  protected String[] getServletMappings() {
		//TODO Fill in URI for DispatcherServlet of /api/*  
	    return new String[] { "TODO" };	
	  }
	  
	  @Override
	  protected Class<?>[] getRootConfigClasses() {
	    return new Class<?>[] { SpringConfig.class };
	  }

	  @Override
	    protected Class<?>[] getServletConfigClasses() {
	  return new Class<?>[] { WebConfig.class };
	  }

}
