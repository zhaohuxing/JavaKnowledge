public class ProxyCreatorSupport extends AdvisedSupport {
	private AopFactoryProxy aopFactoryProxy;

	//省略了一些代码，
	
	public ProxyCreatorSupport() {
		this.aopFactoryProxy = new DefaultAopProxyFactory();
	}

	public ProxyCreatorSupport(AopProxyFactory aopProxyFactory) {
		//...
		this.aopProxyFactory = aopProxyFactory;
	}

	//...
}
