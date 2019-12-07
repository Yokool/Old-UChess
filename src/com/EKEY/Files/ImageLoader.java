package com.EKEY.Files;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class ImageLoader {
	
	
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
