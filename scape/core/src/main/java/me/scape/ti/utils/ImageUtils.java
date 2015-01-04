package me.scape.ti.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年1月5日 上午12:23:01
 */
public class ImageUtils {

	private static final String QINIU_CDN = "http://agile.qiniudn.com/";

	public static String urlWrapper(String image) {
		if(StringUtils.isBlank(image)) {
			return null;
		}
		if(StringUtils.startsWith(image, "http://")) {
			return image;
		}
		return QINIU_CDN + image;
	}
}