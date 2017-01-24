import java.io.Serializable;
//省略了一些spring中的import
@SuppressWarning("serial")
public class DefaultAopProxyFactory implements AopProxyFactory, Serializable {
	//由于AdvisedSupprot牵扯的类太多,没有编写。主要了解下编码风格和aop实现的本质
	@Override
	public AopProxy createAopProxy(AdvisedSupport config) throws AopConfigException {
		if (config.isOptimize() || config.isProxyTargetClass() || hasNoUserSuppliedProxyInterfaces(config)) {
			Class<?> targetClass = config.getTargetClass();
			if (targetClass == null) {
				throw new AopConfigException("TargetSource cannot determine target class:" + 
						"Either an interface or a target is required for proxy creation.");
			}

			if (targetClass.isInterface() || Proxy.isProxyClass(targetClass)) {
				return new JdkDynamicAopProxy(config);
			}
			return new ObjenesisCglibAopProxy(config);
		}	else {
			return JdkDynamicAopProxy(config);
		}
	}
	
	/*Effective Java第二版中 第13条：使类和成员的可访问性最小化*/
	private boolean hasNoUserSuppliedProxyInterfaces(AdvisedSupport config) {
		Class<?>[] ifcs = config.getProxiedInterfaces();
		return (ifcs.length == 0 || (ifcs.length == 1 && SpringProxy.class.isAssignableFrom(ifcs[0])));
	}
} 
