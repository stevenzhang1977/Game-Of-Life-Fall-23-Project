public interface GOLControllerInterface {
    void startGame();
    GOLModelInterface getModel();
    void setModel(GOLModelInterface model);
    void setView(GOLViewInterface view);
}
