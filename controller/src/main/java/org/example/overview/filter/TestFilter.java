package org.example.overview.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns="/*")
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 초기화 작업
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 1. 전처리 작업
        HttpServletRequest req = (HttpServletRequest) request;
        String method = req.getMethod();
        System.out.print("[" + method + "] [URL : " + req.getRequestURI()+ "]\t");

        // 2. 서블릿 또는 다음 필터를 호출
        chain.doFilter(request, response);

        // 3. 후처리 작업
    }

    @Override
    public void destroy() {
        // 정리 작업
    }
}
