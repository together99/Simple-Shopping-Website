package register;

import java.security.MessageDigest;
import java.util.Random;

import sun.misc.BASE64Encoder;

public class TokenPro {

	public TokenPro() {
		// TODO Auto-generated constructor stub
	}
	public static String makeToke() {
		String token=(System.currentTimeMillis()+new Random().nextInt(999999999))+"";
		try{
			MessageDigest mDigest=MessageDigest.getInstance("md5");
			byte[] md5=mDigest.digest(token.getBytes());
			BASE64Encoder encoder=new BASE64Encoder();
			return encoder.encode(md5);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
