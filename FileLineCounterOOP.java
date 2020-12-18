import java.io.BufferedReader;
import java.io.IOException;

public class FileLineCounterOOP {
    private int totalNumOfLines = 0, excludeSingleLinesCmt = 0, excludeMultiLineCmt = 0, excludeBlankLine = 0;
    private BufferedReader bufferReader;
    public FileLineCounterOOP(BufferedReader bufferedReader){
        this.bufferReader = bufferedReader;
    }
    public void countLine() throws IOException {
        int blankLines = 0, singleLineCmt = 0, multiLineCmt = 0;

        boolean isInsideMultiline = false;
        String tempString = this.bufferReader.readLine();
        System.out.println("Reading file ... \n++++++++++++++++++++++++++++++++++++++++++++++");

        while (tempString != null) {
            System.out.println(tempString);
            this.totalNumOfLines++;

            if (tempString.trim().startsWith("/*")){
                isInsideMultiline = true;
            }
            if (isInsideMultiline) multiLineCmt++;
            if (tempString.length() == 0) blankLines++;
            else if (tempString.trim().startsWith("//")) singleLineCmt++;
            else if (tempString.trim().startsWith("*/")
                    || tempString.trim().endsWith("*/")) {
                isInsideMultiline = false;
            }

            tempString = this.bufferReader.readLine();
        }
        this.excludeBlankLine = this.totalNumOfLines - blankLines;
        this.excludeMultiLineCmt = this.totalNumOfLines - multiLineCmt;
        this.excludeSingleLinesCmt = this.totalNumOfLines - singleLineCmt;
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
    }

    public int getTotalNumOfLines() {
            return totalNumOfLines;
    }

    public int getExcludeSingleLinesCmt() {
        return excludeSingleLinesCmt;
    }

    public int getExcludeMultiLineCmt() {
        return excludeMultiLineCmt;
    }

    public int getExcludeBlankLine() {
        return excludeBlankLine;
    }

}

