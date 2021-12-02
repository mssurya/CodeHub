package test;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class payload {
	public static void main(String[] args) {
		
		Map<String, String> incomingMap = new HashMap<>();
		
		incomingMap.put("PayloadTemplate", "{\"customerId\":\"[BillRefNumber]\",\"invoiceNo\":\"[InvoiceNo]\",\"modeofPayment\":\"[PaymentType]\",\"paymentDate\":\"[TransactionDate]\",\"paymentRefNo\":\"[TransactionReference]\",\"paymentAmount\":\"[TransactionAmount]\",\"userId\":\"[UserID]\",\"remarks\":\"[Narration]\"}");
		incomingMap.put("AmountAndCharges", "2100");
		incomingMap.put("ServiceBillerCompanyId", "KE0010001");
		incomingMap.put("BillRefNumber", "159160020");
		incomingMap.put("CommAndExciseDuty", "0");
		incomingMap.put("TransactionReference", "QWASEFD116");
		incomingMap.put("ISO_field7", "1217105205");
		incomingMap.put("ServiceBillermobileNo", "254704419289");
		incomingMap.put("Narration", "Bill Payments");
		incomingMap.put("Wait4T24TxnUpload", "0");
		incomingMap.put("RunningDate", "20201217105205");
		incomingMap.put("EncryptionKey", "IBM5$7!#HU7A82&#");
		incomingMap.put("UserID", "bpruser");
		incomingMap.put("PaymentType", "Cash");
		incomingMap.put("TransactionDate", "17-Dec-2020");
		incomingMap.put("InvoiceNo", "4555");
		incomingMap.put("TransactionAmount", "2100");
		incomingMap.put("Wait4T24TxnUpload", "0");
		incomingMap.put("RunningDate", "20201217105205");
		incomingMap.put("TransactioncodeBiller", "20217105205");
		
		EUCLPostPaid.euclPostPaid(incomingMap);
		
		String payloadTemp = incomingMap.get("PayloadTemplate");
		String hashKey = incomingMap.get("EncryptionKey").trim();
		
		for (Map.Entry<String, String> entry : incomingMap.entrySet()) {
			String key = entry.getKey().trim();
			String value = entry.getValue();
			String identifier = "[" + key + "]";
			if (!key.equalsIgnoreCase("PayloadTemplate")) {			
				if (payloadTemp.contains(identifier)) {
					payloadTemp = payloadTemp.replace(identifier, ("" + value).trim().replace("null", ""));
				} 				
			}
		}
		//System.out.println("payloadTemp: -" + payloadTemp);
		Key aesKey = new SecretKeySpec(hashKey.getBytes(), "AES");
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (NoSuchPaddingException e1) {
			e1.printStackTrace();
		}
		// encrypt the text
		try {
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		byte[] encrypted = null;
		try {
			encrypted = cipher.doFinal(payloadTemp.getBytes());
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		String encStr = new String(DatatypeConverter.printBase64Binary(encrypted));
		//System.out.println("NewPayload: " +encStr);
	
	}

}
