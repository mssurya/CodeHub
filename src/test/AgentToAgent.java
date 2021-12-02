package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AgentToAgent {
	public static void main(String[] args) {
		
		//agent_group_Conditions = 
		String agent_sub_segment = "71001^111001";
		List<String> agentAccSubSegment = new ArrayList<>();

		String[] accSubSegList = agent_sub_segment.split("\\^");
		for (int i = 0; i < accSubSegList.length; i++) {
			agentAccSubSegment.add(accSubSegList[i]);
		}
		System.out.println(agentAccSubSegment.contains("111002"));
		
	}

}
