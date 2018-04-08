/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  public static void testKeepOnlyBlue(){
	  Picture beach = new Picture("wall.jpg");
	  beach.explore();
	  beach.keepOnlyBlue();
	  beach.explore();
  }
  
  public static void testNegate(){
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.negate();
	  beach.explore();
  }
  
  public static void testGrayscale(){
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.grayscale();
	  beach.explore();
  }
  
  public static void testfixUnderwater(){
	  Picture beach = new Picture("water.jpg");
	  beach.explore();
	  beach.fixUnderwater();
	  beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  public static void testMirrorVerticalRightToLeft()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }
  
  public static void testMirrorHorizontal()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontal();
    caterpillar.explore();
  }
  
  public static void testMirrorHorizontalBotToTop()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontalBotToTop();
    caterpillar.explore();
  }
  
  public static void testMirrorDiagonal()
  {
    Picture caterpillar = new Picture("beach.jpg");
    caterpillar.explore();
    caterpillar.mirrorDiagonal();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  public static void testMirrorArms(){
	  Picture temple = new Picture("snowman.jpg");
	    temple.explore();
	    temple.mirrorArms();
	    temple.explore();
  }
  
  public static void testMirrorGull(){
	  Picture temple = new Picture("seagull.jpg");
	    temple.explore();
	    temple.mirrorGull();
	    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testChromakey(){
	  Picture lilly = new Picture("Lilly.jpg");
	  lilly.explore();
	  Picture monsters = new Picture("Monsters-University.jpg");
	  monsters.explore();
	  lilly.chromaKey();
	  lilly.explore();
  }
  
  public static void testEncodeAndDecode(){
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.steganography().explore();
  }
  
  public static void customCode() {
	  Picture ball = new Picture("Soccer-Ball.jpg");
	  ball.explore();
	  ball.glow();
	  ball.explore();
  }
  
  public static void resize(String inputImagePath,
          String outputImagePath, int scaledWidth, int scaledHeight)
          throws IOException {
      // reads input image
      File inputFile = new File(inputImagePath);
      BufferedImage inputImage = ImageIO.read(inputFile);

      // creates output image
      BufferedImage outputImage = new BufferedImage(scaledWidth,
              scaledHeight, inputImage.getType());

      // scales the input image to the output image
      Graphics2D g2d = outputImage.createGraphics();
      g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
      g2d.dispose();

      // extracts extension of output file
      String formatName = outputImagePath.substring(outputImagePath
              .lastIndexOf(".") + 1);

      // writes to output file
      ImageIO.write(outputImage, formatName, new File(outputImagePath));
  }

  
  public static void gums(){
	  //when green divided by blue divided by red between 0.05 and 0.07 exclusive
	  Picture healthy = new Picture("healthy_gums.jpg");
	  Picture disease = new Picture("Gum_Disease.jpg");
	  Picture gum = new Picture("healthy.jpg");
	  System.out.println(healthy.check());
	  healthy.explore();
//	  disease.explore();
//	  gum.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java 
 * @throws IOException */
  public static void main(String[] args) throws IOException
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
//    testZeroBlue();
//    testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
//    testNegate();
//    testGrayscale();
//    testfixUnderwater();
    //testMirrorVertical();
//	  testMirrorVerticalRightToLeft();
//	  testMirrorHorizontal();
//	  testMirrorHorizontalBotToTop();
//	  testMirrorDiagonal();
//    testMirrorTemple();
//    testMirrorArms();
//    testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
//    testChromakey();
//    testEncodeAndDecode();
//	  customCode();
	  gums();
//    testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}