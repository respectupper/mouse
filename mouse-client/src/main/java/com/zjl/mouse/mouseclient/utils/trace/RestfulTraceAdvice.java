package com.zjl.mouse.mouseclient.utils.trace;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RestfulTraceAdvice {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private TraceManager traceManager;
    private TraceRecord traceRecord;

    public RestfulTraceAdvice() {
    }

    public TraceManager getTraceManager() {
        return this.traceManager;
    }

    public void setTraceManager(TraceManager traceManager) {
        this.traceManager = traceManager;
    }

    public TraceRecord getTraceRecord() {
        return this.traceRecord;
    }

    public void setTraceRecord(TraceRecord traceRecord) {
        this.traceRecord = traceRecord;
    }

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        String controllerName = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        for(int i = 0; i < args.length; ++i) {
            if (args[i] instanceof HttpServletRequest || args[i] instanceof HttpServletResponse) {
                args[i] = null;
            }
        }

        this.traceManager.init();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        servletRequestAttributes.getResponse().addHeader("traceId", TraceContext.getTraceId());
        Object response = null;
        long costTime = 0L;
        this.logger.info("访问{}.{}接口开始", controllerName, methodName);

        Object var11;
        try {
            response = joinPoint.proceed();
            costTime = System.currentTimeMillis() - start;
            this.traceManager.record("INFO", "Server", "Restful", "", "", controllerName + "." + methodName, costTime, "入参:\n" + JSON.toJSONString(args) + "\n出参:\n" + JSON.toJSONString(response), "");
            var11 = response;
        } catch (Throwable var15) {
            costTime = System.currentTimeMillis() - start;
            this.traceManager.record("INFO", "Server", "Restful", "", "", controllerName + "." + methodName, costTime, "入参:\n" + JSON.toJSONString(args) + "\n异常:\n" + var15.toString(), "");
            throw var15;
        } finally {
            this.traceManager.close();
        }

        return var11;
    }
}
