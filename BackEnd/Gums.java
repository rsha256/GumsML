import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.sun.prism.Image;


public class Gums {
	private static java.awt.Image image;
	
	public static void main(String[] args) {
		ImageIcon I2 = new ImageIcon("RedCar.png");
		image = I2.getImage();
		try {
			File url = new File("Gum_Disease.jpg");
			BufferedImage img = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
