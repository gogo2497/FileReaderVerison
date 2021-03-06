package Classes;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * This class opens an existing image
 * @author Georgi
 * @version 1.1
 */
public class Image {

    private int width;
    private int height;
    private String image;

    /**
    * Creates a new image
    * @param width The width of the image
    * @param height The height of the image
    * @param image The image to be opened
    */
    public Image(int width, int height, String image) {
        this.width = width;
        this.height = height;
        this.image = image;
    }
    
    /**
    * Open an image file or print an error
    */
    public void openImage() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(image));
        } catch (IOException e) {
            System.out.println("Cannot open: " + image);
        }
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the imagePath
     */
    public String getImagePath() {
        return image;
    }

    /**
     * @param imagePath the imagePath to set
     */
    public void setImagePath(String image) {
        this.image = image;
    }
    
    /**
    * Converts an image into a string
    */
    @Override
    public String toString(){
        return toString() + "Width: " + this.getWidth() + "\n" + "Height: " +
                this.getHeight() + "\n" +  "Classes.Image: " + this.getImagePath();
    }
}
