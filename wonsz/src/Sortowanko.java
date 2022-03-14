import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
class Gracz implements Comparable<Gracz>
{
    String nick;
    int score;
    public Gracz(String nick, int score) {
        this.nick = nick;
        this.score = score;
    }

    @Override
    public int compareTo(Gracz o) {
        if(score > o.score) return 1;
        if(score < o.score) return -1;
        else return 1;


    }
}
public class Sortowanko {

    public Sortowanko()  {

        File plik = new File("C:\\Users\\Rododendron\\Desktop\\xd\\projekty java\\wonsz\\src\\Scores.txt");
        Scanner in = null;

        try{
            in = new Scanner(plik);
        } catch(
                FileNotFoundException e) {
            e.printStackTrace();
        }


        ArrayList<Gracz> graczRecords = new ArrayList<>();



        //String currentLine = in.nextLine();


        while(in.hasNextLine()) {
            String currentLine = in.nextLine();
            String[] graczDetail = currentLine.split("  ");
            ////////////////
            String nick = graczDetail[0];

            int score = Integer.parseInt(graczDetail[1]);

            ////////////////
            graczRecords.add(new Gracz(nick, score));
//                currentLine = in.nextLine();
        }
        graczRecords.sort(Gracz::compareTo);

        PrintWriter zapis = null;
        try {
            zapis = new PrintWriter("C:\\Users\\Rododendron\\Desktop\\xd\\projekty java\\wonsz\\src\\HighScores.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(Gracz student :graczRecords) {

            zapis.print(student.nick);
            zapis.print(" " + student.score );
            zapis.println("");
        }
        zapis.close();
    }
}

