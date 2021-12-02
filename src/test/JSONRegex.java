package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSONRegex {
	public static void main(String[] args) {
		String test="[\n"
				+ "  {\n"
				+ "    \"rank\": 1,\n"
				+ "    \"cnt\": 5,\n"
				+ "    \"tt\": \"The Great Gatsby\",\n"
				+ "    \"au\": \"F. Scott Fitzgerald\",\n"
				+ "    \"yr\": \"1990\"\n"
				+ "  },\n"
				+ "  {\n"
				+ "    \"rank\": 2,\n"
				+ "    \"cnt\": 5,\n"
				+ "    \"tt\": \"The Grapes of Wrath\",\n"
				+ "    \"au\": \"John Steinbeck\",\n"
				+ "    \"yr\": \"1972\"\n"
				+ "  },";
		String regex="(?:\"au\":\")(.*?)(?:\")";
		
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(test);
        System.out.println("matcher="+matcher.find());
	}
}
