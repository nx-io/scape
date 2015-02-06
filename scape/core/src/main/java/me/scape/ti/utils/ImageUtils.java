package me.scape.ti.utils;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年1月5日 上午12:23:01
 */
public class ImageUtils {

	public static String urlWrapper(String image) {
		return CDNUtil.getFullPath(image);
	}
}