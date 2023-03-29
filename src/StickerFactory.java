import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StickerFactory {
    static void createSticker() throws IOException {
        // 1. read image
        var oldImage = ImageIO.read(new File("public/test.jpg"));

        // 2. create new image
        var width = oldImage.getWidth();
        var height = oldImage.getHeight();
        // we want a new image with a bigger height to insert a message on bottom
        var newImageHeight = height + 200;
        // this line below will create a new image with width, height and a type
        // (translucent)
        var newImage = new BufferedImage(width, newImageHeight, BufferedImage.TRANSLUCENT);

        // 3. copy old image to new image
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage((Image) oldImage, 0, 0, null);

        // TODO: write message on image

        // 5. write new image on a file
        ImageIO.write(newImage, "png", new File("public/sticker.png"));
    }

    public static void main(String[] args) {
        try {
            StickerFactory.createSticker();
        } catch (IOException e) {
            System.out.printf("Houve um erro: %s", e);
        }
    }
}
