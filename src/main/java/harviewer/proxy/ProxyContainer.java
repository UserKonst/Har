package harviewer.proxy;

public class ProxyContainer {

    private static ThreadLocal<ProxyServer> PROXY_CONTAINER = new ThreadLocal<>();

    public static ProxyServer get() {
        return PROXY_CONTAINER.get();
    }

    public static void put(ProxyServer proxy) {
        PROXY_CONTAINER.set(proxy);
    }

}
