package me.scape.ti.utils;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年2月2日 下午2:39:33
 */
public class HexUtils {
	/**
	 * 将HEX字符串转换为Byte数组
	 * 
	 * @param hex
	 * @return
	 */
	public static byte[] decodeHex(String hex) {
		return decodeHex(hex, '0');
	}

	/**
	 * 将HEX字符串转换为Byte数组
	 * 
	 * @param hex
	 * @param padChar
	 * @return
	 */
	public static byte[] decodeHex(String hex, char padChar) {
		if (hex == null) {
			return null;
		}

		if (hex.length() % 2 == 1) {
			hex += padChar;
		}

		try {
			return Hex.decodeHex(hex.toCharArray());
		} catch (DecoderException e) {
			throw new RuntimeException("Decode hex error", e);
		}
	}

	/**
	 * 将数组转换成HEX字符串
	 * 
	 * @param bytes
	 * @return
	 */
	public static String encodeHex(byte[] bytes) {
		return encodeHex(bytes, false);
	}

	/**
	 * 将数组转换成HEX字符串
	 * 
	 * @param bytes
	 * @param toLowerCase
	 * @return
	 */
	public static String encodeHex(byte[] bytes, boolean toLowerCase) {
		if (bytes == null) {
			return null;
		}

		return new String(Hex.encodeHex(bytes, toLowerCase));
	}

	private HexUtils() {
	}
}