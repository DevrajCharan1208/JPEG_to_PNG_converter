import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ConverterTerminal {
    public static void main(String[] args) {
        try {
            // Takes input image from the present folder
            File inputFile = new File("input.jpeg");
            BufferedImage image = ImageIO.read(inputFile);

            if (image == null) {
                System.out.println("Could not read input.jpeg. Make sure the file exists.");
                return;
            }

            // Output image is generated in the folder
            File outputFile = new File("output.png");
            ImageIO.write(image, "png", outputFile);

            System.out.println("Image successfully converted to output.png");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}