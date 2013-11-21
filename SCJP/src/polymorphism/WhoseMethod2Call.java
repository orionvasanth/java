/**
 * 
 */
package polymorphism;

/**
 * @author Vasanth Kumar Vadivelu(vavadive)
 *
 */
public class WhoseMethod2Call {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XYZ xyz = new ABC();
		xyz.function();
		
		String str = "hello";
		String str1 = "hello";
		
		System.out.println(str == str1);
	}
}

class XYZ{
	public void function(){
		System.out.println("parent..");
	}
}

class ABC extends XYZ {
	public void function(){
		System.out.println("child..");
	}
}
