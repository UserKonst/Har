package harviewer.tests;

import browser.BrowserFactory;
import proxy.ProxyFactory;
import java.lang.reflect.Method;
import net.lightbody.bmp.BrowserMobProxy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import annotations.CaptureTraffic;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(Method method) throws Exception {
        CaptureTraffic annotation = MethodUtils.getRecordTrafficAnnotation(method);
        if (annotation != null) {
            BrowserMobProxy proxy = ProxyFactory.startProxy(annotation);
            BrowserFactory.openBrowser("chrome", proxy);
            return;
        }
        BrowserFactory.openBrowser("chrome");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(Method method) {
        if (MethodUtils.isAnnotated(method, CaptureTraffic.class)) {
            ProxyFactory.stopProxy();
        }
        BrowserFactory.closeBrowser();
    }

}
