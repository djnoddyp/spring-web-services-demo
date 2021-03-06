package pnodder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import pnodder.clients.AccountClient;
import pnodder.endpoints.AccountServiceEndpoint;
import pnodder.services.AccountService;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class AppConfig {

    @Bean
    public SimpleJaxWsServiceExporter jaxWsServiceExporter() {
        SimpleJaxWsServiceExporter jaxWsServiceExporter = new SimpleJaxWsServiceExporter();
        jaxWsServiceExporter.setBaseAddress("http://localhost:8081/");
        return jaxWsServiceExporter;
    }

    @Bean
    public AccountServiceEndpoint accountServiceEndpoint() {
        return new AccountServiceEndpoint();
    }

    @Bean
    public JaxWsPortProxyFactoryBean accountWebService() throws MalformedURLException {
        JaxWsPortProxyFactoryBean accountWebService = new JaxWsPortProxyFactoryBean();
        accountWebService.setServiceInterface(AccountService.class);
        accountWebService.setWsdlDocumentUrl(new URL("http://localhost:8081/" +
                "spring-web-services-demo-1.0-SNAPSHOT/AccountService?WSDL"));
        accountWebService.setNamespaceUri("http://endpoints.pnodder/");
        accountWebService.setServiceName("AccountService");
        accountWebService.setPortName("AccountServiceEndpointPort");
        return accountWebService;
    }

    @Bean
    public AccountClient client() throws MalformedURLException {
        AccountClient client = new AccountClient();
        client.setAccountService((AccountService) accountWebService().createJaxWsService());
        return client;
    }

}
