import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Test {

    Image image;


    public static void main(String [] args) {

        System.out.println();

        Maze m = new Maze();

        int[][] imagemap = m.readImage();

        for(int a = 0; a < imagemap.length; a++) {
            String bit  = "";
            for(int b = 0; b < 10; b++) {
                bit += imagemap[a][b];
            }

            System.out.println(bit);
        }

        ArrayList<Node> list = m.buildNodes(imagemap);

        for(int a = 0; a < imagemap.length; a++) {
            String bit  = "";
            for(int b = 0; b < 10; b++) {
                // Check if A, B is in N
                String pixelRepresentation = "";

                for(Node n : list) {
                    if (n.row == a && n.column == b) {
                        pixelRepresentation = "x";
                    }
                }

                if (pixelRepresentation == "") {
                     pixelRepresentation = imagemap[a][b] > 0 ? "1" : "0";
                }
                bit += pixelRepresentation;
            }

            System.out.println(bit);
        }

        /*Graph g = new Graph();



        g.addEdge("A", "C", 7);
        g.addEdge("B", "D", 2);
        g.addEdge("C", "D", 1);
        g.addEdge("D", "F", 2);
        g.addEdge("B", "F", 5);
        g.addEdge("F", "E", 3);
        g.addEdge("A", "B", 3);



        String startNode = "A";
        String destNode = "E";

        g.dijkstra(startNode);

        g.printPath(destNode);*/

    }
}
