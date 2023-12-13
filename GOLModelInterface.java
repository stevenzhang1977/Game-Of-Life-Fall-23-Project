/*
 * Steven Zhang and Chris Song
 * Game of Life
 * GOLModelInterface
 */
public interface GOLModelInterface {
        int getRows();
        int getColumns();
        void nextGeneration();
        int liveNeighbors(int row, int column);
        void loadPatternFile(String fileName);
        boolean[][] getCell();

}
