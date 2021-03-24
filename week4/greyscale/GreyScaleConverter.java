package greyscale;
import edu.duke.*;

import java.io.*;

public class GreyScaleConverter {
    public ImageResource makeGrey(ImageResource input)
    {
        ImageResource outImage=new ImageResource(input.getWidth(), input.getHeight());
        for(Pixel pixel : outImage.pixels())
        {
            Pixel inPixel=input.getPixel(pixel.getX(), pixel.getY());
            int average=(inPixel.getRed()+inPixel.getGreen()+inPixel.getBlue())/3;
            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }
        return outImage;
    }

    public ImageResource invertImage(ImageResource input)
    {
        ImageResource outImage=new ImageResource(input.getWidth(), input.getHeight());
        for(Pixel pixel : outImage.pixels())
        {
            Pixel inPixel=input.getPixel(pixel.getX(), pixel.getY());
            pixel.setRed(255-inPixel.getRed());
            pixel.setGreen(255-inPixel.getGreen());
            pixel.setBlue(255-inPixel.getBlue());
        }
        return outImage;

    }

    public void makeMultipleImagesGray()
    {
        DirectoryResource dir=new DirectoryResource();
        Iterable<File> images=dir.selectedFiles();
        for(File image :images)
        {
            ImageResource input=new ImageResource(image);
            ImageResource grayImage=makeGrey(input);
            grayImage.setFileName("gray-"+input.getFileName());
            grayImage.save();
        }
    }

    public void makeMultipleImagesInverted()
    {
        DirectoryResource dir=new DirectoryResource();
        Iterable<File> images=dir.selectedFiles();
        for(File image :images)
        {
            ImageResource input=new ImageResource(image);
            ImageResource grayImage=invertImage(input);
            grayImage.setFileName("inverted-"+input.getFileName());
            grayImage.save();
        }
    }
    public void testGrey()
    {
        ImageResource input=new ImageResource();
        ImageResource gray=makeGrey(input);
        gray.draw();
    }

}
