import java.util.Scanner;
/*
 * Steven Zhang and Chris Song
 * Game of Life
 * GOLController Class
 */
public class GOLController implements GOLControllerInterface{
    //members
    private GOLModelInterface model;
    private GOLViewInterface view;

    //constructors
    public GOLController() {

    }

    public GOLController(GOLModelInterface model, GOLViewInterface view) {
        this.model = model;
        this.view = view;
    }

    //setters for the model and view
    /* method from GOLControllerInterface */
    public void setModel(GOLModelInterface model) {
        this.model = model;
    }

    /* method from GOLControllerInterface */
    public void setView(GOLViewInterface view) {
        this.view = view;
    }

    /* method from GOLControllerInterface */
    /**
     * startGame() starts the process for the game.
     * Asks user for input for generation, sleep time, and choosing the pattern.
     * Contains the game loop to display the generations and patterns.
     */
    public void startGame() {
        Scanner user = new Scanner(System.in);

        System.out.print("Enter in the number of rows: ");
        int rows = user.nextInt();
        System.out.print("Enter in the number of columns: ");
        int columns = user.nextInt();

        //create instances for model and view
        GOLModelInterface model = new GOLModel(rows, columns);
        GOLViewInterface view = new GOLView(new GOLController(model, null));

        //set the model and view in the controller
        setModel(model);
        setView(view);

        System.out.print("Enter in the number of generations: ");
        int numGen = user.nextInt();
        System.out.print("Enter the length of sleep time (milliseconds): ");
        int sleepTime = user.nextInt();

        System.out.println("Which Pattern would you like to use?");
        System.out.println("1 - Glider");
        System.out.println("2 - Exploder");
        System.out.println("3 - Spaceship");
        System.out.println("4 - Tumbler");
        System.out.println("5 - GliderGun");
        System.out.println("6 - 10CellRow");
        System.out.println();
        System.out.println("*** Please enter your choice (1-6) ***");

        int patternOption = user.nextInt();

        StringBuilder fileName = new StringBuilder();

        switch (patternOption) {
            case 1: //Glider pattern
                fileName.append("Glider.pat");
                break;

            case 2: //Exploder pattern
                fileName.append("Exploder.pat");
                break;

            case 3: //Spaceship pattern
                fileName.append("Spaceship.pat");
                break;

            case 4: //Tumbler pattern
                fileName.append("Tumbler.pat");
                break;

            case 5: //GliderGun pattern
                fileName.append("GliderGun.pat");
                break;

            case 6: //10CellRow pattern
                fileName.append("10CellRow.pat");
                break;

            default:
                System.out.println("\n*** Choose an input from 1-4 ***\n");
                break;
        }

        //passes the file name to the model to start reading the file.
        System.out.println(fileName);
        model.loadPatternFile(fileName.toString());

        //start the grid loop
        for(int i = 1; i <= numGen; i++) {
            view.displayGame(i);
            model.nextGeneration();

            //implement the Thread sleep function between generations
            try {
                Thread.sleep(sleepTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* method from GOLControllerInterface */
    public GOLModelInterface getModel() {
        return model;
    }
}
