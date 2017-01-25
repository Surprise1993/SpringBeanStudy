package demo1;

public class OneInterfaceImpl implements OneInterface {

	@Override
	public String hello(String word) {
		return "Im OneIterface :" + word;
	}

}
