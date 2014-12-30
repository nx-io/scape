package me.scape.ti.image;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2014年12月31日 上午12:44:27
 */
public class ImageUtils {

	public static ImageProperties readImage(File image) throws IOException {
		Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("jpg");
		ImageReader reader = readers.next();
		ImageInputStream input = ImageIO.createImageInputStream(image);
		reader.setInput(input, true);
		int width = reader.getWidth(0);
		int height = reader.getHeight(0);
		return new ImageProperties(width, height);
	}

	public static ImageProperties readImage(InputStream in) throws IOException {
		Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("jpg");
		ImageReader reader = readers.next();
		ImageInputStream input = ImageIO.createImageInputStream(in);
		reader.setInput(input, true);
		int width = reader.getWidth(0);
		int height = reader.getHeight(0);
		return new ImageProperties(width, height);
	}
}