import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Wyniki {
    Button close;
    public Wyniki() {
        Pane sp2 = new Pane();
        Scene secondScene = new Scene(sp2, 500, 600);
        Stage info = new Stage();
        info.setTitle("Info");
        info.setScene(secondScene);
        info.show();
        info.setResizable(false);
        sp2.setStyle("-fx-background-image: url('./HighscoreHIGH.jpg')");
        ///////
        close = new Button("");
        sp2.getChildren().add(close);
        //////
        close.setPrefSize(80, 40);
        close.setLayoutY(532);
        close.setLayoutX(54);
        close.setStyle("-fx-background-color: transparent;");
        ////////////////////////
        Label eh  = new Label();
        Label eh2 = new Label();
        Label eh3 = new Label();
        Label eh4 = new Label();
        Label eh5 = new Label();
        Label eh6 = new Label();
        Label eh7 = new Label();
        Label eh8 = new Label();
        Label eh9 = new Label();
        Label eh10 = new Label();
        ///////////////////////////////
        File plik = new File("C:\\Users\\Rododendron\\Desktop\\xd\\projekty java\\wonsz\\src\\HighScores.txt");
        Scanner in = null;
        /////////////////////////////////
        try {
            in = new Scanner(plik);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String zdanie=in.nextLine();
        String zdanie2=in.nextLine();
        String zdanie3=in.nextLine();
        String zdanie4=in.nextLine();
        String zdanie5=in.nextLine();
        String zdanie6=in.nextLine();
        String zdanie7=in.nextLine();
        String zdanie8=in.nextLine();
        String zdanie9=in.nextLine();
        String zdanie10=in.nextLine();
        /////no wiem xd
        eh.setText(zdanie);
        eh2.setText(zdanie2);
        eh3.setText(zdanie3);
        eh4.setText(zdanie4);
        eh5.setText(zdanie5);
        eh6.setText(zdanie6);
        eh7.setText(zdanie7);
        eh8.setText(zdanie8);
        eh9.setText(zdanie9);
        eh10.setText(zdanie10);
        ////wiem wiem wiem
        sp2.getChildren().add(eh);
        sp2.getChildren().add(eh2);
        sp2.getChildren().add(eh3);
        sp2.getChildren().add(eh4);
        sp2.getChildren().add(eh5);
        sp2.getChildren().add(eh6);
        sp2.getChildren().add(eh7);
        sp2.getChildren().add(eh8);
        sp2.getChildren().add(eh9);
        sp2.getChildren().add(eh10);
        //////no tak
        eh.setPrefSize(200, 40);
        eh.setLayoutY(150);
        eh.setLayoutX(100);
        eh2.setPrefSize(200, 40);
        eh2.setLayoutY(185);
        eh2.setLayoutX(100);
        eh3.setPrefSize(200, 40);
        eh3.setLayoutY(220);
        eh3.setLayoutX(100);
        eh4.setPrefSize(200, 40);
        eh4.setLayoutY(255);
        eh4.setLayoutX(100);
        eh5.setPrefSize(200, 40);
        eh5.setLayoutY(290);
        eh5.setLayoutX(100);
        eh6.setPrefSize(200, 40);
        eh6.setLayoutY(330);
        eh6.setLayoutX(100);
        eh7.setPrefSize(200, 40);
        eh7.setLayoutY(363);
        eh7.setLayoutX(100);
        eh8.setPrefSize(200, 40);
        eh8.setLayoutY(400);
        eh8.setLayoutX(100);
        eh9.setPrefSize(200, 40);
        eh9.setLayoutY(434);
        eh9.setLayoutX(100);
        eh10.setPrefSize(200, 40);
        eh10.setLayoutY(469);
        eh10.setLayoutX(100);
        ///////to normalnie raczej
        eh.setTextFill(Color.RED);
        eh2.setTextFill(Color.RED);
        eh3.setTextFill(Color.RED);
        eh4.setTextFill(Color.RED);
        eh5.setTextFill(Color.RED);
        eh6.setTextFill(Color.RED);
        eh7.setTextFill(Color.RED);
        eh8.setTextFill(Color.RED);
        eh9.setTextFill(Color.RED);
        eh10.setTextFill(Color.RED);

        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                info.close();
            }
        });
    }}
