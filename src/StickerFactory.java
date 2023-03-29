import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class StickerFactory {
    static void createSticker(String URL, String outFile, String message, String font, int style, int size, Color color)
            throws IOException {
        InputStream url = new URL(URL).openStream();
        // 1. read image
        var oldImage = ImageIO.read(url);

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
        graphics.setFont(new Font(font, style, size));
        graphics.setColor(color);

        // TODO: centralize the x position
        var positionX = width / 12; // where the message will be written
        var positionY = newImageHeight - 300;
        graphics.drawString(message, positionX,
                positionY);
        // 5. write new image on a file
        ImageIO.write(newImage, "png", new File(outFile));
    }

}
