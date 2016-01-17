/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mateimagefilters;

import com.jhlabs.image.ImageUtils;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author Kashyap
 */
public class MateImageFilters {

    /**
     * @param args the command line arguments
     */
    
    private static int filterCode;
    private static BufferedImage image, filteredImage;
    private static String imageFileName;
    private static File imageFile;
    private static Scanner sc;
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        sc = new Scanner(System.in);
        System.out.println("Enter Image file name::");
        imageFileName = sc.nextLine();
        System.out.println("Enter Filter code::");
        filterCode = Integer.parseInt(sc.next());
        
        imageFile = new File("E:\\" + imageFileName + ".jpg");
        
        image = ImageIO.read(imageFile);
        //image = ImageUtils.convertImageToARGB(image);
        
        applyFilter(filterCode);
       
    }
    
    public static void applyFilter(int filterCode) throws IOException{
    
        switch(filterCode){
            
            case Constants.GrayscaleFilterCode:
                Filters.greyScaleFilter(image);
                break;
                
            case Constants.BlurFilterCode:
                Filters.blurFilter(image);
                break;
                
            case Constants.BoxBlurFilterCode:
                System.out.println("Enter values for HRadius (0 to 100), VRadius (0 to 100) and Iterations (0 to 10)");
                int hRadius = Integer.parseInt(sc.next());
                int vRadius = Integer.parseInt(sc.next());
                int iterations = Integer.parseInt(sc.next());
                Filters.boxBlurFilter(image, hRadius, vRadius, iterations);
                break;
                
            case Constants.MaskFilterCode:
                Filters.applyMaskFilter(image);
                break;
                
            case Constants.AverageFilterCode:
                Filters.averageFilter(image);
                break;
                
            case Constants.BlockFilteredImage:
                System.out.println("Enter the Block Size::");
                int blockSize = Integer.parseInt(sc.next());
                Filters.blockFilter(image, blockSize);
                break;
                
            case Constants.ChromeFilterCode:
                System.out.println("Enter the values for Amount (0 to 100) and Exposure (0 to 5)::");
                float amount = Float.parseFloat(sc.next());
                float exposure = Float.parseFloat(sc.next());
                Filters.chromeFilter(image, amount, exposure);
                break;
        }
    }
    
}
