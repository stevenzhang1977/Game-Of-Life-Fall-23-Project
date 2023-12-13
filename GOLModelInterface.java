public interface GOLModelInterface {
        int getRows();
        int getColumns();
        void nextGeneration();
        int liveNeighbors(int row, int column);
        void loadPatternFile(String fileName);
        boolean[][] getGrid();

}
