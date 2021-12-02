package test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

public class PasswordCipher {
	public static void main(String[] args) {
		String plainText ="gigiri2030";
		PasswordCipher pc= new PasswordCipher();
		System.out.println("Encryption: "+pc.cipher(plainText));
		System.out.println("Decryption: "+pc.decipher(pc.cipher(plainText)));
	}
	 private static final String KEY = "Ribashongilogasheshiakili";

	    public String cipher(final String text) {
	        String hashedPass = "";
	        try {
	            hashedPass = new String(Base64.encodeBase64(this.xor(text.getBytes())), "UTF-8");
	            
	        } catch (UnsupportedEncodingException ex) {
	            System.out.println("CipherPasswords : encrypt " + ex.getMessage());
	            ex.printStackTrace();
	        }
	        return hashedPass;
	    }

	    public String decipher(final String hash) {
	        //System.err.println("Encrypt"); 
	        String plainPass = "";
	        try {
	            plainPass =  new String(this.xor(Base64.decodeBase64(hash.getBytes())), "UTF-8");
	        } catch (java.io.UnsupportedEncodingException ex) {
	            throw new IllegalStateException(ex);
	            
	        }
	        return plainPass;
	    }

	    private byte[] xor(final byte[] input) {
	        final byte[] output = new byte[input.length];
	        final byte[] secret = this.KEY.getBytes();
	        int spos = 0;
	        for (int pos = 0; pos < input.length; ++pos) {
	            output[pos] = (byte) (input[pos] ^ secret[spos]);
	            spos += 1;
	            if (spos >= secret.length) {
	                spos = 0;
	            }
	        }
	        return output;
	    }
	    public static String SHAHashing(String password) {
	        try{
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        md.update(password.getBytes());
	        byte byteData[] = md.digest();
	        // convert the byte to hex format method 1
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
	                    .substring(1));
	        }
	        StringBuffer hexString = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	            String hex = Integer.toHexString(0xff & byteData[i]);
	            if (hex.length() == 1) {
	                hexString.append('0');
	            }
	            hexString.append(hex);
	        }

	        String str1 = hexString.toString();
	        return str1.toUpperCase();
	        } catch (Exception e){
	            System.err.println("CipherPasswords | SHAHashing " + e.getMessage());
	        return null;   
	        }  
	    }
	    public static String encodebase64(String orig,String transactioncode) {
	        try{
	        byte[] encoded = Base64.encodeBase64(orig.getBytes());
	        return new String(encoded);
	        } catch (Exception e){
	        	System.err.println("CipherPasswords | SHAHashing " + e.getMessage());
	        return null;   
	        }
	    }
}
