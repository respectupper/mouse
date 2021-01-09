package com.zjl.mouse.mouseclient.utils.trace.cxf.soap;

import java.lang.reflect.Method;
import javax.xml.namespace.QName;

import com.zjl.mouse.mouseclient.utils.trace.TraceContext;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.service.Service;
import org.apache.cxf.service.invoker.MethodDispatcher;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ServerTraceInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ServerTraceInterceptor() {
        super("pre-invoke");
    }

    public void handleMessage(SoapMessage message) throws Fault {
        QName qname = new QName("RpcClientRequest");
        Header header = message.getHeader(qname);
        if (header != null) {
            Element element = (Element)header.getObject();
            Node node1 = element.getElementsByTagName("ip").item(0);
            Node node2 = element.getElementsByTagName("group").item(0);
            Node node3 = element.getElementsByTagName("traceId").item(0);
            Node node4 = element.getElementsByTagName("spanId").item(0);
            String address = (String)message.get("org.apache.cxf.request.uri");
            BindingOperationInfo bop = (BindingOperationInfo)message.getExchange().get(BindingOperationInfo.class);
            MethodDispatcher md = (MethodDispatcher)((Service)message.getExchange().get(Service.class)).get(MethodDispatcher.class.getName());
            Method m = md.getMethod(bop);
            if (null != node1 && null != node2 && null != node3 && null != node4) {
                TraceContext.initTrace(node3.getTextContent(), node4.getTextContent());
                TraceContext.setTag("clientIp", node1.getTextContent());
                TraceContext.setTag("clientGroup", node2.getTextContent());
                TraceContext.setTag("method", m.getName());
                TraceContext.setTag("service", m.getDeclaringClass().getName());
                TraceContext.setTag("protocol", "WebService");
                this.logger.info("请求WebService服务={}|方法={}|来源IP={}|来源服务={}", new Object[]{address, m.getName(), node1.getTextContent(), node2.getTextContent()});
            } else {
                Node reqAddress = element.getElementsByTagName("address").item(0);
                Node reqHost = element.getElementsByTagName("host").item(0);
                this.logger.info("请求WebService服务={}|方法={}|来源IP={}|来源主机={}", new Object[]{address, m.getName(), reqAddress.getTextContent(), reqHost.getTextContent()});
            }
        }
    }
}