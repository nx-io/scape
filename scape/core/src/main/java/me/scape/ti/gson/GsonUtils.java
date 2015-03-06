package me.scape.ti.gson;

import me.scape.ti.http.JSONResponseBody;
import me.scape.ti.utils.CalendarUtil;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author john.liu E-mail:fei.liu@yeepay.com
 * @version 1.0.0
 * @since 2014年12月31日 下午3:29:25
 */
public class GsonUtils {

	public final static Gson GSON = new GsonBuilder()
//			.setPrettyPrinting()//格式化
			.enableComplexMapKeySerialization()
//			.serializeNulls()
			.disableHtmlEscaping()
			.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
			.setDateFormat(CalendarUtil.S_YYYY_MM_DD_HH_MM_SS)
			.registerTypeAdapterFactory(new SmartTypeAdapterFactory())
			.create();

	public static void main(String[] args) {
		System.out.println(GsonUtils.GSON.toJson(new JSONResponseBody()));
	}

}