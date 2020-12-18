import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineCountApp {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\zeyar\\Projects\\java-hms\\fileread.txt";
        FileReader reader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(reader);

        FileLineCounterOOP flc = new FileLineCounterOOP(bufferedReader);
        flc.countLine();

        System.out.println("Total number of lines: " + flc.getTotalNumOfLines());
        System.out.println("Total number of lines excluding blank line: " + flc.getExcludeBlankLine());
        System.out.println("No. of lines excluding single line comment: " + flc.getExcludeSingleLinesCmt());
        System.out.println("No. of lines excluding multiline comment: " + flc.getExcludeMultiLineCmt());

        bufferedReader.close();
        reader.close();

    }
}
