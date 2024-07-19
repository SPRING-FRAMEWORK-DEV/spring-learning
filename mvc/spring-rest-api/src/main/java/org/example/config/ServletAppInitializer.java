package org.example.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ServletAppInitializer implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    System.out.println("....... Initializing application .......");
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.register(AppConfig.class);

    WebApplicationContext webApplicationContext = (WebApplicationContext) context;

    ServletRegistration.Dynamic dynamic = servletContext
        .addServlet("appServlet",new DispatcherServlet(webApplicationContext));
    dynamic.setLoadOnStartup(1);
    dynamic.addMapping("/");

    System.out.println("##########       Application Initialized!!    ##########");
  }
}
