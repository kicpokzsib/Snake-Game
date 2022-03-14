import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class info {
    Button close;
    public info(){
        Pane sp2 = new Pane();
        Scene secondScene = new Scene(sp2, 500, 600);
        Stage info = new Stage();
        info.setTitle("Info");
        info.setScene(secondScene);
        info.show();
        info.setResizable(false);
        sp2.setStyle("-fx-background-image: url('./Info.jpg')");
        ///////
        close = new Button("");
        sp2.getChildren().add(close);
        //////
        close.setPrefSize(80,40);
        close.setLayoutY(532);
        close.setLayoutX(54);
        close.setStyle("-fx-background-color: transparent;");
        //////
        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                info.close();
            }
        });
    }

}
