package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UNHCR {

	public static void main(String[] args) {
		String charge_waive_group_Conditions = "11221^11228";
		String charge_waive_sub_segment = "7130^7131";
		String charge_waive_cap_limit = "5000^10000000";

		Map<String, List> chargeWaiveMap = new HashMap<>();

		String[] grpCList = charge_waive_group_Conditions.split("\\^");
		String[] accSubList = charge_waive_sub_segment.split("\\^");
		String[] capLimitList = charge_waive_cap_limit.split("\\^");
		List<String> finalList1 = new ArrayList<>();
		List<String> finalList2 = new ArrayList<>();
		finalList1.add(accSubList[0]);
		finalList1.add(capLimitList[0]);

		finalList2.add(accSubList[1]);
		finalList2.add(capLimitList[1]);

		// chargeWaiveMap.put(grpCList[0], finalList1);
		// chargeWaiveMap.put(grpCList[1], finalList2);
		System.out.println("========================= CHARGE WAIVES FOR INUA JAMII & UNHCR ==========================");
		try {
			System.out.println("INUA JAMII /UNCHR 1ST LIST: " + finalList1);
			System.out.println("INUA JAMII /UNCHR 2ND LIST: " + finalList2);
			System.out.println("INUA JAMII /UNCHR GRP CONT: " + chargeWaiveMap.get("11228").contains("7131"));

			if (chargeWaiveMap.get("11228").get(0).equals("7131")) {
				System.out.println("INUA JAMII /UNCHR GRP AMT: " + chargeWaiveMap.get("11228").get(1));
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
		List<String> tzStaffGrpCondition= new ArrayList<>();
		String tzGrpCondition = "11221^11228";
		String[] tzGrpCList = tzGrpCondition.split("\\^");
		for (int i = 0; i < tzGrpCList.length; i++) {
			tzStaffGrpCondition.add(tzGrpCList[i]);
		}
		System.out.println("TEST: "+tzStaffGrpCondition);
	}

}
