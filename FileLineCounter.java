import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLineCounter {
    static int countLine(BufferedReader bufferReader, boolean incBlankLines, boolean incSingleLineComment, boolean incMultiLineComment) throws IOException {
        int numberOfLines = 0;
        boolean isInsideMultiline = false;
        String tempString = bufferReader.readLine();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");

        while (tempString != null) {
            System.out.println(tempString);

            if (!incMultiLineComment
                    && tempString.trim().startsWith("/*")) isInsideMultiline = true;

            if (!isInsideMultiline
                    && !(!incBlankLines && tempString.length() == 0)
                    && !(!incSingleLineComment
                    && tempString.trim().startsWith("//"))) numberOfLines++;

            if (!incMultiLineComment
                    && (tempString.trim().startsWith("*/")
                    || tempString.trim().endsWith("*/"))) isInsideMultiline = false;

            tempString = bufferReader.readLine();
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        return numberOfLines;
    }

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\zeyar\\Projects\\java-hms\\fileread.txt";
        FileReader reader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(reader);

        System.out.println("Number of lines in the file " + fileName + ": " + countLine(bufferedReader,
                                                                              false,
                                                                        true,
                                                                        false));

        bufferedReader.close();
        reader.close();

    }
}
