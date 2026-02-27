public class ImageModifierFRQ {
    public static final int BLACK = 0;
    public static final int WHITE = 255;

    private int[][] pixelValues = {{221,184,178,84,135}, {84, 255, 255, 130, 84}, {78, 255, 0, 0, 78}, {84, 130, 255, 130, 84}};

    public static void main(String[] args) {
        ImageModifierFRQ obj = new ImageModifierFRQ();

        obj.printArray();
        System.out.println(obj.countWhitePixels());
        obj.processImage();
        obj.printArray();
    }

    public int countWhitePixels() {
        int count = 0;
        for (int[] i : pixelValues) {
            for (int j : i) {
                if (j == WHITE) {
                    count++;
                }
            }
        }
        return count;
    }

    public void processImage() {
        for (int i = 0; i < pixelValues.length; i++) {
            for (int j = 0; j < pixelValues[0].length; j++) {
                if (i + 2 < pixelValues.length && j + 2 < pixelValues[0].length) {
                    int subtract = pixelValues[i][j] - pixelValues[i + 2][j + 2];
                    if (subtract < BLACK) subtract = BLACK;
                    pixelValues[i][j] = subtract;
                }
            }
        }
    }

    public void printArray() {
        for (int[] i : pixelValues) {
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }
    }
}