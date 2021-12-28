package aws.sort;

public class RunLengthEncoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("OUPUT="+new RunLengthEncoding().encode("aaabbccca"));
	}
	/**
	 * 
	 * aaabbccca = 3a2b3c1a
	 * 
	 * @param plain
	 * @return
	 */
	public String encode(String plainString) {
		//check for null
		if(plainString.equals(null) || plainString.length()==0)
			return "";
		char[] charArray = plainString.toCharArray();
		StringBuilder sb = new StringBuilder();
		int charCounter =0;
		char prevChar =0;
		for(char c:charArray) {
			if(prevChar==c)
				charCounter++;
			else {
				if(prevChar !=0) {
					sb.append(charCounter).append(prevChar);
				}
				prevChar=c;
				charCounter=1;
			}
		}
		sb.append(charCounter).append(prevChar);
		return sb.toString();
		
	}

}
