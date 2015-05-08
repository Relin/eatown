package be.relin.eatown.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PasswordUtil {

	private static final Logger logger = LogManager.getLogger("PasswordUtil");

	private static MessageDigest md;
	
	public static String cryptWithMD5(String pass){
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] passBytes = pass.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<digested.length;i++){
				sb.append(Integer.toHexString(0xff & digested[i]));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException ex) {
			logger.error(ex.toString());
		}
		return null;
	}
	
	public static boolean CheckPassword() {
		//TODO
		return false;
	}
}
