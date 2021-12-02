package test;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
//import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author esakawa
 */
public class EUCLPostPaid {
	//private static final Logger LOG = Logger.getLogger("BillerEngineStaticParams");

	public static Map<String, String> euclPostPaid(Map<String, String> params) {
		String transactioncode = params.get("TransactioncodeBiller").trim();
		String payloadTemp = params.get("PayloadTemplate");
		String hashKey = params.get("EncryptionKey").trim();
		
		for (Map.Entry<String, String> entry : params.entrySet()) {
			String key = entry.getKey().trim();
			String value = entry.getValue();
			String identifier = "[" + key + "]";
			if (!key.equalsIgnoreCase("PayloadTemplate")) {			
				if (payloadTemp.contains(identifier)) {
					payloadTemp = payloadTemp.replace(identifier, ("" + value).trim().replace("null", ""));
				} 				
			}
		}
		System.out.println(transactioncode+" :payloadTemp: " + payloadTemp);
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
		System.out.println(transactioncode+" :NewPayload: " +encStr);
		params.put("NewPayload", encStr);
		return params;
	
	}
}

