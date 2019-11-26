package eric.test;

import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args){
		var pattern = Pattern.compile("10x10");
		var matcher = pattern.matcher("10x10");
		matcher.find();
		
		System.out.println(matcher.group(0));
	}
}
