package me.scape.ti.gson;

import java.util.List;
import java.util.Map;

import me.scape.ti.vo.AreaCategoryVO;
import me.scape.ti.vo.CategoryVO;
import me.scape.ti.vo.CommentsVO;
import me.scape.ti.vo.ItemMediaVO;
import me.scape.ti.vo.ItemVO;
import me.scape.ti.vo.LabelVO;
import me.scape.ti.vo.PlantCategoryVO;
import me.scape.ti.vo.PlantMediaVO;
import me.scape.ti.vo.PlantsOrnamentalColorVO;
import me.scape.ti.vo.PlantsOrnamentalPeriodVO;
import me.scape.ti.vo.PlantsVO;
import me.scape.ti.vo.StyleVO;
import me.scape.ti.vo.UserVO;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

/**
 * 
 * @author john.liu E-mail:fei.liu@yeepay.com
 * @version 1.0.0
 * @since 2014年12月30日 下午12:01:41
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class SmartTypeAdapterFactory implements TypeAdapterFactory {

	@Override
	public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
		Class<? super T> rawType = type.getRawType();
		if (String.class == rawType) {
			return (TypeAdapter<T>) new StringTypeAdapter((TypeAdapter<String>) gson.getDelegateAdapter(this, type));
		}
		if (Number.class.isAssignableFrom(rawType)) {
			return (TypeAdapter<T>) new NumberTypeAdapter((TypeAdapter<Number>) gson.getDelegateAdapter(this, type));
		}
		if (Boolean.class == rawType) {
			return (TypeAdapter<T>) new BooleanTypeAdapter((TypeAdapter<Boolean>) gson.getDelegateAdapter(this, type));
		}
		if (Map.class == rawType) {
			return (TypeAdapter<T>) new MapTypeAdapter((TypeAdapter<Map>) gson.getDelegateAdapter(this, type));
		}
		if (List.class == rawType) {
			return (TypeAdapter<T>) new ListTypeAdapter((TypeAdapter<List>) gson.getDelegateAdapter(this, type));
		}
		if (rawType.isArray()) {
			return (TypeAdapter<T>) new ArrayTypeAdapter((TypeAdapter<Object[]>) gson.getDelegateAdapter(this, type));
		}
		if (AreaCategoryVO.class == rawType) {
			return (TypeAdapter<T>) new ObjectTypeAdapter((TypeAdapter<AreaCategoryVO>) gson.getDelegateAdapter(this, type), AreaCategoryVO.class);
		}
		if (CategoryVO.class == rawType) {
			return (TypeAdapter<T>) new ObjectTypeAdapter((TypeAdapter<CategoryVO>) gson.getDelegateAdapter(this, type), CategoryVO.class);
		}
		if (ItemMediaVO.class == rawType) {
			return (TypeAdapter<T>) new ObjectTypeAdapter((TypeAdapter<ItemMediaVO>) gson.getDelegateAdapter(this, type), ItemMediaVO.class);
		}
		if (ItemVO.class == rawType) {
			return (TypeAdapter<T>) new ObjectTypeAdapter((TypeAdapter<ItemVO>) gson.getDelegateAdapter(this, type), ItemVO.class);
		}
		if (StyleVO.class == rawType) {
			return (TypeAdapter<T>) new ObjectTypeAdapter((TypeAdapter<StyleVO>) gson.getDelegateAdapter(this, type), StyleVO.class);
		}
		if (UserVO.class == rawType) {
			return (TypeAdapter<T>) new ObjectTypeAdapter((TypeAdapter<UserVO>) gson.getDelegateAdapter(this, type), UserVO.class);
		}
		if (LabelVO.class == rawType) {
			return (TypeAdapter<T>) new ObjectTypeAdapter((TypeAdapter<LabelVO>) gson.getDelegateAdapter(this, type), LabelVO.class);
		}
		if (CommentsVO.class == rawType) {
			return (TypeAdapter<T>) new ObjectTypeAdapter((TypeAdapter<CommentsVO>) gson.getDelegateAdapter(this, type), CommentsVO.class);
		}
		if (PlantsVO.class == rawType) {
			return (TypeAdapter<T>) new ObjectTypeAdapter((TypeAdapter<PlantsVO>) gson.getDelegateAdapter(this, type), PlantsVO.class);
		}
		if (PlantCategoryVO.class == rawType) {
			return (TypeAdapter<T>) new ObjectTypeAdapter((TypeAdapter<PlantCategoryVO>) gson.getDelegateAdapter(this, type), PlantCategoryVO.class);
		}
		if (PlantsOrnamentalColorVO.class == rawType) {
			return (TypeAdapter<T>) new ObjectTypeAdapter((TypeAdapter<PlantsOrnamentalColorVO>) gson.getDelegateAdapter(this, type), PlantsOrnamentalColorVO.class);
		}
		if (PlantsOrnamentalPeriodVO.class == rawType) {
			return (TypeAdapter<T>) new ObjectTypeAdapter((TypeAdapter<PlantsOrnamentalPeriodVO>) gson.getDelegateAdapter(this, type), PlantsOrnamentalPeriodVO.class);
		}
		if (PlantMediaVO.class == rawType) {
			return (TypeAdapter<T>) new ObjectTypeAdapter((TypeAdapter<PlantMediaVO>) gson.getDelegateAdapter(this, type), PlantMediaVO.class);
		}
		return null;
	}
}