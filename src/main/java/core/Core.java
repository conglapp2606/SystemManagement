package core;

import org.opencv.core.Mat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Base64;

public class Core {
    public static void writeBuffer(Mat image, BufferedWriter writer) throws IOException {
        byte[] points = new byte[(int) (image.total() * image.channels())];
        image.get(0, 0, points);
        String imageInString = Base64.getEncoder().encodeToString(points);
        writer.write(image.rows() + "\r\n");
        writer.write(image.cols() + "\r\n");
        writer.write(image.type() + "\r\n");
        writer.write(imageInString);
        writer.newLine();
        writer.flush();
    }

    public static Mat readBuffer(BufferedReader reader) throws IOException {
        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());
        int types = Integer.parseInt(reader.readLine());
        byte[] points = Base64.getDecoder().decode(reader.readLine());
        Mat image = new Mat(rows, cols, types);
        image.put(0,0, points);
        return image;
    }
}
