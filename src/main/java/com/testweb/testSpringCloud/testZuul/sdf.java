//
//package com.testweb.testSpringCloud.testZuul;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.ContextLifecycleFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.filters.FilterRegistry;
//import com.netflix.zuul.http.ZuulServlet;
//import com.netflix.zuul.monitoring.MonitoringHelper;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.context.embedded.FilterRegistrationBean;
//import org.springframework.boot.context.embedded.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
///**
// * Created by liaokailin on 16/5/24.
// */
//@SpringBootApplication
//public class Application {
//
//    public static void main(String[] args) {
//        new SpringApplicationBuilder(Application.class).web(true).run(args);
//    }
//
//    @Component
//    public static class MyCommandLineRunner implements CommandLineRunner {
//
//        @Override
//        public void run(String... args) throws Exception {
//            MonitoringHelper.initMocks();
//            initJavaFilters();
//        }
//
//        private void initJavaFilters() {
//            final FilterRegistry r = FilterRegistry.instance();
//            r.put("javaPreFilter", new ZuulFilter() {
//
//                @Override
//                public int filterOrder() {
//                    return 50000;
//                }
//
//                @Override
//                public String filterType() {
//                    return "pre";
//                }
//
//                @Override
//                public boolean shouldFilter() {
//                    return true;
//                }
//
//                @Override
//                public Object run() {
//                    System.out.println("running javaPreFilter");
//                    RequestContext.getCurrentContext().set("name", "liaokailin");
//                    return null;
//                }
//            });
//            r.put("javaRoutingFilter", new ZuulFilter() {
//
//                @Override
//                public int filterOrder() {
//                    return 50000;
//                }
//
//                @Override
//                public String filterType() {
//                    return "route";
//                }
//
//                @Override
//                public boolean shouldFilter() {
//                    return true;
//                }
//
//                @Override
//                public Object run() {
//                    System.out.println("running javaRoutingFilter");
//                    try {
//                        RequestContext.getCurrentContext().getResponse().sendRedirect("http://blog.csdn.net/liaokailin/");
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    return null;
//                }
//            });
//            r.put("javaPostFilter", new ZuulFilter() {
//
//                @Override
//                public int filterOrder() {
//                    return 50000;
//                }
//
//                @Override
//                public String filterType() {
//                    return "post";
//                }
//
//                @Override
//                public boolean shouldFilter() {
//                    return true;
//                }
//
//                @Override
//                public Object run() {
//                    System.out.println("running javaPostFilter");
//                    System.out.println(RequestContext.getCurrentContext().get("name").toString());
//                    return null;
//                }
//            });
//        }
//    }
//
//    @Bean
//    public ServletRegistrationBean zuulServlet() {
//        ServletRegistrationBean servlet = new ServletRegistrationBean(new ZuulServlet());
//        servlet.addUrlMappings("/test");
//        return servlet;
//    }
//
//    @Bean
//    public FilterRegistrationBean contextLifecycleFilter() {
//        FilterRegistrationBean filter = new FilterRegistrationBean(new ContextLifecycleFilter());
//        filter.addUrlPatterns("/*");
//        return filter;
//    }
//}
