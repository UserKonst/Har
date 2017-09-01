package harviewer.proxy;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import org.openqa.selenium.Proxy;

public class MobProxyServer implements ProxyServer {

    private BrowserMobProxy proxy;

    @Override
    public BrowserMobProxy getProxy() {
        return proxy;
    }

    @Override
    public MobProxyServer start() {
        proxy = new BrowserMobProxyServer();
        proxy.start();
        System.out.println("PROXY STARTED ON PORT: " + proxy.getPort());
        return this;
    }

    @Override
    public void start(int port) {
        proxy = new BrowserMobProxyServer();
        proxy.start(port);
    }

    @Override
    public void stop() {
        if (proxy != null && proxy.isStarted()) {
            proxy.stop();
        }
    }

    @Override
    public Proxy startSeleniumProxy() {
        start();
        return ClientUtil.createSeleniumProxy(proxy);
    }

    @Override
    public void newHar(String harName) {
        proxy.newHar(harName);
    }

    @Override
    public Har getHar() {
        return proxy.getHar();
    }

    @Override
    public boolean isStarted() {
        return proxy.isStarted();
    }

}
