package me.scape.ti.utils;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年3月3日 下午5:25:38
 */
public enum SystemSettingGroup {

	APP_VERSION(1L, "APP版本设置"),
	
	;

	public final long groupId;
	public final String description;

	private SystemSettingGroup(long groupId, String description) {
		this.groupId = groupId;
		this.description = description;
	}
}