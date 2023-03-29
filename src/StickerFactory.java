import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StickerFactory {
    static void createSticker(String originalFile, String outFile, String message) throws IOException {
        // 1. read image
        var oldImage = ImageIO.read(new File(originalFile));

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

        // 4. write message on image
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 32));
        graphics.setColor(Color.PINK);

        var positionX = width / 12; // where the message will be written
        System.out.println(width);
        System.out.println(positionX);
        graphics.drawString(message, positionX,
                newImageHeight - 100);
        // 5. write new image on a file
        ImageIO.write(newImage, "png", new File(outFile));
    }

    public static void main(String[] args) {
        try {
            StickerFactory.createSticker("public/test.jpg", "public/sticker.png", "let the light in");
        } catch (IOException e) {
            System.out.printf("Houve um erro: %s", e);
        }
    }
}
