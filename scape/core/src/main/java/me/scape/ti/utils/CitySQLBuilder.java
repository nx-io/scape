package me.scape.ti.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.StreamUtils;

/**
 * 
 * @author 刘飞
 * 
 * @version 1.0.0
 * @since 2015年4月15日 下午4:24:15
 */
public class CitySQLBuilder {
	
	static final String Province_SQL_Template = "INSERT INTO `scape`.`province` (`id`, `name`) VALUES (%s, \"%s\");\n";
	
	static final String City_SQL_Template = "INSERT INTO `scape`.`city` (`id`, `name`, `province_id`) VALUES (%s, \"%s\", \"%s\");\n";

	static final String Region_SQL_Template = "INSERT INTO `scape`.`region` (`id`, `name`, `city_id`) VALUES (%s, \"%s\", \"%s\");\n";

	public static void main(String[] args) throws Exception {
		String target = "/Users/yp/workspace/scape/scape/docs/city.sql";
		String source = "/Users/yp/workspace/scape/scape/docs/city.json";
		String jsonString = StreamUtils.copyToString(new FileInputStream(source), Charset.forName("UTF-8"));
		JSONArray json = JSONArray.fromObject(jsonString);
		
		OutputStreamWriter writer = null;
		try {
			writer = new OutputStreamWriter(new FileOutputStream(new File(target), false), Charset.forName("UTF-8"));
			Object[] array = json.toArray();
			int province_id = 1;
			int city_id = 1;
			int region_id = 1;
			for (Object obj : array) {
				JSONObject object = JSONObject.fromObject(obj);
				String name = object.getString("name");
				if(StringUtils.equals(name, "请选择") || StringUtils.equals(name, "其他") || StringUtils.equals(name, "海外")) {
					province_id++;
					continue;
				}
				String Province_SQL = String.format(Province_SQL_Template, province_id, name);
				writer.write(Province_SQL);
				if(!object.has("sub")) {
					province_id++;
					continue;
				}
				JSONArray cityArrayObject = object.getJSONArray("sub");
				Object[] cityArray = cityArrayObject.toArray();
				for (Object city : cityArray) {
					JSONObject cityObject = JSONObject.fromObject(city);
					String cityName = cityObject.getString("name");
					if(StringUtils.equals(cityName, "请选择") || StringUtils.equals(cityName, "其他") || StringUtils.equals(cityName, "海外")) {
						city_id++;
						continue;
					}
					String City_SQL = String.format(City_SQL_Template, city_id, cityName, province_id);
					writer.write(City_SQL);
					if(!cityObject.has("sub")) {
						city_id++;
						continue;
					}
					JSONArray regionArrayObject = cityObject.getJSONArray("sub");
					Object[] regionArray = regionArrayObject.toArray();
					for (Object region : regionArray) {
						JSONObject regionObject = JSONObject.fromObject(region);
						String regionName = regionObject.getString("name");
						if(StringUtils.equals(regionName, "请选择") || StringUtils.equals(regionName, "其他") || StringUtils.equals(regionName, "海外")) {
							region_id++;
							continue;
						}
						String Region_SQL = String.format(Region_SQL_Template, region_id, regionName, city_id);
						writer.write(Region_SQL);
						region_id++;
					}
					city_id++;
				}
				province_id++;
			}
		} finally {
			if (writer != null) {
				writer.flush();
				writer.close();
				writer = null;
			}
		}
		
		System.out.println("Success.");
	}
}