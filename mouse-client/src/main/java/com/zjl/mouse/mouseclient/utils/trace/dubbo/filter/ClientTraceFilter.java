package com.zjl.mouse.mouseclient.utils.trace.dubbo.filter;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.zjl.mouse.mouseclient.utils.context.SpringContext;
import com.zjl.mouse.mouseclient.utils.trace.TraceContext;
import com.zjl.mouse.mouseclient.utils.trace.config.RpcConfig;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.RpcException;

@Activate
public class ClientTraceFilter implements Filter {
    private static RpcConfig rpcConfig;

    public ClientTraceFilter() {
    }

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        if (rpcConfig == null) {
            rpcConfig = (RpcConfig) SpringContext.getBean("rpcConfig");
        }

        String clientIp = "";

        try {
            clientIp = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException var5) {
            var5.printStackTrace();
        }

        RpcContext.getContext().setAttachment("traceId", TraceContext.getTraceId());
        RpcContext.getContext().setAttachment("spanId", TraceContext.getCurrSubSpanId());
        RpcContext.getContext().setAttachment("clientIp", clientIp);
        RpcContext.getContext().setAttachment("clientGroup", rpcConfig.getServerGroup());
        Result result = invoker.invoke(invocation);
        return result;
    }
}