package codinghub;

import java.util.TreeMap;
/**
 * 
 * @author sakawaelijahbob
 * TreeMap supports sorting of values in ascending automatically 
 */
public class TreeMapGist {
	public static void main(String[] args) {
		TreeMap<String, String> mapper = new TreeMap<String,String>();
		mapper.put("cat","cat");
		mapper.put("act", "act");
		mapper.put("tac", "tac");
		
		System.out.println("MAP: "+mapper);
	}

}
