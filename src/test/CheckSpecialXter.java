package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckSpecialXter {
    public static void main(String args[]) {
        
    	String inputString = "/ NHIF P2219576";
        String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}' '";
        for (int i=0; i < inputString.length() ; i++)
        {
            char ch = inputString.charAt(i);
            if(specialCharactersString.contains(Character.toString(ch))) {
                System.out.println(inputString+ " contains special character");
                break;
            }    
            else if(i == inputString.length()-1)     
                System.out.println(inputString+ " does NOT contain special character");
        }
        /*
    	String inputString = "KII12/58475";
    	/ NHIF P2219576
    	String regex="MATCH=[^a-zA-Z0-9]";
    	System.out.println(extraCheck(regex,inputString));
    	
        /*Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(inputString);
        System.out.println("matcher="+matcher.find());
        boolean isStringContainsSpecialCharacter = matcher.find();
        if(isStringContainsSpecialCharacter)
            System.out.println(inputString+ " contains special character");
        else    
            System.out.println(inputString+ " does NOT contain special character");
       */     
    }
    private static String extraCheck(String regex,String rawValue){
    	if (regex.startsWith("REMOVE=")) {
    	                regex = regex.replace("REMOVE=", "");
    	                rawValue = rawValue.replaceAll(regex, "");
    	            } else if (regex.startsWith("REPLACE=")) {
    	                regex = regex.replace("REPLACE=", "");
    	                String regexFinal0[] = regex.split("\\,");
    	                rawValue = rawValue.replace(regexFinal0[0], regexFinal0[1]);
    	               
    	                
    	            } else if (regex.startsWith("REPLACEALL=")) {
    	                regex = regex.replace("REPLACEALL=", "");
    	                String regexFinal0[] = regex.split("\\,");
    	                rawValue = rawValue.replaceAll(regexFinal0[0], regexFinal0[1]);
    	            } else {
    	                if (regex.contains("-->OR-->")) {
    	                    regex = regex.replace("MATCH=", "");
    	                    String regexFinal0[] = regex.split("-->OR-->");
    	                    String regexFinal1 = regexFinal0[0];
    	                    String regexFinal2 = regexFinal0[1];
    	                    boolean matches1 = Pattern.matches(regexFinal1, rawValue);
    	                    boolean matches2 = Pattern.matches(regexFinal2, rawValue);
    	                   
    	                    if (!matches1 && !matches2) {
    	                        rawValue = "ValueError: Invalid Account " + rawValue;
    	                    }
    	                } else {
    	                    regex = regex.replace("MATCH=", "");
    	                    //System.out.println("rawValue="+regex);
    	                   // Pattern pattern = Pattern.compile(regex);
    	                    //Matcher matche = pattern.matcher(rawValue);
    	                    //boolean matches = matche.find();
    	                    boolean matches = Pattern.matches(regex, rawValue);
    	                    System.out.println("matches="+matches);

    	                    if (!matches) {
    	                        rawValue = "ValueError: Value " + rawValue + " failed validation";
    	                    }
    	                    
    	                }
    	            }

    	  return rawValue;
    	}
}
