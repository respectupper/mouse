package com.zjl.mouse.utils.trace.dubbo.filter;

import com.zjl.mouse.utils.trace.TraceContext;
import java.lang.reflect.Method;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.RpcException;

/**
 * @author zhujinglei
 */
@Activate
public class ServerTraceFilter implements Filter {
    public ServerTraceFilter() {
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Method method;
        try {
            method = invoker.getInterface().getMethod(invocation.getMethodName(), invocation.getParameterTypes());
        } catch (Exception var8) {
            var8.printStackTrace();
            return invoker.invoke(invocation);
        }

        String traceId = RpcContext.getContext().getAttachment("traceId");
        String spanId = (RpcContext.getContext().getAttachment("spanId") == null||RpcContext.getContext().getAttachment("spanId").length()==0)?"0":RpcContext.getContext().getAttachment("spanId");
        String clientIp = RpcContext.getContext().getAttachment("clientIp");
        String clientGroup = RpcContext.getContext().getAttachment("clientGroup");
        TraceContext.initTrace(traceId, spanId);
        String currSubSpanId = TraceContext.initCurrSubSpanId();
        TraceContext.setTag("clientIp", clientIp);
        TraceContext.setTag("clientGroup", clientGroup);
        TraceContext.setTag("method", method.getName());
        TraceContext.setTag("service", method.getDeclaringClass().getName());
        TraceContext.setTag("protocol", "Dubbo");
        return invoker.invoke(invocation);
    }
}