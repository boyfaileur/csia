
import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;

public class sButton extends tButton{

    private int count;

    public sButton(String l ,String d , int x, int y, Color bC, Color tC){
        super(l, d, x, y, bC, tC);
    }

    public void save(textInput t1, textInput t2){
        try {
            // Scanner scanner = new Scanner(new File("assets/logins/number"));
            // while(scanner.hasNextLine()){
            //     count = Integer.parseInt(scanner.nextLine());
            // }

            FileWriter loginFiles = new FileWriter("assets/logins/" + t1.getS() + ".txt", false);
            // FileWriter numberFile = new FileWriter("assets/logins/number");

            // numberFile.write(String.valueOf(count+1));
            // numberFile.close();
            loginFiles.write(t1.getS()+ "\n");
            loginFiles.write(t2.getS()+ "\n");
            loginFiles.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
