package com.wxm.springbootbook.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Objects;

@WebFilter(urlPatterns = "/student")
public class MyFilter implements Filter {

    /**
     * 自定义的过滤器: 实现根据IP统计访问次数
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 访问的ip
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String ip = request.getRemoteAddr();
        // 统计访问次数并输出
        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("count");
        count = Objects.isNull(count) ? 1 : ++count;
        System.out.println("ip: "+ ip + "\tcount:" + count);
        session.setAttribute("count", count);
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
