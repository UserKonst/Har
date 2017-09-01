package harviewer.proxy;

import static java.util.Optional.ofNullable;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Proxy;
import annotations.CaptureTraffic;
import net.lightbody.bmp.core.har.Har;

public class ProxyFactory {

    private static final ThreadLocal<BrowserMobProxy> PROXY_CONTAINER = new ThreadLocal<>();

    public static BrowserMobProxy getProxy() {
        return PROXY_CONTAINER.get();
    }

    public static BrowserMobProxy startProxy() {
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start();
        PROXY_CONTAINER.set(proxy);
        return proxy;
    }

    public static BrowserMobProxy startProxy(CaptureTraffic annotation) {
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start();
        PROXY_CONTAINER.set(proxy);
        proxy.newHar("test");
//        if (AnnotationUtils.isContainsFilters(annotation)) {
//            System.out.println("FILTERS");
//            ProxyFilter filter = new ProxyFilter(proxy);
//            filter.addFilters(annotation);
//        };
        System.out.println("proxy started");
        return proxy;
    }

    public static Proxy startSeleniumProxy() {
        BrowserMobProxy proxy = startProxy();
        PROXY_CONTAINER.set(proxy);
        return ClientUtil.createSeleniumProxy(proxy);
    }

    public static void stopProxy() {
        ofNullable(getProxy()).ifPresent(BrowserMobProxy::stop);
        PROXY_CONTAINER.remove();
        System.out.println("proxy stopped");
    }

    public static void newHar(String harName) {
        getProxy().newHar(harName);
    }

    public static Har getHar() {
       return getProxy().getHar();
    }

    public static void addRequestFilter() {

    }

}
