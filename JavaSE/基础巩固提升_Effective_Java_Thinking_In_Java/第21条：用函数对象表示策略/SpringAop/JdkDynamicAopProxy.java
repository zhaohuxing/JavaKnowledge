final class JdkDynamicAopProxy implements AopProxy, InvocationHandler, Serializable {
	
	private static final long serialVersionUID = 5531744639992436476L;
	private static final Log logger = LogFactory.getLog(JdkDynamicAopProxy.class);
	private final AdvisedSupport advised;
	private boolean equalsDefined;
	private boolean hashCodeDefined;

	public JdkDynamicAopProxy(AdvisedSupport config) throws AopConfigException {
		Assert.notNull(config, "AdvisedSupport must not be null");
		if (config.getAdvisors().length == 0 && config.getTargetSource() == AdvisedSupport.EMPTY_TARGET_SOURCE) {
			throw new AopConfigException("No advisors and no TargetSource specified");	
		}
		this.advised = config;
	}

	@Override 
	public Object getProxy() {
		return getProxy(ClassUtils.getDefaultClassLoader());
	}

	@Override
	public Object getProxy(ClassLoader classLoader) {
		if (logger.isDebugEnabled()) {
			logger.debug("Creating JDK dynamic proxy: target source is " + this.advised.getTargetSource());
		}
		Class<?>[] proxiedInterfaces = AopProxyUtils.completeProxiedInterfaces(this.advised, true);
		findDefinedEqualsAndHashCodeMethods(proxiedInterfaces);
		return Proxy.newProxyInstance(classLoader, proxiedInterfaces, this);
	}

	/*应用<Effective Java>第二版第13条：使类和成员的可访问性最小化*/
	private void findDefinedEqualsAndHashCodeMethods(Class<?>[] proxiedInterfaces) {
		for (Class<?> proxiedInterface : proxiedInterfaces ) {
			Method[] methods = proxiedInterface.getDeclaredMethods();
			for (Method method : methods) {
				if (AopUtils.isEqualsMethod(method)) {
					this.equalsDefined = true;
				}

				if (AopUtils.isHashCodeMethod(method)) {
					this.hashCodeDefined = true;
				}

				if (this.equalsDefined && this.hashCodeDefined) {
					return;
				}
			}
		}
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		MethodInvocation invocation;
		Object oldProxy = null;
		boolean setProxyContext= false;

		TargetSource targetSource = this.advised.targetSource;
		Class<?> targetClass = null;
		Object target = null; 

		try {
				//...省略				
		} finally {
			if (target != null && !targetSource.isStatic()) {
				targetSource.releaseTarget(target);
			}

			if (setProxyContext) {
				AopContext.setCurrentProxy(oldProxy);	
			}
		}
	}

	//Effective Java中第8条：覆盖equals时请遵守通用约定
	@Override
	public boolean equals(Object object) {
		if (other == this) {
			return true;
		}		

		if (other == null) {
			return false;
		}

		JdkDynamicAopProxy otherProxy;
		if (other instanceof JdkDynamicAopProxy) {
			otherProxy = (JdkDynamicAopProxy)other;	
		} else if (Proxy.isProxyClass(other.getClass())) {
			InvocationHandler ih = Proxy.getInvocationHandler(other);
			if (!(in instanceof JdkDynamicAopProxy)) {
				return false;
			}
			otherProxy = (JdkDynamicAopProxy)ih;
		} else {
			return false;
		}
		return AopProxyUtils.equalsInProxy(this.advised, otherProxy.advised);
	}

	//Effective Java中第9条：覆盖equals的同时也要覆盖hashCode
	@Override
	public int hashCode() {
		return JdkDynamicAopProxy.class.hashCode() * 13 + this.advised.getTargetSource().hashCode();
	}
} 
