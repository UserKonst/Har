package harviewer.proxy;

import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import java.util.Optional;
import java.util.function.Consumer;
import net.lightbody.bmp.BrowserMobProxy;
import annotations.CaptureTraffic;

public class ProxyFilter {

    private BrowserMobProxy proxy;

    public ProxyFilter(BrowserMobProxy proxy) {
        this.proxy = proxy;
    }

    private final Consumer<String> requestMethod = this::addRequestMethod;
    private final Consumer<Integer> responseCodeFilter = this::addResponseCode;

    public void addFilters(CaptureTraffic annotation) {
        Optional.of(annotation.requestMethod()).filter(s -> !s.isEmpty()).ifPresent(requestMethod);
        Optional.of(annotation.responseCode()).filter(c -> c != 0).ifPresent(responseCodeFilter);
    }

    private void addRequestMethod(String httpMethod) {
        System.out.println("in request method: " + httpMethod);
        proxy.addRequestFilter((request, content, message) -> {
            request.setMethod(HttpMethod.GET);
            return null;
        });
    }

    private void addResponseCode(Integer code) {
        proxy.addResponseFilter((response, content, message) -> {
            response.setStatus(HttpResponseStatus.valueOf(code));
        });
    }

}
