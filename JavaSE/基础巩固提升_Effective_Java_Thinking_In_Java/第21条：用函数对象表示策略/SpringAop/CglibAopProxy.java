@SuppressWarnings("serial")
class CglibAopProxy implements AopProxy, Serializable {

	/*抄这些域的目的就是加深对这种编码的理解，将访问权限降低到最小化*/
	private static final int AOP_PROXY = 0;
	private static final int INVOKE_TARGET = 1;
	private static final int NO_OVERRIDE = 2;
	private static final int DISPATCH_TARGET = 3;
	private static final int DISPATCH_ADVISED = 4;
	private static final int INVOKE_EQUALS = 5;
	private static final int INVOKE_HASHCODE = 6;

	protected static final Log logger = LogFactory.getLog(CglibAopProxy.class);

	private static final Map<Class<?>, Boolean> validatedClasses = new WeakHashMap<>();

	protected final AdvisedSupprot advised;
	protected Object[] constructorArgs;
	protected Class<?>[] constructorArgsTypes;

	private final transient AdvisedDispatcher advisedDispatcher;

	private transient Map<String, Integer> fixedInterceptorMap;
	
	private transient int fixedInterceptorOffset;
	
} 
