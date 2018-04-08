import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void keepOnlyBlue(){
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setRed(0);
	        pixelObj.setGreen(0);
	      }
	    }
  }
  
  public void negate(){
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setRed(255- pixelObj.getRed());
	        pixelObj.setGreen(255 - pixelObj.getGreen());
	        pixelObj.setBlue(255 - pixelObj.getBlue());
	      }
	    }
  }
  
  public void grayscale(){
	  int d=0;
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	    	d=(int)(pixelObj.getAverage());
	    	pixelObj.setRed(d);
	        pixelObj.setGreen(d);
	        pixelObj.setBlue(d);
	      }
	    }
  }
  
  public void fixUnderwater(){
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setRed(pixelObj.getRed()+100);
//	        pixelObj.setGreen(130);
//	        pixelObj.setBlue(pixelObj.getBlue()-25);
	      }
	    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][width - 1 - col];
        rightPixel = pixels[row][col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontal(){
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel topPixel = null;
	    Pixel bottomPixel = null;
	    int width = pixels[0].length;
	    for (int col = 0; col < width; col++)
	    {
	      for (int row = 0; row < pixels.length/2; row++)
	      {
	        topPixel = pixels[pixels.length - 1 - row][col];
	        bottomPixel = pixels[row][col];
	        topPixel.setColor(bottomPixel.getColor());
	      }
	    } 
  }
  
  public void mirrorHorizontalBotToTop(){
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel topPixel = null;
	    Pixel bottomPixel = null;
	    int width = pixels[0].length;
	    for (int col = 0; col < width; col++)
	    {
	      for (int row = 0; row < pixels.length/2; row++)
	      {
	        topPixel = pixels[row][col];
	        bottomPixel = pixels[pixels.length - 1 - row][col];
	        topPixel.setColor(bottomPixel.getColor());
	      }
	    } 
  }
  
  public void mirrorDiagonal(){
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel topPixel = null;
	    Pixel bottomPixel = null;
	    int width;
	    if(pixels.length < pixels[0].length)
	    	width=pixels.length;
	    else
	    	width=pixels[0].length;
	    
	    for (int row = 0; row < width; row++)
	    {
	      for (int col = row; col < width; col++)
	      {
	        topPixel = pixels[row][col];
	        bottomPixel = pixels[col][row];
	        topPixel.setColor(bottomPixel.getColor());
	      }
	    } 
  }
  
  public void BottomFlip(){
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel topPixel = null;
	    Pixel bottomPixel = null;
	    int width = pixels[0].length;
	    for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; (col < width || col < row); col++)
	      {
	        topPixel = pixels[row][col];
	        bottomPixel = pixels[pixels.length - 1 - row][width - 1- col];
	        topPixel.setColor(bottomPixel.getColor());
	      }
	    } 
  }
  
  public void RightSideFlip(){
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel topPixel = null;
	    Pixel bottomPixel = null;
	    int width = pixels[0].length;
	    for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; (col < (width / 2) || col < row); col++)
	      {
	        topPixel = pixels[row][col];
	        bottomPixel = pixels[pixels.length - 1 - row][width - 1- col];
	        topPixel.setColor(bottomPixel.getColor());
	      }
	    } 
  }
  
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }
  
  public void mirrorArms(){
	  //highest pt: 159
	  //low: 190
	  //left: 106 col
	  //right: 292
	  //down by 20 
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel topPixel = null;
	    Pixel bottomPixel = null;
	    int width = pixels[0].length;
	    for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; col < width; col++)
	      {
	    	  if(row > 159 && row < 190 && col > 106 && col < 292 && (col < 170 || col > 236)){
	    		  topPixel = pixels[row][col];
	  	          bottomPixel = pixels[row+50][col];
	  	          bottomPixel.setColor(topPixel.getColor());
	    	  }
	      }
	    }
	  
  }
  
  public void mirrorGull(){
	  //highest pt: 236
	  //low: 323
	  //left: 238
	  //right: 343
	  //move col by 150
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel topPixel = null;
	    Pixel bottomPixel = null;
	    int width = pixels[0].length;
	    for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; col < width; col++)
	      {
	    	  if(row > 236 && row < 323 && col > 238 && col < 343 ){
	    		  topPixel = pixels[row][col];
	  	          bottomPixel = pixels[row-15][col-150];
	  	          bottomPixel.setColor(topPixel.getColor());
	    	  }
	      }
	    }
  }
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public void chromaKey(){
	  Pixel[][] pixels = this.getPixels2D();
	  Picture monsters = new Picture("Monsters-University.jpg");
	  Pixel[][] pixels2 = monsters.getPixels2D();
	  for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; col < pixels[0].length-1; col++)
	      {
	    	  if((pixels[row][col].getGreen()>140&&pixels[row][col].getBlue()<170&&pixels[row][col].getRed()<215)||(pixels[row][col].getGreen()<130&&pixels[row][col].getGreen()>73&&pixels[row][col].getBlue()<80&&pixels[row][col].getBlue()>45&&pixels[row][col].getRed()<75&&pixels[row][col].getRed()>50)){
	    		  pixels[row][col].setColor(pixels2[row][col].getColor());
	    	  }
	      }
	     }
  }
  
  public Picture steganography(){
	  Pixel[][] pixels = this.getPixels2D();
	  Picture message = new Picture("Message.jpg");
	  Pixel[][] pixels2 = message.getPixels2D();
	  
	  
	  for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; col < pixels[0].length-1; col++)
	      {
	    	  
	    	  
	    	  if(pixels[row][col].getRed()%2==0)
	    		  pixels[row][col].setRed(pixels[row][col].getRed()+1);
	    	  
	    	  
	      }
	     }
	  
	  for (int row = 0; row < pixels2.length; row++)
	    {
	      for (int col = 0; col < pixels2[0].length-1; col++)
	      {
	    	  if(pixels2[row][col].getRed()<100){
	    		  pixels[row][col].setRed(pixels[row][col].getRed()+1);
	    	  }
	    	  
	    	  
	      }
	    }
	  
	  this.explore();
	  
	  
	  for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; col < pixels[0].length-1; col++)
	      {
	    	  if(pixels[row][col].getRed()%2==0){
	    		  pixels[row][col].setRed(0);
	    		  pixels[row][col].setBlue(0);
	    		  pixels[row][col].setGreen(0);
	    	  }
	    	  else{
	    		  pixels[row][col].setRed(255);
	    		  pixels[row][col].setBlue(255);
	    		  pixels[row][col].setGreen(255);
	    	  }
	    	  
	    	  
	      }
	    }
	  
	  return this;
  }
  
  public void glow(){
	  Pixel[][] pixels = this.getPixels2D();
	  int color = 0;
	  
	  for (int row = 10; row < pixels.length-10; row++)
	    {
	      for (int col = 50; col < pixels[0].length-51; col++)
	      {
	    	  if(pixels[row][col-50].getGreen()>80&&pixels[row][col].getGreen()<11){
	    		  while(pixels[row][col-color].getGreen()<80||color==0)
	    			  color++;
	    		  
	    		  
	    		  
	    		  color=100-color;
	    		  color-=25;
	    		  
	    		  pixels[row][col].setGreen(pixels[row][col].getGreen()+color);
	    		  pixels[row][col].setBlue((pixels[row][col].getBlue()+color)/2);
	    		  pixels[row][col].setRed(pixels[row][col].getRed()+color);
	    	  }
	    	  
	    	  color=0;
	    	  
	    	  
	    	  if(pixels[row][col+50].getGreen()>11&&pixels[row][col].getGreen()<11){
	    		  while(pixels[row][col+color].getGreen()<11||color==0)
	    			  color++;
	    		  
	    		  color=100-color;
	    		  color-=25;
	    		  
	    		  pixels[row][col].setGreen(pixels[row][col].getGreen()+color);
	    		  pixels[row][col].setBlue((pixels[row][col].getBlue()+color)/2);
	    		  pixels[row][col].setRed(pixels[row][col].getRed()+color);
	    	  }
	    	  
	    	  color=0;
	    	  
	    	  
	      }
	    }
  }
  
  public boolean check() {
	  Pixel[][] pixels = this.getPixels2D();
	  int r = 0;
	  int count = 0;
	  double sumRatio = 0;
	  int start=(int)(pixels.length/5.5);
	  double green =0;
	  double red = 0;
	  double blue=0;
	  
	  label: for (int row = start; row < pixels.length; row++)
	    {
	      for (int col = 0; col < pixels[0].length; col++)
	      {
	    	  if(pixels[row][col].getRed()>=200&&pixels[row][col].getGreen()>=150) {
	    		  r =row-25;
	    		  break label;
	    	  }
	      }
	     }
	  
	  for(int col = 0; col < pixels[0].length; col++) {
		  green = pixels[r][col].getGreen();
		  blue = pixels[r][col].getBlue();
		  red = pixels[r][col].getRed();
		  
		  sumRatio+=(green/blue)/red;
		  count++;
	  }
	  sumRatio/=count;
	  if(sumRatio>0.005&&sumRatio<0.007)
		  return true;
	  else
		  return false;
  }
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

  
} // this } is the end of class Picture, put all new methods before this
