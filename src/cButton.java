import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class cButton extends tButton{

    private Color bC, tC;
    
    public cButton(String l ,String d , int x, int y, Color bC, Color tC){
        super(l, d, x, y, bC, tC);
    }

    public boolean checkCreds(String username, String password){

        boolean temp = false;
        try {
            File folder = new File("assets/logins");
            ArrayList<File> files = new ArrayList<File>();

            if(folder.exists()&&folder.isDirectory()){
                
                File[] tFiles = folder.listFiles();

            for (File file : tFiles) {
                if (file.isFile()) {
                    files.add(file);
                }
            }

            }

            if (!files.isEmpty()){
               for (int i = 0; i < files.size(); i++) {

               if (files.get(i).getName().startsWith(username)){
                Scanner scanner = new Scanner(files.get(i));
                while(scanner.hasNextLine()){
                    if (scanner.nextLine().equals(password)){
                        temp = true;
                        break;
                    } else{
                        temp = false;
                    }
                }

                scanner.close();

               }
                
            } 
            }

            
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return temp;
    }

}
