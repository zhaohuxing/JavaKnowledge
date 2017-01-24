public interface AopProxy {
	Object getProxy();
	Object getProxy(ClassLoader classLoader);
}
