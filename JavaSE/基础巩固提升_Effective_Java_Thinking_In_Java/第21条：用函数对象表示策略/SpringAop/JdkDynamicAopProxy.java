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
		this.advised = advised;
	}

	@Override 
	public Object getProxy() {
		return getProxy(ClassUtils.getDefaultClassLoader());
	}

	@Override
	public Object getProxy(ClassLoader classLoader) {
		if (logger.isDebugEnabled()) {
			logger.debug("Creating JDK dynamic proxy:");
		}
	}
} 
