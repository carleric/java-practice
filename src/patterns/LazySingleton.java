package patterns;
/**
 * 
 * @author carl
 * @comment This method uses double-checked locking, 
 * which should not be used prior to J2SE 5.0, as it is 
 * vulnerable to subtle bugs. The problem is that an 
 * out-of-order write may allow the instance reference 
 * to be returned before the Singleton constructor is 
 * executed.[8]


 *
 */
public class LazySingleton {
	private static volatile LazySingleton instance;
	
	private LazySingleton(){}
	
	public LazySingleton getInstance(){
		if(instance == null){
			synchronized(LazySingleton.class){
				if(instance == null)
					instance = new LazySingleton();
			}
		}
		return instance;
	}
}
