package third_mvc.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 陆
 * @Date: 2021/08/11/11:14
 * @Description:
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //        控制视图的跳转 登录页面
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/404").setViewName("404");
    }

//    自定义国际化组件生效！
//    如果组件不生效，多半是方法名重复
    @Bean
    public LocaleResolver localeResolver(){
//        System.out.println("配置是否生效？");
        return new MyLocaleResolver();
    }
/*
登录拦截器
出现的问题：首次访问时静态资源被拦截，怎么办？

 */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("addInterceptors#->运行");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login.html","/user/login","/404","/")
                .excludePathPatterns("/css/**","/js/**","/images/**","/plugins/**");
//                .excludePathPatterns("/webjars/**", "/static/**", "/public/**");


    }

}
