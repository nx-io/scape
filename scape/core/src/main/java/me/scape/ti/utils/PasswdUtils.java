package me.scape.ti.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月27日 下午5:28:08
 */
public class PasswdUtils {

	private static final Logger log = LoggerFactory.getLogger(PasswdUtils.class);

	private static final String HMAC_256 = "HmacSHA256";
	
	public static String signPwsswd(String passwd, String token) {
		String result = null;
		try {
			Mac sha256_HMAC = Mac.getInstance(HMAC_256);
			SecretKeySpec secret_key = new SecretKeySpec(token.getBytes(Charsets.UTF_8), HMAC_256);
			sha256_HMAC.init(secret_key);
			byte sig[] = sha256_HMAC.doFinal(passwd.getBytes(Charsets.UTF_8));
			result = Base64.encodeBase64URLSafeString(sig);
		} catch (Exception e) {
			log.error("Passwd sign Error.", e);
		}
		return result;
	}
}