package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTest {
public static void main(String[] args) {
	String logged="20210808175348";
	String transactioncode="WERTY1234";
	int Expiry=23;
	System.out.println("Status: "+expiredToken(logged, transactioncode));
	
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat formatTimestamp = new SimpleDateFormat("YYYYMMddHHmmss");
	String timestamp = formatTimestamp.format(calendar.getTime());
	
	System.out.println("timestamp1: "+timestamp);
	calendar.add(Calendar.MINUTE, Expiry);
	String timestamp2 = formatTimestamp.format(calendar.getTime());
	
	System.out.println("timestamp2: "+timestamp2);
}
public static boolean expiredToken(String timeStamp, String transactioncode) {
	try {
		Date date = new Date();
		SimpleDateFormat timeNow = new SimpleDateFormat("YYYYMMddHHmmss");
		long currentTimestamp = Long.parseLong(timeNow.format(date) + "");
		currentTimestamp=20210609180057L;
		
		if (timeStamp == null || timeStamp.isEmpty()) {
			System.out.println("TXN ID : " + transactioncode + " : tokenGenerator | CurrentTimestamp - " + currentTimestamp
					+ " greater than loggedTimestamp - " + timeStamp);
			return true;
		}
		long loggedTimestamp = Long.parseLong(timeStamp.trim());
		if (currentTimestamp < loggedTimestamp - 5 * 60) {
			System.out.println("TXN ID : " + transactioncode + " : tokenGenerator | CurrentTimestamp - " + currentTimestamp
					+ " less than loggedTimestamp - " + loggedTimestamp + " >> Skip token Retrival Step");
			return false;
		} else {
			System.out.println("TXN ID : " + transactioncode + " : tokenGenerator | CurrentTimestamp - " + currentTimestamp
					+ " greater than loggedTimestamp - " + loggedTimestamp);
			return true;
		}
	} catch (Exception ex) {
		System.out.println("TXN ID : " + transactioncode + " : tokenGenerator | expiredToken | Exception " + ex.getMessage());
		return true;
	}
}
}
