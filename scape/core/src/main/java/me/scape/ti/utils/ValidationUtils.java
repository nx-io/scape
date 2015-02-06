package me.scape.ti.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public final class ValidationUtils {

	public static boolean isNumerical(final String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	public static boolean isEmail(final String email) {
		if (StringUtils.isEmpty(email)) {
			return false;
		}
		String emailPattern = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))" + "([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern mailPattern = Pattern.compile(emailPattern);
		Matcher mailMatcher = mailPattern.matcher(email);
		return mailMatcher.matches();
	}

	public static boolean isMobilePhoneNumber(final String mobilePhoneNumber) {
		if (StringUtils.isEmpty(mobilePhoneNumber)) {
			return false;
		}
		String phonePatternStr = "^1[0-9]{10}$";
		Pattern phonePattern = Pattern.compile(phonePatternStr);
		Matcher phoneMatcher = phonePattern.matcher(mobilePhoneNumber);
		return phoneMatcher.matches();
	}

	public static boolean isPhoneNumber(final String phoneNumber) {
		if (StringUtils.isEmpty(phoneNumber)) {
			return false;
		}
		String phonePatternStr = "^([0-9]{3,5})-([0-9]{7,8})(-[0-9]+)?$";
		Pattern phonePattern = Pattern.compile(phonePatternStr);
		Matcher phoneMatcher = phonePattern.matcher(phoneNumber);
		return phoneMatcher.matches();
	}

	public static boolean isFullURL(final String url) {
		boolean flag = false;
		if (StringUtils.isNotBlank(url)) {
			flag = url.toLowerCase().startsWith("http");
		}
		return flag;
	}

	public static boolean isQQNumber(final String qqNumber) {
		if (StringUtils.isEmpty(qqNumber)) {
			return false;
		}
		String qqPatternStr = "^[1-9][0-9]{4,}$";
		Pattern qqPattern = Pattern.compile(qqPatternStr);
		Matcher qqMatcher = qqPattern.matcher(qqNumber);
		return qqMatcher.matches();
	}
}
