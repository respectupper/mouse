package com.zjl.mouse.utils.trace.cxf.soap;

import com.zjl.mouse.utils.trace.TraceContext;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.zjl.mouse.utils.trace.config.RpcConfig;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapPreProtocolOutInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author zhujinglei
 */
public class ClientTraceInterceptor extends AbstractSoapInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private RpcConfig rpcConfig;

    public RpcConfig getRpcConfig() {
        return this.rpcConfig;
    }

    public void setRpcConfig(RpcConfig rpcConfig) {
        this.rpcConfig = rpcConfig;
    }

    public ClientTraceInterceptor() {
        super("write");
        this.addAfter(SoapPreProtocolOutInterceptor.class.getName());
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        DocumentBuilder builder = null;

        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException var24) {
            var24.printStackTrace();
        }

        String traceId = "";
        String spanId = "";
        String clientIp = "";
        String clientGroup = "";
        String reqAddress = "";
        String reqHost = "";

        try {
            traceId = TraceContext.getTraceId();
            spanId = TraceContext.getCurrSubSpanId();
            clientIp = InetAddress.getLocalHost().getHostAddress();
            clientGroup = this.rpcConfig.getServerGroup();
            reqAddress = InetAddress.getLocalHost().getHostAddress();
            reqHost = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException var23) {
            var23.printStackTrace();
        }

        Document doc = builder.newDocument();
        Element elementCredentials = doc.createElement("RpcClientRequest");
        Element element1 = doc.createElement("ip");
        element1.setTextContent(clientIp);
        Element element2 = doc.createElement("group");
        element2.setTextContent(clientGroup);
        Element element3 = doc.createElement("traceId");
        element3.setTextContent(traceId);
        Element element4 = doc.createElement("spanId");
        element4.setTextContent(spanId);
        elementCredentials.appendChild(element1);
        elementCredentials.appendChild(element2);
        elementCredentials.appendChild(element3);
        elementCredentials.appendChild(element4);
        QName qnameCredentials = new QName("RpcClientRequest");
        Header header = new Header(qnameCredentials, elementCredentials);
        Element elementCredentials2 = doc.createElement("clientRequest");
        Element elementUser = doc.createElement("address");
        elementUser.setTextContent(reqAddress);
        Element elementPassword = doc.createElement("host");
        elementPassword.setTextContent(reqHost);
        elementCredentials2.appendChild(elementUser);
        elementCredentials2.appendChild(elementPassword);
        QName qnameCredentialstemp = new QName("clientRequest");
        Header header2 = new Header(qnameCredentialstemp, elementCredentials2);
        message.getHeaders().add(header);
        message.getHeaders().add(header2);
        String address = (String)message.get(Message.ENDPOINT_ADDRESS);
        this.logger.info("访问远程WebService服务|服务地址={}", address);
    }
}