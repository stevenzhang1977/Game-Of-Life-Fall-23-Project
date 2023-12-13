import java.io.*;
/*
 * Steven Zhang and Chris Song
 * Game of Life
 * GOLModel class
 */
public class GOLModel implements GOLModelInterface {
    //members
    private int rows;
    private int columns;
    private boolean[][] cell;

    //constructor
    public GOLModel(int row, int column) {
        this.rows = row;
        this.columns = column;
        this.cell = new boolean[row][column];
    }

    /* method from GOLModelInterface */
    public int getRows() {
        return rows;
    }

    /* method from GOLModelInterface */
    public int getColumns() {
        return columns;
    }

    /* method from GOLModelInterface */
    /**
     * Creates reader objects to read the selected .pat file.
     * Uses a try-catch block to throw exceptions from reading.
     * The boolean cell is "true" or "alive" if the character is a '*'
     */
    public void loadPatternFile(String fileName) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(new File(fileName)));

            String line;
            int row = 0;
            while((line = input.readLine()) != null && row < getRows()) {
                for(int col = 0; col < Math.min(getColumns(), line.length()); col++) {
                    cell[row][col] = (line.charAt(col) == '*');
                }
                row++;
                System.out.println(line);

            }
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* method from GOLModelInterface */
    /**
     * determines if the current cell is alive or dead
     * for alive cells, apply conditional statements for Survival and Overcrowded/Loneliness Rules
     * for dead cells, apply conditional statements for Birth and Overcrowded/Loneliness Rules
     */
    public void nextGeneration() {
        boolean[][] nextGen = new boolean[rows][columns];

        for (int cellRow = 0; cellRow < rows; cellRow++) {
            for (int cellColumn = 0; cellColumn < columns; cellColumn++) {
                int liveNeighbors = liveNeighbors(cellRow, cellColumn);

                /**
                 *  true if the cell is alive
                 *  false if the cell is dead
                 */
                if (cell[cellRow][cellColumn]) {
                    if (liveNeighbors == 2 || liveNeighbors == 3) {
                        //Survival Rule
                        nextGen[cellRow][cellColumn] = true;
                    } else {
                        //Overcrowding/Loneliness rule
                        nextGen[cellRow][cellColumn] = false;
                    }
                } else {
                    if (liveNeighbors == 3) {
                        //Birth Rule
                        nextGen[cellRow][cellColumn] = true;
                    } else {
                        //Overcrowding/Loneliness rule
                        nextGen[cellRow][cellColumn] = false;
                    }
                }
            }
        }
        cell = nextGen;
    }

    /* method from GOLModelInterface */
    /**
     * Method to count how many live neighbors there are in respect to a live cell.
     */
    public int liveNeighbors(int row, int column) {
        int liveNeighbors = 0;

        //nested for-loops to iterate over a live cell's 3x3 neighborhood.
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                /**
                 * if-statements check if the cell is within the grid bounds
                 * and the cell being checked is not the live cell in the center
                 * of the 3x3 neighborhood.
                 */
                if (i >= 0 && i < rows && j >= 0 && j < columns && !(i == row && j == column)) {
                    if (cell[i][j]) {
                        liveNeighbors++;
                    }
                }
            }
        }
        return liveNeighbors;
    }

    /* method from GOLModelInterface */
    public boolean[][] getCell() {
        return cell;
    }
}
