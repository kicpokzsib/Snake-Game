import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class Main extends Application {
    Button ng,hs,i,ex;
    public static void main(String[] args) {
    System.out.println("Hejka,tutaj wonsz");
    launch(args);


    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("SnakeTheGame");
        Pane sp = new Pane();
        primaryStage.setScene(new Scene(sp, 500, 600));
        primaryStage.show();
        primaryStage.setResizable(false);
        sp.setStyle("-fx-background-image: url('./MenuHIGH.jpg')");
        ////////batony
        ng=new Button("");
        hs=new Button("");
        i=new Button("");
        ex=new Button("");
        ///////pozycja
        sp.getChildren().add(ng);
        sp.getChildren().add(hs);
        sp.getChildren().add(i);
        sp.getChildren().add(ex);
        //
        ng.setStyle("-fx-background-color: transparent;");
        ng.setLayoutX(130);
        ng.setLayoutY(265);
        ng.setPrefSize(250,50);
        //
        hs.setStyle("-fx-background-color: transparent;");
        hs.setLayoutX(125);
        hs.setLayoutY(335);
        hs.setPrefSize(250,50);
        //
        i.setStyle("-fx-background-color: transparent;");
        i.setLayoutX(205);
        i.setLayoutY(400);
        i.setPrefSize(100,60);
        //
        ex.setStyle("-fx-background-color: transparent;");
        ex.setLayoutX(200);
        ex.setLayoutY(455);
        ex.setPrefSize(100,60);
        //////akcje
        ex.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("xoxo");
                System.exit(0);
            }
        });
        hs.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("tutaj wyniki");
                new Sortowanko();
                new Wyniki();
            }
        });
        i.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("tutaj info");
                new info();

            }
        });
        ng.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("nowa gierka");
                new pełzanie();
            }
        });

    }
}
