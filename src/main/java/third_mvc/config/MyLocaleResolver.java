package third_mvc.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 陆
 * @Date: 2021/08/12/11:33
 * @Description:
 * 地区解析器
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求中的参数链接
        String language = request.getParameter("l");
        //前端传递的参数用来判断中文还是英文
//        System.out.println("->>>"+language);

        Locale locale = Locale.getDefault();
        //获取默认Locale
        if (!StringUtils.isEmpty(language)) {
            //判断传递参数是否为空
                //zh_CN
                String[] split = language.split("_");
                //前后分割 分开获取国家和地区
                //国家，地区
                locale = new Locale(split[0], split[1]);
            }
            return locale;
        }


    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }


}
