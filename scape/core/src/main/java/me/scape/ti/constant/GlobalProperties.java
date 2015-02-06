package me.scape.ti.constant;

import java.util.Properties;

import me.scape.ti.utils.PropertiesUtil;

public final class GlobalProperties {

	private static final String PROPERTIES_PATH = "/global.properties";

	public static String CDN_DOMAIN = "";

	public static String CDN_ACCESS_KEY = "";

	public static String CDN_SECRET_KEY = "";

	public static String CDN_BUCKET_NAME = "";

	static {
		Properties globalProperties = PropertiesUtil.getProperties(PROPERTIES_PATH);

		if (PropertiesUtil.get(globalProperties, "cdn_domain") != null) {
			CDN_DOMAIN = PropertiesUtil.get(globalProperties, "cdn_domain");
		}
		if (PropertiesUtil.get(globalProperties, "cdn_access_key") != null) {
			CDN_ACCESS_KEY = PropertiesUtil.get(globalProperties, "cdn_access_key");
		}
		if (PropertiesUtil.get(globalProperties, "cdn_secret_key") != null) {
			CDN_SECRET_KEY = PropertiesUtil.get(globalProperties, "cdn_secret_key");
		}
		if (PropertiesUtil.get(globalProperties, "cdn_bucket_name") != null) {
			CDN_BUCKET_NAME = PropertiesUtil.get(globalProperties, "cdn_bucket_name");
		}
	}

}
