import java.awt.image.BufferedImage;
import java.awt.Color;

public class ImageProcessor {

    public ImageTags extractTags(BufferedImage img) {
        return new ImageTags(
            detectDominantColor(img),
            detectShape(img),
            estimateSize(img)
        );
    }

    private String detectDominantColor(BufferedImage img) {
        long r = 0, g = 0, b = 0;
        int count = 0;

        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                Color c = new Color(img.getRGB(x, y));
                r += c.getRed();
                g += c.getGreen();
                b += c.getBlue();
                count++;
            }
        }

        r /= count; g /= count; b /= count;

        if (r < 50 && g < 50 && b < 50) return "Black";
        if (r > 200 && g > 200 && b > 200) return "White";
        if (r > g && r > b) return "Red";
        if (g > r && g > b) return "Green";
        if (b > r && b > g) return "Blue";

        return "Mixed";
    }

    private String detectShape(BufferedImage img) {
        // simplified shape estimation
        double ratio = (double) img.getWidth() / img.getHeight();
        if (ratio > 0.8 && ratio < 1.2) return "Square";
        return "Rectangle";
    }

    private String estimateSize(BufferedImage img) {
        int area = img.getWidth() * img.getHeight();
        
        if (area < 150000) return "Small";
        if (area < 500000) return "Medium";
        return "Large";
    }
}