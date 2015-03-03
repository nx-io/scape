package me.scape.ti.utils;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月3日 下午5:35:19
 */
public enum SystemSettingKey {

	APP_VERSION_IOS("setting.version.ios", "IOS APP版本设置"),
	
	APP_VERSION_ANDROID("setting.version.android", "Android APP版本设置"),
	
	;

	public final String key;
	public final String description;

	private SystemSettingKey(String key, String description) {
		this.key = key;
		this.description = description;
	}
}
