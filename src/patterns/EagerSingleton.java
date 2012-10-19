package patterns;
/**
 * 
 * @author carl
 * @comment If the program will always need an instance, 
 * or if the cost of creating the instance is not too large in 
 * terms of time/resources, the programmer can switch to eager 
 * initialization, which always creates an instance:
 *
 */
public class EagerSingleton {
	private static final EagerSingleton instance = new EagerSingleton();
	
	private EagerSingleton(){}
	
	public EagerSingleton getInstance(){
		return instance;
	}
}
