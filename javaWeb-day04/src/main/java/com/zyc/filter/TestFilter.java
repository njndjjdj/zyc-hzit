package com.zyc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 作者:ZYC
 * DATE:2024/8/7
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:
 */
@WebFilter(urlPatterns = "/*")    // 表示过滤所有请求
public class TestFilter implements Filter {

    /**
     * 初始化时执行的方法
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    /**
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter  1");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("doFilter  2");
    }

    /**
     * 销毁的时候执行的方法
     */
    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
