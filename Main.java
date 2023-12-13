/*
 * Steven Zhang and Chris Song
 * Game of Life
 * Main Class
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("                                  Game Of Life");
        System.out.println("                          --------------------------");
        System.out.println("                               Rules of the Game:");
        System.out.println("1. Birth: A dead cell with exactly three live neighbors becomes a live cell.");
        System.out.println("2. Survival: A live cell with two or three neighbors stays alive.");
        System.out.println("3. Overcrowding/Loneliness: In all other cases a cell dies or remains dead.");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("For best results, choose row and column dimensions that are:");
        System.out.println("Glider.pat: at least 10x10");
        System.out.println("Exploder.pat: at least 30x30");
        System.out.println("Spaceship.pat: at least 20x20");
        System.out.println("Tumbler.pat: at least 20x20");
        System.out.println("GliderGun.pat: at least 30x50");
        System.out.println("10CellRow.pat: at least 20x20");
        System.out.println("----------------------------------------------------------------------------------\n");

        //create an instance for controller
        GOLControllerInterface controller = new GOLController();

        //start the game
        controller.startGame();

    }
}