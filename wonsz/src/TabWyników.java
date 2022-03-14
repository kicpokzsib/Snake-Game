import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class TabWyników {
//"C:/Users/Rododendron/IdeaProjects/MTG/Scores.txt"

    public TabWyników()  {
        JFrame O1 = new JFrame("Scores");
        O1.setSize(300, 428);
        O1.setVisible(true);
        O1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        O1.setLocationRelativeTo(null);
        O1.setResizable(false);
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        O1.add(p1);
        ////////////////////////////////
        JLabel eh  = new JLabel();
        JLabel eh2 = new JLabel();
        JLabel eh3 = new JLabel();
        JLabel eh4 = new JLabel();
        JLabel eh5 = new JLabel();
        JLabel eh6 = new JLabel();
        JLabel eh7 = new JLabel();
        JLabel eh8 = new JLabel();
        JLabel eh9 = new JLabel();
        JLabel eh10 = new JLabel();
        ///////////////////////////////
        File plik = new File("HighScores.txt");
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
        O1.add(eh);
        O1.add(eh2);
        O1.add(eh3);
        O1.add(eh4);
        O1.add(eh5);
        O1.add(eh6);
        O1.add(eh7);
        O1.add(eh8);
        O1.add(eh9);
        O1.add(eh10);
        //////no tak
        eh.setBounds(0,4,400,20);
        eh2.setBounds(0,24,400,20);
        eh3.setBounds(0,44,400,20);
        eh4.setBounds(0,64,400,20);
        eh5.setBounds(0,84,400,20);
        eh6.setBounds(0,104,400,20);
        eh7.setBounds(0,124,400,20);
        eh8.setBounds(0,144,400,20);
        eh9.setBounds(0,164,400,20);
        eh10.setBounds(0,184,400,20);
        ///////to normalnie raczej
        eh.setOpaque(true);
        eh.setBackground(Color.ORANGE);
        eh2.setOpaque(true);
        eh2.setBackground(Color.LIGHT_GRAY);
        eh3.setOpaque(true);
        eh3.setBackground(Color.pink);
    }
}







