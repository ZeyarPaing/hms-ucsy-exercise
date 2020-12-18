import java.util.LinkedList;
import java.util.Scanner;

public class Rover {
    private int[] currentPosition;
    private char orientation;
    private int[] maxArea;
    private final LinkedList<Character> orientations = new LinkedList<>() {
        {
            add('N');
            add('E');
            add('S');
            add('W');
        }
    };

    public int[] getCurrentPosition() {
        return currentPosition;
    }

    public char getOrientation() {
        return orientation;
    }

    public void setCurrentPosition(int[] currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setMaxArea(int[] maxArea) {
        this.maxArea = maxArea;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    private void rotate(char command) {
        int rotated;
        int currentIndex = orientations.indexOf(orientation);
        rotated = command == 'L' ? currentIndex - 1 : currentIndex + 1;
        if (rotated < 0) {
            orientation = orientations.getLast();
        } else if (rotated >= orientations.size()) {
            orientation = orientations.getFirst();
        } else {
            orientation = orientations.get(rotated);
        }
    }

    public void executeInstruction(String instructions) {
        for (int i = 0; i < instructions.length(); ++i) {
            char currentChar = instructions.charAt(i);
            if (currentChar != 'M') {
                this.rotate(currentChar);
            } else {
                int[] prevPosition = new int[]{currentPosition[0], currentPosition[1]};
                switch (this.orientation) {
                    case 'N':
                        currentPosition[1]++;
                        break;
                    case 'E':
                        currentPosition[0]++;
                        break;
                    case 'S':
                        currentPosition[1]--;
                        break;
                    case 'W':
                        currentPosition[0]--;
                        break;
                    default:
                        System.out.println("invalid command");
                }
                boolean outOfArea = currentPosition[0] < 0 || currentPosition[1] < 0 || currentPosition[0] > maxArea[0] || currentPosition[1] > maxArea[1];
                if (outOfArea) {
                    System.out.println("invalid command : out of area at - " + currentChar);
                    currentPosition = prevPosition;
                }
             }
        }
    }

    public static void requestCommand(Scanner scanner, Rover rover) {
        String[] tempInput = scanner.nextLine().split(" ");
        rover.setCurrentPosition(new int[]{Integer.parseInt(tempInput[0]), Integer.parseInt(tempInput[1])});
        rover.setOrientation(tempInput[2].charAt(0));

        String commandString = scanner.nextLine();
        rover.executeInstruction(commandString);

        System.out.println(rover.getCurrentPosition()[0] + " " + rover.getCurrentPosition()[1] + " " + rover.getOrientation());
    }

    public static void main(String[] args) {
        Rover rover = new Rover();
        Scanner scanner = new Scanner(System.in);

        String[] tempInput = scanner.nextLine().split(" ");
        rover.setMaxArea(new int[]{Integer.parseInt(tempInput[0]), Integer.parseInt(tempInput[1])});

        while (true) {
            requestCommand(scanner, rover);
        }

    }
}
