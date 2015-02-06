package me.scape.ti.criteria;

public class PlantQueryCriteria extends PaginationCriteria {

	private String name;

	private Integer cat_id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCat_id() {
		return cat_id;
	}

	public void setCat_id(Integer cat_id) {
		this.cat_id = cat_id;
	}

}
