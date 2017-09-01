package harviewer.tests;

import static com.codeborne.selenide.Selenide.open;
import org.testng.annotations.Test;
import da.newpm.annotations.CaptureTraffic;
import org.testng.annotations.Listeners;

@Listeners({da.newpm.tests.config.listeners.TestErrorListener.class})
public class ProxyTest extends BaseTest{

    @CaptureTraffic
    @Test
    public void t() {
        System.out.println("test 1 started");
        open("https://google.com.ua");
    }
    
//    @CaptureTraffic
//    @Test
//    public void tdataart() {
//        System.out.println("test 2 started");
//        open("https://dataart.com");
//    }

}
