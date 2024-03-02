package com.wxm.springbootbook.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.lang.ref.PhantomReference;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class TimeInterceptor implements HandlerInterceptor {
    private final ThreadLocal<LocalTime> threadLocalStart = new ThreadLocal<>();
    private final ThreadLocal<LocalTime> threadLocalEnd = new ThreadLocal<>();

    private final DateTimeFormatter formatter= DateTimeFormatter.ofPattern("HH:mm:ss:SSS");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 记录开始时间
        LocalTime startTime = LocalTime.now();
        threadLocalStart.set(startTime);
        log.info("开始时间：{}", startTime.format(formatter));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        // 记录结束时间
        LocalTime endTime = LocalTime.now();
        threadLocalEnd.set(endTime);
        log.info("结束时间：{}", endTime.format(formatter));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        // 计算接口执行时间
        LocalTime startTime = threadLocalStart.get();
        LocalTime endTime = threadLocalEnd.get();
        log.info("接口执行时间：{}毫秒", Duration.between(startTime, endTime).getNano()/1000000);
    }
}
