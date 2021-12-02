package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		String ref="QWEARRGGU";
		String Amnt="2200";
		double ant=100.0D;
		String list ="7100^7200^7300";
		List<String> agentAccSubSegment = new ArrayList<>();
		String[] grpConList = list.split("\\^");
		
		System.out.println("0"+grpConList[0]);
		System.out.println("1"+grpConList[1]);

		
		
		Map<Object,Object> amt =new HashMap<>();
		amt.put("LOCAL_LOCK", Amnt);
		
		if(ref.length()>6) {
		System.out.println(ref.substring(ref.length()-6));
		}
		System.out.println("AMOUNT="+Double.parseDouble(amt.get("LOCAL_LOCK")+""));
		int l=ref.length();
		for(int i=0;i<12-l;i++) {
			  ref=0+ref;
		  }
		System.out.println("ref: "+ref);
	}
	
}
