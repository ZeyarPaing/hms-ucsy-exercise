import java.io.IOException;

public class GameOfLife {
    private final byte ALIVE = 1, DEAD = 0;

    private static byte[][] grid = {
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 1, 0}
    };

    public byte[][] getGrid() {
        return grid;
    }

    public void setGrid(byte[][] newGrid) {
        grid = newGrid;
    }

    public byte checkAliveNeighbour(byte rowIdx, byte colIdx) {
        byte aliveNeighbours = 0;
        //System.out.println("Checking neighbour" + rowIdx + "," + colIdx);
        for (byte row = -1; row <= 1; ++row) {
            for (byte col = -1; col <= 1; ++col) {
                try {
                    if (!(row == 0 && col == 0)) {
                        aliveNeighbours += grid[rowIdx + col][colIdx + row];
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    // System.out.println("Exception" + e);
                }
            }
        }
        //System.out.println(aliveNeighbours);
        return aliveNeighbours;
    }

    public byte[][] newLife() {
        byte[][] newGrid = new byte[grid.length][grid[0].length];
        for (byte i = 0; i < grid.length; ++i) {
            for (byte j = 0; j < grid[i].length; ++j) {
                //System.out.print(grid[i][j] + " ");
                //System.out.println("Neighbours alive at" + i + ", " + j);
                byte aliveNeighbours = this.checkAliveNeighbour(i, j);
                boolean deathCriteria = aliveNeighbours < 2 || aliveNeighbours > 3;
                if (grid[i][j] == ALIVE && deathCriteria) {
                    newGrid[i][j] = DEAD;
                } else if (grid[i][j] == DEAD && aliveNeighbours == 3) {
                    newGrid[i][j] = ALIVE;
                } else {
                    newGrid[i][j] = grid[i][j];
                }
            }
        }
        return newGrid;
    }

    public void printGrid(byte[][] grid) {
        char ALIVEIND = '\u25A0', DEADIND = '.';
        /**
         *  \u25A0 is square block character
         **/
        for (byte[] bytes : grid) {
            for (byte aByte : bytes) {
                System.out.print((aByte == ALIVE ? ALIVEIND : DEADIND) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        GameOfLife gol = new GameOfLife();

        GridReader gridReader = new GridReader("C:\\Users\\zeyar\\Projects\\java-hms\\grid2.txt");
        gol.setGrid(gridReader.readFile());

        byte[][] currentGrid = gol.getGrid();
        System.out.println("Original Grid");
        gol.printGrid(currentGrid);

        for (int i = 0; i < 17; i++) {
            System.out.println("--------------------------");
            byte[][] newLifeGrid = gol.newLife();
            //System.out.println("Generation " + (i+1) + " :");
            gol.printGrid(newLifeGrid);
            gol.setGrid(newLifeGrid);
        }

    }
}
