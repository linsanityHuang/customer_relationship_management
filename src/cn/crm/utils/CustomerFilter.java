package cn.crm.utils;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

public class CustomerFilter extends StrutsPrepareAndExecuteFilter {

	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        //判断一下过滤的url,不要拦截js,css文件以及GIF图片
        String url = ((HttpServletRequest) request).getRequestURL().toString();
        if (url.substring(url.lastIndexOf(".")+1).equals("css")
        		||url.substring(url.lastIndexOf(".")+1).equals("js")
        		||url.substring(url.lastIndexOf(".")+1).equals("gif")) {
//            System.out.println("使用自定义的过滤器");
            chain.doFilter(req, res);
        }else{
//            System.out.println("使用默认的过滤器");
            super.doFilter(req, res, chain);
        }
    }
}
