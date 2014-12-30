package me.scape.ti.gson;

import java.io.IOException;

import org.springframework.beans.BeanUtils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * 
 * @author john.liu E-mail:fei.liu@yeepay.com
 * @version 1.0.0
 * @since 2014年12月30日 下午1:18:09
 */
public class ObjectTypeAdapter<T> extends TypeAdapter<T> {
	
	private final TypeAdapter<T> defaultObjectTypeAdapter;
	
	private final Class<T> type;

	public ObjectTypeAdapter(TypeAdapter<T> defaultObjectTypeAdapter, Class<T> type) {
		super();
		this.defaultObjectTypeAdapter = defaultObjectTypeAdapter;
		this.type = type;
	}

	@Override
	public void write(JsonWriter out, T value) throws IOException {
		if(value == null) {
			value = BeanUtils.instantiate(type);
		}
		defaultObjectTypeAdapter.write(out, value);
	}

	@Override
	public T read(JsonReader in) throws IOException {
		return defaultObjectTypeAdapter.read(in);
	}
}