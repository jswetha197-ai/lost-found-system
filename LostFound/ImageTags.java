
public class ImageTags {
    private String dominantColor;
    private String shapeCategory;
    private String sizeCategory;

    public ImageTags(String dominantColor, String shapeCategory, String sizeCategory) {
        this.dominantColor = dominantColor;
        this.shapeCategory = shapeCategory;
        this.sizeCategory = sizeCategory;
    }

    public String getDominantColor() {
        return dominantColor;
    }

    public String getShapeCategory() {
        return shapeCategory;
    }

    public String getSizeCategory() {
        return sizeCategory;
    }
}