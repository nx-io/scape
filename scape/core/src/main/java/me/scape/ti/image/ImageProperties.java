package me.scape.ti.image;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月31日 上午12:47:25
 */
public class ImageProperties {

	private int width;
	private int height;

	public ImageProperties(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public ImageProperties() {
		super();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}