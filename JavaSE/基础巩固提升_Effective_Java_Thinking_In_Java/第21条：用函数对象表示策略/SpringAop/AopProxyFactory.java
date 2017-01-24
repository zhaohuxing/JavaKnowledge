public interface AopProxyFactory {
	AopProxy createAopProxy(AdvisedSupport config) throws AopConfigException; 	
}
