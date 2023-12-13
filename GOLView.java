/*
 * Steven Zhang and Chris Song
 * Game of Life
 * GOLView Class
 */
public class GOLView implements GOLViewInterface {
    //members
    private boolean[][] pattern;
    private GOLControllerInterface controller = null;

    //constructor
    public GOLView(GOLControllerInterface controller) {
        this.controller = controller;
    }

    /* method from GOLViewInterface */
    public void displayGame(int numGen) {

        //Print the current generation
        System.out.println("---------------------------------------------");
        System.out.println("Generation: " + numGen);
        printGrid(pattern);
        System.out.println("---------------------------------------------");
        System.out.println();

    }

    /* method from GOLViewInterface */
    /**
     * Uses the controller variable of the controller interface type to access the model.
     * Uses if-statement to determine what to print depending on the cell state.
     */
    public void printGrid(boolean[][] grid) {
        grid = controller.getModel().getCell();
        for (int row = 0; row < controller.getModel().getRows(); row++) {
            for (int column = 0; column < controller.getModel().getColumns(); column++) {

                //grid[row][column] is true if the cell is alive
                if(grid[row][column]) {
                    System.out.print("▮"); //print '*' if the cell is alive
                } else {
                    System.out.print("▯"); //print '.' if the cell is dead.
                }
            }
            System.out.println();
        }
    }
}