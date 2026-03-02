package ImageApp;

/*
  ImageApp: 
 */
import java.awt.Color;

public class ImageApp {
  public static void main(String[] args) {

    // use any file from the lib folder
    String pictureFile = "Unit 3/3.3/ImageApp/lib/beach.jpg";

    // Get an image, get 2d array of pixels, show a color of a pixel, and display
    // the image
    Picture origImg = new Picture(pictureFile);
    Pixel[][] origPixels = origImg.getPixels2D();
    System.out.println(origPixels[0][0].getColor());
    origImg.explore();

    // Image #1 Using the original image and pixels, recolor an image by changing
    // the RGB color of each Pixel
    Picture recoloredImg = new Picture(pictureFile);
    Pixel[][] recoloredPixels = recoloredImg.getPixels2D();

    /* to be implemented */
    for (int i = 0; i < recoloredPixels.length; i++) {
      for (int j = 0; j < recoloredPixels[i].length; j++) {
        Pixel p = recoloredPixels[i][j];
        int r = p.getRed();
        int g = p.getGreen();
        int b = p.getBlue();
        Color c = new Color(b, r, g);
        p.setColor(c);
      }
    }

    recoloredImg.explore();

    // Image #2 Using the original image and pixels, create a photographic negative
    // of the image
    Picture negImg = new Picture(pictureFile);
    Pixel[][] negPixels = negImg.getPixels2D();

    /* to be implemented */
    for (int i = 0; i < negPixels.length; i++) {
      for (int j = 0; j < negPixels[i].length; j++) {
        Pixel p = negPixels[i][j];
        int r = p.getRed();
        int g = p.getGreen();
        int b = p.getBlue();
        Color c = new Color(255 - r, 255 - g, 255 - b);
        p.setColor(c);
      }
    }

    negImg.explore();

    // Image #3 Using the original image and pixels, create a grayscale version of
    // the image
    Picture grayscaleImg = new Picture(pictureFile);
    Pixel[][] grayscalePixels = grayscaleImg.getPixels2D();

    /* to be implemented */
    for (int i = 0; i < grayscalePixels.length; i++) {
      for (int j = 0; j < grayscalePixels[i].length; j++) {
        Pixel p = grayscalePixels[i][j];
        int r = p.getRed();
        int g = p.getGreen();
        int b = p.getBlue();
        int a = (int) ((r + g + b) / 3.0);
        Color c = new Color(a, a, a);
        p.setColor(c);
      }
    }

    grayscaleImg.explore();

    // Image #4 Using the original image and pixels, rotate it 180 degrees
    Picture upsidedownImage = new Picture(pictureFile);
    Pixel[][] upsideDownPixels = upsidedownImage.getPixels2D();

    /* to be implemented */
    for (int i = 0; i < upsideDownPixels.length; i++) {
      for (int j = 0; j < upsideDownPixels[i].length; j++) {
        Pixel p = upsideDownPixels[i][j];
        Pixel p2 = origPixels[upsideDownPixels.length - i - 1][upsideDownPixels[i].length - j - 1];
        p.setColor(p2.getColor());
      }
    }

    upsidedownImage.explore();

    // Image #5 Using the original image and pixels, rotate image 90
    Picture rotateImg = new Picture(pictureFile);
    Pixel[][] rotatePixels = rotateImg.getPixels2D();

    /* to be implemented */
    for (int i = 0; i < rotatePixels.length; i++) {
      for (int j = 0; j < rotatePixels[i].length; j++) {
        Pixel p = rotatePixels[i][j];
        if (origPixels.length - j - 1 < rotatePixels.length && origPixels.length - j - 1 > 0
            && i < rotatePixels[i].length) {
          Pixel p2 = origPixels[origPixels.length - j - 1][i];
          p.setColor(p2.getColor());
        } else {
          p.setColor(new Color(255, 255, 255));
        }
      }
    }

    rotateImg.explore();

    // Image #6 Using the original image and pixels, rotate image -90
    Picture rotateImg2 = new Picture(pictureFile);
    Pixel[][] rotatePixels2 = rotateImg2.getPixels2D();

    /* to be implemented */
    for (int i = 0; i < rotatePixels2.length; i++) {
      for (int j = 0; j < rotatePixels2[i].length; j++) {
        Pixel p = rotatePixels2[i][j];
        if (j < rotatePixels.length && rotatePixels2[j].length - i - 1 < rotatePixels2[j].length
            && rotatePixels2[j].length - i - 1 > 0) {
          Pixel p2 = origPixels[j][rotatePixels2[j].length - i - 1];
          p.setColor(p2.getColor());
        } else {
          p.setColor(new Color(255, 255, 255));
        }
      }
    }

    rotateImg2.explore();

    // Final Image: Add a small image to a larger one

    // Repeat for each pixel in the smaller image
    // Set the color of the larger image's pixel to color of the smaller image's
    // pixel
    // Re-render the larger image at the end

    /* to be implemented */
    String pictureFile2 = "Unit 3/3.3/ImageApp/lib/bridge.jpg";
    String pictureFile3 = "Unit 3/3.3/ImageApp/lib2/frog.png";

    Picture largeImage = new Picture(pictureFile2);
    Pixel[][] largeImagePixels = largeImage.getPixels2D();
    Picture smallImage = new Picture(pictureFile3);
    Pixel[][] smallImagePixels = smallImage.getPixels2D();

    int startRow = 330;
    int startCol = 500;

    for (int i = 0; i < smallImagePixels.length; i++) {
      for (int j = 0; j < smallImagePixels[i].length; j++) {
        Pixel p = smallImagePixels[i][j];
        int r = p.getRed();
        int g = p.getGreen();
        int b = p.getBlue();

        if (!(r >= 240 && g >= 240 && b >= 240)) {
          try {
          Pixel p2 = largeImagePixels[i + startRow][j + startCol];

          p2.setColor(new Color(r, g, b));
          } catch (IndexOutOfBoundsException e) {

          }
        }
      }
    }

    largeImage.explore();

    // Add a 3rd image

    String pictureFile4 = "Unit 3/3.3/ImageApp/lib2/butterfly.png";
    Picture smallImage2 = new Picture(pictureFile4);
    Pixel[][] smallImagePixels2 = smallImage2.getPixels2D();

    int startRow2 = 50;
    int startCol2 = 50;

    for (int i = 0; i < smallImagePixels2.length; i++) {
      for (int j = 0; j < smallImagePixels2[i].length; j++) {
        Pixel p = smallImagePixels2[i][j];
        int r = p.getRed();
        int g = p.getGreen();
        int b = p.getBlue();

        if (!(r >= 240 && g >= 240 && b >= 240)) {
          try {
          Pixel p2 = largeImagePixels[i + startRow2][j + startCol2];

          p2.setColor(new Color(r, g, b));
          } catch (IndexOutOfBoundsException e) {

          }
        }
      }
    }

    largeImage.explore();

    // for testing 2D algorithms
    int[][] test1 = {
        { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 },
        { 13, 14, 15, 16 } };

    int[][] test2 = new int[4][4];

    for (int i = 0; i < test2.length; i++) {
      for (int j = 0; j < test2[i].length; j++) {
        int num = test2[i][j];
        int newNum = test1[test2.length - j - 1][i];
        test2[i][j] = newNum;
        System.out.print(newNum + "\t");
      }
      System.out.println();
    }

    int[][] test3 = new int[4][4];

    for (int i = 0; i < test3.length; i++) {
      for (int j = 0; j < test3[i].length; j++) {
        int num = test3[i][j];
        int newNum = test1[j][test3[j].length - i - 1];
        System.out.print(newNum + "\t");
      }
      System.out.println();
    }

  }
}