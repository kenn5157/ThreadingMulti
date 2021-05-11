package MyThreading.logic;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class View {


    private static AnchorPane primaryAnchor;
    private static Stage primaryStage;
    private static Scene primaryScene;
    private static Window primaryWindow;

    public View() {

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        View.primaryStage = primaryStage;
    }

    public Scene getPrimaryScene() {
        return primaryScene;
    }

    public void setPrimaryScene(Scene primaryScene) {
        View.primaryScene = primaryScene;
    }

    public Window getPrimaryWindow() {
        return primaryWindow;
    }

    public void setPrimaryWindow(Window primaryWindow) {
        View.primaryWindow = primaryWindow;
    }

    public AnchorPane getPrimaryAnchor() {
        return primaryAnchor;
    }

    public void setPrimaryAnchor(AnchorPane primaryAnchor) {
        View.primaryAnchor = primaryAnchor;
    }
}
