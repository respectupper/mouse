package com.zjl.mouse.mouseclient.utils.trace;

import com.alibaba.fastjson.JSON;
import com.zjl.mouse.mouseclient.utils.trace.annotation.RpcService;
import com.zjl.mouse.mouseclient.utils.trace.annotation.RpcTraceLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebService;
import java.lang.reflect.Method;

public class TraceAdvice {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private TraceManager traceManager;

    public TraceAdvice() {
    }

    public TraceManager getTraceManager() {
        return this.traceManager;
    }

    public void setTraceManager(TraceManager traceManager) {
        this.traceManager = traceManager;
    }

    public Object serviceInvoke(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Class<?> clazz = joinPoint.getSignature().getDeclaringType();
        if (clazz.getAnnotation(RpcService.class) == null && clazz.getAnnotation(WebService.class) == null) {
            return joinPoint.proceed();
        } else {
            String serviceName = joinPoint.getSignature().getDeclaringTypeName();
            String methodName = joinPoint.getSignature().getName();
            String request = "null";
            if (joinPoint.getArgs().length > 0) {
                request = JSON.toJSONString(joinPoint.getArgs()[0]);
            }

            TraceContext.initTrace();
            TraceContext.increaseCallHierarch(1);
            if (TraceContext.getCallHierarchy() > 1) {
                Object response = joinPoint.proceed();
                TraceContext.increaseCallHierarch(-1);
                return response;
            } else {
                String clientIp = TraceContext.getTag("clientIp") == null ? "" : TraceContext.getTag("clientIp");
                String clientGroup = TraceContext.getTag("clientGroup") == null ? "" : TraceContext.getTag("clientGroup");
                String protocol = TraceContext.getTag("protocol") == null ? "WebService" : TraceContext.getTag("protocol");
                Object response = null;
                long costTime = 0L;
                this.logger.info("访问{}服务{}.{}开始", new Object[]{protocol, serviceName, methodName});

                Object var15;
                try {
                    response = joinPoint.proceed();
                    costTime = System.currentTimeMillis() - start;
                    String printLogConfig = this.getLogConfig(joinPoint, clazz);
                    this.traceManager.record("INFO", "Server", protocol, clientIp, clientGroup, serviceName + "." + methodName, costTime, "入参:\n" + (printLogConfig.startsWith("1") ? request : "...") + "\n 出参:\n" + (printLogConfig.endsWith("1") ? JSON.toJSONString(response) : "..."), "");
                    var15 = response;
                } catch (Exception var19) {
                    costTime = System.currentTimeMillis() - start;
                    this.traceManager.record("ERROR", "Server", protocol, clientIp, clientGroup, serviceName + "." + methodName, costTime, "入参:\n" + request + "\n 异常:\n" + var19.toString(), "");
                    throw var19;
                } finally {
                    TraceContext.remove();
                }

                return var15;
            }
        }
    }

    public Object clientInvoke(ProceedingJoinPoint joinPoint) throws Throwable {
        return this.rpcClientInvoke(joinPoint, "WebService");
    }

    public Object dubboClientInvoke(ProceedingJoinPoint joinPoint) throws Throwable {
        return this.rpcClientInvoke(joinPoint, "Dubbo");
    }

    private Object rpcClientInvoke(ProceedingJoinPoint joinPoint, String protocol) throws Throwable {
        long start = System.currentTimeMillis();
        Class<?> clazz = joinPoint.getSignature().getDeclaringType();
        RpcService rpcService = clazz.getAnnotation(RpcService.class);
        WebService webService = clazz.getAnnotation(WebService.class);
        if (rpcService == null && webService == null) {
            return joinPoint.proceed();
        } else if (!TraceContext.traced()) {
            return joinPoint.proceed();
        } else {
            TraceContext.initCurrSubSpanId();
            String serviceName = joinPoint.getSignature().getDeclaringTypeName();
            String methodName = joinPoint.getSignature().getName();
            String request = "null";
            if (joinPoint.getArgs().length > 0) {
                request = JSON.toJSONString(joinPoint.getArgs()[0]);
            }

            Object response = null;
            long costTime = 0L;
            this.logger.info("调用{}远程服务{}.{}开始", new Object[]{protocol, serviceName, methodName});

            try {
                response = joinPoint.proceed();
                costTime = System.currentTimeMillis() - start;
                String printLogConfig = this.getLogConfig(joinPoint, clazz);
                this.traceManager.record("INFO", "Client", protocol, "", "", serviceName + "." + methodName, costTime, "入参:\n" + (printLogConfig.startsWith("1") ? request : "...") + "\n出参:\n" + (printLogConfig.endsWith("1") ? JSON.toJSONString(response) : "..."), "");
                return response;
            } catch (Exception var13) {
                costTime = System.currentTimeMillis() - start;
                this.traceManager.record("ERROR", "Client", protocol, "", "", serviceName + "." + methodName, costTime, "入参:\n" + request + "\n异常:\n" + var13.toString(), "");
                throw var13;
            }
        }
    }

    private String getLogConfig(ProceedingJoinPoint joinPoint, Class<?> clazz) {
        String printLogConfig = "11";
        RpcTraceLog traceLog = null;
        if (joinPoint.getSignature() instanceof MethodSignature) {
            Method targetMethod = ((MethodSignature)joinPoint.getSignature()).getMethod();
            traceLog = targetMethod.getAnnotation(RpcTraceLog.class);
        }

        if (traceLog == null) {
            traceLog = clazz.getAnnotation(RpcTraceLog.class);
        }

        if (traceLog != null) {
            if (!"yes".equalsIgnoreCase(traceLog.printDetail())) {
                printLogConfig = "00";
            } else {
                if (!"yes".equalsIgnoreCase(traceLog.printInputDetail())) {
                    printLogConfig = "0";
                } else {
                    printLogConfig = "1";
                }

                if (!"yes".equalsIgnoreCase(traceLog.printOutputDetail())) {
                    printLogConfig = printLogConfig + "0";
                } else {
                    printLogConfig = printLogConfig + "1";
                }
            }
        }

        return printLogConfig;
    }
}
