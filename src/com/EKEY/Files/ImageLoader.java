package com.EKEY.Files;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * A helper class for getting images out of files.
 */
public abstract class ImageLoader {
	
	/**
	 * A method for loading a Image object from a File.
	 * @param file - The path to the file.
	 * @return - The image return, if the file can't be read, then null is returned.
	 */
	public static Image loadImage(File file) {
		
		BufferedImage bf;
		try {
			bf = ImageIO.read(file);
			Image Img = (Image) bf;
			return Img;
		} catch (IOException e) {
			System.err.println("Failed to read image from the path: " + file.getPath());
			e.printStackTrace();
			return null;
		}
		
	}
	
	
}
