import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cButton extends tButton{

    private Color bC, tC;
    
    public cButton(String l ,String d , int x, int y, Color bC, Color tC){
        super(l, d, x, y, bC, tC);
    }

    public boolean checkCreds(String username, String password){

        boolean temp = false;
            File file = new File("assets/logins/" +username + "/password.txt");
            // ArrayList<File> files = new ArrayList<File>();

            if(file.exists()){
            
                
                try {
                    Scanner scanner = new Scanner(file);
                    
                    while(scanner.hasNextLine()){
                        String check = scanner.nextLine();

                        System.out.println("password:" + password);
                        System.out.println(check);
                        if (password.equals(check)){
                            System.out.println("ahdsjashjkdsajddas");
                            temp = true;
                            break;
                        } else{
                            temp = false;
                            break;
                        }
                    }
    
                    scanner.close();
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                

               } else {
                temp = false;
               }
                
            // } 
            // }

      

        return temp;
    }

}
