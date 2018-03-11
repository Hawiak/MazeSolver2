import java.io.IOException;
import java.util.*;


public class Maze {

    Image image;

    public Maze() {
        this.image = new Image();
    }

    public int[][] readImage() {
        byte[] imageBytemap = new byte[0];

        try {
            imageBytemap = this.image.extractBytes("tiny.png");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        int imageHeight = this.image.bufferedImage.getHeight();
        int imageWidth = this.image.bufferedImage.getWidth();


        int[][] mazeArr = new int[imageWidth][imageHeight];

        for (int y = 0; y < imageWidth; y++) {
            mazeArr[y] = new int[imageHeight];
            for (int x = 0; x < imageWidth; x++) {
                int black = 0;
                final int clr = this.image.bufferedImage.getRGB(x, y);
                if (clr == -16777216) {
                    black = 1;
                } else if (clr == -1){
                }

                mazeArr[y][x] = black;
            }
        }

        return mazeArr;
    }

    public ArrayList<Node> buildNodes(int[][] imgMap)
    {
        ArrayList<Node> nodes = new ArrayList<>();

        for (int startColumn = 0; startColumn < imgMap[0].length; startColumn ++) {
            if (imgMap[0][startColumn] == 0) {
                nodes.add(new Node(0, startColumn));
            }
        }

        int lastRow = (imgMap.length - 1);

        for (int row = 1; (row < imgMap.length - 1); row++) {

            for (int column = 1; column < (imgMap[row].length - 1); column++) {

                boolean isBlack = imgMap[row][column] > 0;

                int leftPixel = imgMap[row][column - 1];
                int rightPixel = imgMap[row][column + 1];
                int topPixel = imgMap[row - 1][column];
                int bottomPixel = imgMap[row + 1][column];

                // Black pixel? -> do nothing
                if (isBlack) {
                    continue;
                }

                if ((leftPixel == 0 || rightPixel == 0) && (bottomPixel == 0 || topPixel == 0)) {
                    nodes.add(new Node(row, column));
                    continue;
                }

                // This very smart, genius method is thought of by Judith Kaptein.
                int p = leftPixel + rightPixel + bottomPixel + topPixel;
                if (p == 3) {
                    nodes.add(new Node(row, column));
                }
            }
        }

        for (int startColumn = 0; startColumn < imgMap[lastRow].length; startColumn ++) {
            if (imgMap[lastRow][startColumn] == 0) {
                nodes.add(new Node(lastRow, startColumn));
            }
        }

        return nodes;
    }

    public void createGraph(Node n, int[][] imgMap) {
        for (int row = 1; (row < imgMap.length - 1); row++) {

            for (int column = 1; column < (imgMap[row].length - 1); column++) {

                // Check for nodes at position

                // Node n =

            }

        }
    }

    public Node checkForNodeAtPosition(ArrayList<Node> nodes, int row, int column) {
        for (Node n : nodes) {
            if (n.row == row && n.column == column)  {
                return n;
            }
        }

        return null;
    }
}
