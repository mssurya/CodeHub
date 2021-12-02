package test;

import java.util.regex.Pattern;

public class RegExPhoneNumber {
 public static void main(String[] args) {
	String regex ="^\\d{3}\\-\\d{3}\\-\\d{4}$";
	String tel="254-704-4192";

	
	Pattern p = Pattern.compile(regex);
	System.out.println(p.matcher(tel).matches());
}
}
