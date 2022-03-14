import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.TimerTask;


public class pełzanie {
    Label times, score;
    int apl = 0;
    int frt=0;
    //
    int chck=1;
    //
    public int czas=0;
    //
    public String name;
    //
    boolean yay=true;
    //////////////////////////wyniki
    public File file = new File("C:\\Users\\Rododendron\\Desktop\\xd\\projekty java\\wonsz\\src\\Scores.txt");
    FileWriter fw;

    {
        try {
            fw = new FileWriter(file,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    PrintWriter pw = new PrintWriter(fw);

     public pełzanie()  {
         Pane sp2 = new Pane();
        Scene secondScene = new Scene(sp2, 600, 600, Color.BLUE);
        Stage info = new Stage();
        info.setTitle("SnakeTheGame");
        info.setScene(secondScene);
        info.show();
        info.setResizable(false);
        sp2.setStyle("-fx-background-color: #3ba8f0");
        sp2.setPadding(new Insets(100, 100, 100, 100));
        //////////
        times = new Label("time:");
        score = new Label("fruits:");
        //
        times.setLayoutX(15);
        times.setLayoutY(560);
        times.setFont(new Font("Serif", 30));
        //
        score.setLayoutX(470);
        score.setLayoutY(560);
        score.setFont(new Font("Serif", 30));
        //
        sp2.getChildren().add(times);
        sp2.getChildren().add(score);
        /////////////////////////////////////////////////////////////////////to tu
        /////////////////mapa
        Pane eh = new Pane();
        eh.setPrefSize(564, 544);
        eh.setBorder(new Border(new BorderStroke(Color.PINK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        eh.setStyle("-fx-background-color: #52dbff");
        eh.setLayoutX(20);
        eh.setLayoutY(20);
        sp2.getChildren().add(eh);
        //////papu
        ArrayList<Rectangle> papu = new ArrayList<>();
        final Rectangle[] f = {new Rectangle()};
        Rectangle f2 = new Rectangle();
        int xf = ((int) (Math.random() * 54) * 10) + 2;
        int yf = ((int) (Math.random() * 54) * 10) + 2;
        f[0].setX(xf);
        f[0].setY(yf);
        f[0].setWidth(10);
        f[0].setHeight(10);
        eh.getChildren().add(f[0]);
        f[0].setFill(new ImagePattern(new Image("JabkoPNG.png")));
        Rectangle f4 =new Rectangle();
        f4.setFill(new ImagePattern(new Image("BombHIGH.png")));
         f4.setWidth(10);
         f4.setHeight(10);
         Rectangle f5 =new Rectangle();
         f5.setFill(new ImagePattern(new Image("BombHIGH.png")));
         f5.setWidth(10);
         f5.setHeight(10);
         Rectangle f6 =new Rectangle();
         f6.setFill(new ImagePattern(new Image("BombHIGH.png")));
         f6.setWidth(10);
         f6.setHeight(10);
         Rectangle f7 =new Rectangle();
         f7.setFill(new ImagePattern(new Image("BombHIGH.png")));
         f7.setWidth(10);
         f7.setHeight(10);
        /////////lil wonsz
        int x = 42;
        int y = 42;
        Rectangle p = new Rectangle();
        p.setFill(Color.PINK);
        //p.setFill(new ImagePattern(new Image("Wonz2.jpg")));
        p.setFill(Color.PINK);
        p.setX(x);
        p.setY(y);
        p.setWidth(10);
        p.setHeight(10);
        eh.getChildren().add(p);
        Rectangle p2 = new Rectangle();
        Rectangle p3 = new Rectangle();
        eh.getChildren().add(p2);
        p2.setWidth(10);
        p2.setHeight(10);
        p3.setWidth(10);
        p3.setHeight(10);
        p2.setX(x - 10);
        p2.setY(y);
        p3.setX(p2.getX() - 10);
        p3.setY(y);
        eh.getChildren().add(p3);
        //p2.setFill(new ImagePattern(new Image("Wonz2.jpg")));
        //p3.setFill(new ImagePattern(new Image("Wonz2.jpg")));
        p2.setFill(Color.PINK);
        p3.setFill(Color.PINK);
        ///////////////////////////////wonsz rosnie
        Rectangle[] nxt = new Rectangle[999];
        for (int i = 0; i < 999; i++) {
            Rectangle r = new Rectangle();
            r.setWidth(10);
            r.setHeight(10);
            nxt[i] = r;
            //r.setFill(new ImagePattern(new Image("Wonz2.jpg")));
            //r.setFill(Color.PINK);
        }
        nxt[998].setX(p3.getX() - 10);
        nxt[998].setY(p3.getY());
        eh.getChildren().add(nxt[998]);
        //nxt[998].setFill(new ImagePattern(new Image("Wonz2.jpg")));
        nxt[998].setFill(Color.PINK);

        ////////////dzien dobry
        String uriString = new File("C:\\Users\\Rododendron\\Desktop\\xd\\projekty java\\wonsz\\src\\Quirky-Puzzle-Game-Menu.mp3").toURI().toString();
        MediaPlayer player = new MediaPlayer(new Media(uriString));
        player.play();
        player.getOnPlaying();
         player.setOnEndOfMedia(new Runnable() {
             @Override
             public void run() {
                 player.seek(Duration.ZERO);
                 player.play();
             }
         });
         String uriStrings = new File("C:\\Users\\Rododendron\\Desktop\\xd\\projekty java\\wonsz\\src\\Ninja Samurai Sword-SoundBible.com-1359598877.mp3").toURI().toString();
        MediaPlayer jabgo = new MediaPlayer(new Media(uriStrings));
        if (p.getX() == f[0].getX() && p.getY() == f[0].getY()) {
            System.out.println("dziendobry");
        }
        /////////////////animacja
        int speed=120;
        Thread prosz = new Thread(()->{
            while (true) {

                if (p.getX() == f4.getX() && p.getY() == f4.getY()||p.getX() == f5.getX() && p.getY() == f5.getY()||p.getX() == f6.getX() && p.getY() == f6.getY()||p.getX() == f7.getX() && p.getY() == f7.getY()){
                    System.out.println("ała");

                    JOptionPane.showMessageDialog(null,"You Lose!!!" +
                            "Press Escape");
                    frt=10000/apl;
                    pw.println(name+"  "+frt);
                    pw.close();
                    info.close();
                    yay=false;
                    player.stop();
                }
                //////
                if (p.getX() == f[0].getX() && p.getY() == f[0].getY()){
                    f[0].setFill(null);
                    frt++;
                    jabgo.play();
                    jabgo.stop();
                }
                /////////////////////////niesmaczne
                if(p.getY()==p3.getY()&&p.getX()==p3.getX()||p.getX()==nxt[998].getX()&&p.getY()==nxt[998].getY()&&nxt[998].getFill()==p.getFill()||p.getX()==nxt[850].getX()&&nxt[850].getY()==p.getY()&&nxt[850].getFill()==p.getFill()||p.getX()==nxt[851].getX()&&nxt[851].getY()==p.getY()&&nxt[851].getFill()==p.getFill()||p.getX()==nxt[852].getX()&&nxt[852].getY()==p.getY()&&nxt[852].getFill()==p.getFill()||p.getX()==nxt[853].getX()&&nxt[853].getY()==p.getY()&&nxt[853].getFill()==p.getFill()||p.getX()==nxt[854].getX()&&nxt[854].getY()==p.getY()&&nxt[854].getFill()==p.getFill()||p.getX()==nxt[855].getX()&&nxt[855].getY()==p.getY()&&nxt[855].getFill()==p.getFill()||p.getX()==nxt[856].getX()&&nxt[856].getY()==p.getY()&&nxt[856].getFill()==p.getFill()||p.getX()==nxt[857].getX()&&nxt[857].getY()==p.getY()&&nxt[857].getFill()==p.getFill()||p.getX()==nxt[858].getX()&&nxt[858].getY()==p.getY()&&nxt[858].getFill()==p.getFill()||p.getX()==nxt[859].getX()&&nxt[859].getY()==p.getY()&&nxt[859].getFill()==p.getFill()||p.getX()==nxt[860].getX()&&nxt[860].getY()==p.getY()&&nxt[860].getFill()==p.getFill()||p.getX()==nxt[861].getX()&&nxt[861].getY()==p.getY()&&nxt[861].getFill()==p.getFill()||p.getX()==nxt[862].getX()&&nxt[862].getY()==p.getY()&&nxt[862].getFill()==p.getFill()||p.getX()==nxt[863].getX()&&nxt[863].getY()==p.getY()&&nxt[863].getFill()==p.getFill()||p.getX()==nxt[864].getX()&&nxt[864].getY()==p.getY()&&nxt[864].getFill()==p.getFill()||p.getX()==nxt[865].getX()&&nxt[865].getY()==p.getY()&&nxt[865].getFill()==p.getFill()||p.getX()==nxt[866].getX()&&nxt[866].getY()==p.getY()&&nxt[866].getFill()==p.getFill()||p.getX()==nxt[867].getX()&&nxt[867].getY()==p.getY()&&nxt[867].getFill()==p.getFill()||p.getX()==nxt[868].getX()&&nxt[868].getY()==p.getY()&&nxt[868].getFill()==p.getFill()||p.getX()==nxt[869].getX()&&nxt[869].getY()==p.getY()&&nxt[869].getFill()==p.getFill()||p.getX()==nxt[870].getX()&&nxt[870].getY()==p.getY()&&nxt[870].getFill()==p.getFill()||p.getX()==nxt[871].getX()&&nxt[871].getY()==p.getY()&&nxt[871].getFill()==p.getFill()||p.getX()==nxt[872].getX()&&nxt[872].getY()==p.getY()&&nxt[872].getFill()==p.getFill()||p.getX()==nxt[873].getX()&&nxt[873].getY()==p.getY()&&nxt[873].getFill()==p.getFill()||p.getX()==nxt[874].getX()&&nxt[874].getY()==p.getY()&&nxt[874].getFill()==p.getFill()||p.getX()==nxt[875].getX()&&nxt[875].getY()==p.getY()&&nxt[875].getFill()==p.getFill()||p.getX()==nxt[876].getX()&&nxt[876].getY()==p.getY()&&nxt[876].getFill()==p.getFill()||p.getX()==nxt[877].getX()&&nxt[877].getY()==p.getY()&&nxt[877].getFill()==p.getFill()||p.getX()==nxt[878].getX()&&nxt[878].getY()==p.getY()&&nxt[878].getFill()==p.getFill()||p.getX()==nxt[879].getX()&&nxt[879].getY()==p.getY()&&nxt[879].getFill()==p.getFill()||p.getX()==nxt[880].getX()&&nxt[880].getY()==p.getY()&&nxt[880].getFill()==p.getFill()||p.getX()==nxt[881].getX()&&nxt[881].getY()==p.getY()&&nxt[881].getFill()==p.getFill()||p.getX()==nxt[882].getX()&&nxt[882].getY()==p.getY()&&nxt[882].getFill()==p.getFill()||p.getX()==nxt[883].getX()&&nxt[883].getY()==p.getY()&&nxt[883].getFill()==p.getFill()||p.getX()==nxt[884].getX()&&nxt[884].getY()==p.getY()&&nxt[884].getFill()==p.getFill()||p.getX()==nxt[885].getX()&&nxt[885].getY()==p.getY()&&nxt[885].getFill()==p.getFill()||p.getX()==nxt[886].getX()&&nxt[886].getY()==p.getY()&&nxt[886].getFill()==p.getFill()||p.getX()==nxt[887].getX()&&nxt[887].getY()==p.getY()&&nxt[887].getFill()==p.getFill()||p.getX()==nxt[888].getX()&&nxt[888].getY()==p.getY()&&nxt[888].getFill()==p.getFill()||p.getX()==nxt[889].getX()&&nxt[889].getY()==p.getY()&&nxt[889].getFill()==p.getFill()||p.getX()==nxt[890].getX()&&nxt[890].getY()==p.getY()&&nxt[890].getFill()==p.getFill()||p.getX()==nxt[891].getX()&&nxt[891].getY()==p.getY()&&nxt[891].getFill()==p.getFill()||p.getX()==nxt[892].getX()&&nxt[892].getY()==p.getY()&&nxt[892].getFill()==p.getFill()||p.getX()==nxt[893].getX()&&nxt[893].getY()==p.getY()&&nxt[893].getFill()==p.getFill()||p.getX()==nxt[894].getX()&&nxt[894].getY()==p.getY()&&nxt[894].getFill()==p.getFill()||p.getX()==nxt[895].getX()&&nxt[895].getY()==p.getY()&&nxt[895].getFill()==p.getFill()||p.getX()==nxt[896].getX()&&nxt[896].getY()==p.getY()&&nxt[896].getFill()==p.getFill()||p.getX()==nxt[897].getX()&&nxt[897].getY()==p.getY()&&nxt[897].getFill()==p.getFill()||p.getX()==nxt[898].getX()&&nxt[898].getY()==p.getY()&&nxt[898].getFill()==p.getFill()||p.getX()==nxt[899].getX()&&nxt[899].getY()==p.getY()&&nxt[899].getFill()==p.getFill()||p.getX()==nxt[900].getX()&&nxt[900].getY()==p.getY()&&nxt[900].getFill()==p.getFill()||p.getX()==nxt[901].getX()&&nxt[901].getY()==p.getY()&&nxt[901].getFill()==p.getFill()||p.getX()==nxt[902].getX()&&nxt[902].getY()==p.getY()&&nxt[902].getFill()==p.getFill()||p.getX()==nxt[903].getX()&&nxt[903].getY()==p.getY()&&nxt[903].getFill()==p.getFill()||p.getX()==nxt[904].getX()&&nxt[904].getY()==p.getY()&&nxt[904].getFill()==p.getFill()||p.getX()==nxt[905].getX()&&nxt[905].getY()==p.getY()&&nxt[905].getFill()==p.getFill()||p.getX()==nxt[906].getX()&&nxt[906].getY()==p.getY()&&nxt[906].getFill()==p.getFill()||p.getX()==nxt[907].getX()&&nxt[907].getY()==p.getY()&&nxt[907].getFill()==p.getFill()||p.getX()==nxt[908].getX()&&nxt[908].getY()==p.getY()&&nxt[908].getFill()==p.getFill()||p.getX()==nxt[909].getX()&&nxt[909].getY()==p.getY()&&nxt[909].getFill()==p.getFill()||p.getX()==nxt[910].getX()&&nxt[910].getY()==p.getY()&&nxt[910].getFill()==p.getFill()||p.getX()==nxt[911].getX()&&nxt[911].getY()==p.getY()&&nxt[911].getFill()==p.getFill()||p.getX()==nxt[912].getX()&&nxt[912].getY()==p.getY()&&nxt[912].getFill()==p.getFill()||p.getX()==nxt[913].getX()&&nxt[913].getY()==p.getY()&&nxt[913].getFill()==p.getFill()||p.getX()==nxt[914].getX()&&nxt[914].getY()==p.getY()&&nxt[914].getFill()==p.getFill()||p.getX()==nxt[915].getX()&&nxt[915].getY()==p.getY()&&nxt[915].getFill()==p.getFill()||p.getX()==nxt[916].getX()&&nxt[916].getY()==p.getY()&&nxt[916].getFill()==p.getFill()||p.getX()==nxt[917].getX()&&nxt[917].getY()==p.getY()&&nxt[917].getFill()==p.getFill()||p.getX()==nxt[918].getX()&&nxt[918].getY()==p.getY()&&nxt[918].getFill()==p.getFill()||p.getX()==nxt[919].getX()&&nxt[919].getY()==p.getY()&&nxt[919].getFill()==p.getFill()||p.getX()==nxt[920].getX()&&nxt[920].getY()==p.getY()&&nxt[920].getFill()==p.getFill()||p.getX()==nxt[921].getX()&&nxt[921].getY()==p.getY()&&nxt[921].getFill()==p.getFill()||p.getX()==nxt[922].getX()&&nxt[922].getY()==p.getY()&&nxt[922].getFill()==p.getFill()||p.getX()==nxt[923].getX()&&nxt[923].getY()==p.getY()&&nxt[923].getFill()==p.getFill()||p.getX()==nxt[924].getX()&&nxt[924].getY()==p.getY()&&nxt[924].getFill()==p.getFill()||p.getX()==nxt[925].getX()&&nxt[925].getY()==p.getY()&&nxt[925].getFill()==p.getFill()||p.getX()==nxt[926].getX()&&nxt[926].getY()==p.getY()&&nxt[926].getFill()==p.getFill()||p.getX()==nxt[927].getX()&&nxt[927].getY()==p.getY()&&nxt[927].getFill()==p.getFill()||p.getX()==nxt[928].getX()&&nxt[928].getY()==p.getY()&&nxt[928].getFill()==p.getFill()||p.getX()==nxt[929].getX()&&nxt[929].getY()==p.getY()&&nxt[929].getFill()==p.getFill()||p.getX()==nxt[930].getX()&&nxt[930].getY()==p.getY()&&nxt[930].getFill()==p.getFill()||p.getX()==nxt[931].getX()&&nxt[931].getY()==p.getY()&&nxt[931].getFill()==p.getFill()||p.getX()==nxt[932].getX()&&nxt[932].getY()==p.getY()&&nxt[932].getFill()==p.getFill()||p.getX()==nxt[933].getX()&&nxt[933].getY()==p.getY()&&nxt[933].getFill()==p.getFill()||p.getX()==nxt[934].getX()&&nxt[934].getY()==p.getY()&&nxt[934].getFill()==p.getFill()||p.getX()==nxt[935].getX()&&nxt[935].getY()==p.getY()&&nxt[935].getFill()==p.getFill()||p.getX()==nxt[936].getX()&&nxt[936].getY()==p.getY()&&nxt[936].getFill()==p.getFill()||p.getX()==nxt[937].getX()&&nxt[937].getY()==p.getY()&&nxt[937].getFill()==p.getFill()||p.getX()==nxt[938].getX()&&nxt[938].getY()==p.getY()&&nxt[938].getFill()==p.getFill()||p.getX()==nxt[939].getX()&&nxt[939].getY()==p.getY()&&nxt[939].getFill()==p.getFill()||p.getX()==nxt[940].getX()&&nxt[940].getY()==p.getY()&&nxt[940].getFill()==p.getFill()||p.getX()==nxt[941].getX()&&nxt[941].getY()==p.getY()&&nxt[941].getFill()==p.getFill()||p.getX()==nxt[942].getX()&&nxt[942].getY()==p.getY()&&nxt[942].getFill()==p.getFill()||p.getX()==nxt[943].getX()&&nxt[943].getY()==p.getY()&&nxt[943].getFill()==p.getFill()||p.getX()==nxt[944].getX()&&nxt[944].getY()==p.getY()&&nxt[944].getFill()==p.getFill()||p.getX()==nxt[945].getX()&&nxt[945].getY()==p.getY()&&nxt[945].getFill()==p.getFill()||p.getX()==nxt[946].getX()&&nxt[946].getY()==p.getY()&&nxt[946].getFill()==p.getFill()||p.getX()==nxt[947].getX()&&nxt[947].getY()==p.getY()&&nxt[947].getFill()==p.getFill()||p.getX()==nxt[948].getX()&&nxt[948].getY()==p.getY()&&nxt[948].getFill()==p.getFill()||p.getX()==nxt[949].getX()&&nxt[949].getY()==p.getY()&&nxt[949].getFill()==p.getFill()||p.getX()==nxt[950].getX()&&nxt[950].getY()==p.getY()&&nxt[950].getFill()==p.getFill()||p.getX()==nxt[951].getX()&&nxt[951].getY()==p.getY()&&nxt[951].getFill()==p.getFill()||p.getX()==nxt[952].getX()&&nxt[952].getY()==p.getY()&&nxt[952].getFill()==p.getFill()||p.getX()==nxt[953].getX()&&nxt[953].getY()==p.getY()&&nxt[953].getFill()==p.getFill()||p.getX()==nxt[954].getX()&&nxt[954].getY()==p.getY()&&nxt[954].getFill()==p.getFill()||p.getX()==nxt[955].getX()&&nxt[955].getY()==p.getY()&&nxt[955].getFill()==p.getFill()||p.getX()==nxt[956].getX()&&nxt[956].getY()==p.getY()&&nxt[956].getFill()==p.getFill()||p.getX()==nxt[957].getX()&&nxt[957].getY()==p.getY()&&nxt[957].getFill()==p.getFill()||p.getX()==nxt[958].getX()&&nxt[958].getY()==p.getY()&&nxt[958].getFill()==p.getFill()||p.getX()==nxt[959].getX()&&nxt[959].getY()==p.getY()&&nxt[959].getFill()==p.getFill()||p.getX()==nxt[960].getX()&&nxt[960].getY()==p.getY()&&nxt[960].getFill()==p.getFill()||p.getX()==nxt[961].getX()&&nxt[961].getY()==p.getY()&&nxt[961].getFill()==p.getFill()||p.getX()==nxt[962].getX()&&nxt[962].getY()==p.getY()&&nxt[962].getFill()==p.getFill()||p.getX()==nxt[963].getX()&&nxt[963].getY()==p.getY()&&nxt[963].getFill()==p.getFill()||p.getX()==nxt[964].getX()&&nxt[964].getY()==p.getY()&&nxt[964].getFill()==p.getFill()||p.getX()==nxt[965].getX()&&nxt[965].getY()==p.getY()&&nxt[965].getFill()==p.getFill()||p.getX()==nxt[966].getX()&&nxt[966].getY()==p.getY()&&nxt[966].getFill()==p.getFill()||p.getX()==nxt[967].getX()&&nxt[967].getY()==p.getY()&&nxt[967].getFill()==p.getFill()||p.getX()==nxt[968].getX()&&nxt[968].getY()==p.getY()&&nxt[968].getFill()==p.getFill()||p.getX()==nxt[969].getX()&&nxt[969].getY()==p.getY()&&nxt[969].getFill()==p.getFill()||p.getX()==nxt[970].getX()&&nxt[970].getY()==p.getY()&&nxt[970].getFill()==p.getFill()||p.getX()==nxt[971].getX()&&nxt[971].getY()==p.getY()&&nxt[971].getFill()==p.getFill()||p.getX()==nxt[972].getX()&&nxt[972].getY()==p.getY()&&nxt[972].getFill()==p.getFill()||p.getX()==nxt[973].getX()&&nxt[973].getY()==p.getY()&&nxt[973].getFill()==p.getFill()||p.getX()==nxt[974].getX()&&nxt[974].getY()==p.getY()&&nxt[974].getFill()==p.getFill()||p.getX()==nxt[975].getX()&&nxt[975].getY()==p.getY()&&nxt[975].getFill()==p.getFill()||p.getX()==nxt[976].getX()&&nxt[976].getY()==p.getY()&&nxt[976].getFill()==p.getFill()||p.getX()==nxt[977].getX()&&nxt[977].getY()==p.getY()&&nxt[977].getFill()==p.getFill()||p.getX()==nxt[978].getX()&&nxt[978].getY()==p.getY()&&nxt[978].getFill()==p.getFill()||p.getX()==nxt[979].getX()&&nxt[979].getY()==p.getY()&&nxt[979].getFill()==p.getFill()||p.getX()==nxt[980].getX()&&nxt[980].getY()==p.getY()&&nxt[980].getFill()==p.getFill()||p.getX()==nxt[981].getX()&&nxt[981].getY()==p.getY()&&nxt[981].getFill()==p.getFill()||p.getX()==nxt[982].getX()&&nxt[982].getY()==p.getY()&&nxt[982].getFill()==p.getFill()||p.getX()==nxt[983].getX()&&nxt[983].getY()==p.getY()&&nxt[983].getFill()==p.getFill()||p.getX()==nxt[984].getX()&&nxt[984].getY()==p.getY()&&nxt[984].getFill()==p.getFill()||p.getX()==nxt[985].getX()&&nxt[985].getY()==p.getY()&&nxt[985].getFill()==p.getFill()||p.getX()==nxt[986].getX()&&nxt[986].getY()==p.getY()&&nxt[986].getFill()==p.getFill()||p.getX()==nxt[987].getX()&&nxt[987].getY()==p.getY()&&nxt[987].getFill()==p.getFill()||p.getX()==nxt[988].getX()&&nxt[988].getY()==p.getY()&&nxt[988].getFill()==p.getFill()||p.getX()==nxt[989].getX()&&nxt[989].getY()==p.getY()&&nxt[989].getFill()==p.getFill()||p.getX()==nxt[990].getX()&&nxt[990].getY()==p.getY()&&nxt[990].getFill()==p.getFill()||p.getX()==nxt[991].getX()&&nxt[991].getY()==p.getY()&&nxt[991].getFill()==p.getFill()||p.getX()==nxt[992].getX()&&nxt[992].getY()==p.getY()&&nxt[992].getFill()==p.getFill()||p.getX()==nxt[993].getX()&&nxt[993].getY()==p.getY()&&nxt[993].getFill()==p.getFill()||p.getX()==nxt[994].getX()&&nxt[994].getY()==p.getY()&&nxt[994].getFill()==p.getFill()||p.getX()==nxt[995].getX()&&nxt[995].getY()==p.getY()&&nxt[995].getFill()==p.getFill()||p.getX()==nxt[996].getX()&&nxt[996].getY()==p.getY()&&nxt[996].getFill()==p.getFill()) {
                    System.out.println("ała");
                    JOptionPane.showMessageDialog(null,"You Lose!!!" +
                            "Press Escape");
                    frt=10000/apl;
                    pw.println(name+"  "+frt);
                    pw.close();
                    info.close();
                    yay=false;
                    player.stop();
                }

                ////////////////////////
                switch (chck) {
                case -1:
                    if (p.getX() >= 550) {
                        System.out.println("GameOver");
                        player.stop();
                        yay=false;
                    } else {
                        int i = 900;
                        while (i != 0) {
                            nxt[998 - i].setX(nxt[999 - i].getX());
                            nxt[998 - i].setY(nxt[999 - i].getY());
                            i--;
                        }
                        nxt[998].setX(p3.getX());
                        nxt[998].setY(p3.getY());
                        p3.setX(p2.getX());
                        p3.setY(p2.getY());
                        p2.setX(p.getX());
                        p2.setY(p.getY());
                        p.setX(p.getX() + 10);
                        System.out.println("right");
                    }

                    //////////
                    break;

                case 2:
                    if (p.getX() <= 2) {
                        System.out.println("GameOver");
                        player.stop();
                        yay=false;
                    } else {
                        int i = 900;
                        while (i != 0) {
                            nxt[998 - i].setX(nxt[999 - i].getX());
                            nxt[998 - i].setY(nxt[999 - i].getY());
                            i--;
                        }
                        nxt[998].setX(p3.getX());
                        nxt[998].setY(p3.getY());
                        p3.setX(p2.getX());
                        p3.setY(p2.getY());
                        p2.setX(p.getX());
                        p2.setY(p.getY());

                        p.setX(p.getX() - 10);
                        System.out.println("left");
                    }

                    break;
                case 3:
                    if (p.getY() <= 2) {
                        System.out.println("GameOver");
                        player.stop();
                        yay=false;
                    } else {
                        int i = 900;
                        while (i != 0) {
                            nxt[998 - i].setX(nxt[999 - i].getX());
                            nxt[998 - i].setY(nxt[999 - i].getY());
                            i--;
                        }
                        nxt[998].setX(p3.getX());
                        nxt[998].setY(p3.getY());
                        p3.setX(p2.getX());
                        p3.setY(p2.getY());
                        p2.setY(p.getY());
                        p2.setX(p.getX());

                        p.setY(p.getY() - 10);
                        System.out.println("up");
                    }
                    break;

                case 4:
                    if (p.getY() >= 530) {
                        System.out.println("GameOver");
                        player.stop();
                        yay=false;
                    } else {
                        int i = 900;
                        while (i != 0) {
                            nxt[998 - i].setX(nxt[999 - i].getX());
                            nxt[998 - i].setY(nxt[999 - i].getY());
                            i--;
                        }
                        nxt[998].setX(p3.getX());
                        nxt[998].setY(p3.getY());
                        p3.setX(p2.getX());
                        p3.setY(p2.getY());
                        p2.setY(p.getY());
                        p2.setX(p.getX());

                        p.setY(p.getY() + 10);
                        System.out.println("down");
                    }
                    break; }
            try {
                Thread.sleep(speed-(apl*2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } });
        prosz.start();
        /////////////////////////czas
         Timeline timeline = new Timeline(new KeyFrame(
                 Duration.millis(1000),
                 ae ->
         times.setText("Time:"+czas++)));
         timeline.setCycleCount(Animation.INDEFINITE);
         timeline.play();


        secondScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (frt>apl) {
                    eh.getChildren().remove(f[0]);
                    System.out.println("dziendobry");
                    int xf = ((int) (Math.random() * 54) * 10) + 2;
                    int yf = ((int) (Math.random() * 54) * 10) + 2;
                    f2.setX(xf);
                    f2.setY(yf);
                    f2.setWidth(10);
                    f2.setHeight(10);
                    eh.getChildren().add(f2);
                    f[0] = f2;
                    f2.setFill(new ImagePattern(new Image("JabkoPNG.png")));
                    ///////
                    apl++;
                    score.setText("fruits:" + apl);
                    if (apl % 10 == 0) {
                        f2.setFill(new ImagePattern(new Image("WatermellonHIGH.png")));
                    }
                    if(apl%10==0){
                        apl=apl+5;
                        frt=apl;
                        eh.getChildren().add(nxt[998 - apl+5]);
                        eh.getChildren().add(nxt[998 - apl+1]);
                        eh.getChildren().add(nxt[998 - apl+2]);
                        eh.getChildren().add(nxt[998 - apl+3]);
                        eh.getChildren().add(nxt[998 - apl+4]);
                        nxt[998 - apl].setX(nxt[999 - apl].getX());
                        nxt[998 - apl].setY(nxt[999 - apl].getY());
                        nxt[998-apl+5].setFill(Color.PINK);
                        nxt[998-apl+1].setFill(Color.PINK);
                        nxt[998-apl+2].setFill(Color.PINK);
                        nxt[998-apl+3].setFill(Color.PINK);
                        nxt[998-apl+4].setFill(Color.PINK);
                    }
                    eh.getChildren().add(nxt[998 - apl]);
                    nxt[998 - apl].setX(nxt[999 - apl].getX());
                    nxt[998 - apl].setY(nxt[999 - apl].getY());
                    nxt[998-apl].setFill(Color.PINK);
                    /////bomb
                    if(apl==28){
                        f4.setX(((int) (Math.random() * 54) * 10) + 2);
                        f4.setY(((int) (Math.random() * 54) * 10) + 2);
                        eh.getChildren().add(f4);
                    }
                    if(apl==16){
                        f5.setX(((int) (Math.random() * 54) * 10) + 2);
                        f5.setY(((int) (Math.random() * 54) * 10) + 2);
                        eh.getChildren().add(f5);
                    }
                    if(apl==37){
                        f6.setX(((int) (Math.random() * 54) * 10) + 2);
                        f6.setY(((int) (Math.random() * 54) * 10) + 2);
                        eh.getChildren().add(f6);
                    }
                    if(apl==47){
                        f7.setX(((int) (Math.random() * 54) * 10) + 2);
                        f7.setY(((int) (Math.random() * 54) * 10) + 2);
                        eh.getChildren().add(f7);
                    }
                }

            if (event.getCode() == KeyCode.RIGHT) {
                chck = -1;

            }

            if (event.getCode() == KeyCode.LEFT) {
                chck = 2;

            }
            if (event.getCode() == KeyCode.DOWN) {
                chck = 4;

            }
            if (event.getCode() == KeyCode.UP) {
                chck=3;
            }
            if(event.getCode()==KeyCode.ESCAPE||yay==false){
                prosz.stop();
                name = (JOptionPane.showInputDialog(null,"Enter you NickName","YOU LOSE!!!",JOptionPane.INFORMATION_MESSAGE));
                JOptionPane.showMessageDialog(null,"score saved");
                frt=10000/(apl+1);
                pw.println(name+"  "+frt);
                pw.close();
                info.close();
                player.stop();

            }

        }
        });
    }


}
