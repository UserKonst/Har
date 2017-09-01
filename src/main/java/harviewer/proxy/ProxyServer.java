package harviewer.proxy;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.core.har.Har;
import org.openqa.selenium.Proxy;

public interface ProxyServer {

    public BrowserMobProxy getProxy();
    
    public MobProxyServer start();

    public void start(int port);

    public void stop();

    public Proxy startSeleniumProxy();
    
    public void newHar(String harName);

    public Har getHar();
    
    public boolean isStarted();

}
