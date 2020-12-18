import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GridReader {
    private final BufferedReader bufferedReader;

    public GridReader(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        this.bufferedReader = new BufferedReader(fileReader);
    }

    public byte[][] readFile() throws IOException {
        String tempString;
        String[] rowsAndCols = bufferedReader.readLine().split(" ");
        int noOfRows = Integer.parseInt(rowsAndCols[0]), noOfCols = Integer.parseInt(rowsAndCols[1]);
        byte[][] grid = new byte[noOfRows][noOfCols];
        int counter = 0;
        while ((tempString = bufferedReader.readLine()) != null) {
            byte[] cols = new byte[noOfCols];
            if (tempString.length() > 0) {
                String[] rowString = tempString.split(",");
                for (int i = 0; i < rowString.length; ++i) {
                    cols[i] = Byte.parseByte(rowString[i].trim());
                }
            }
            grid[counter] = cols;
            counter++;
        }
        bufferedReader.close();
        return grid;
    }
}
