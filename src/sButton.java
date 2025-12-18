
import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class sButton extends tButton{

    private int count;

    public sButton(String l ,String d , int x, int y, Color bC, Color tC){
        super(l, d, x, y, bC, tC);
    }

    public void save(textInput t1, textInput t2){
        try {
            // Scanner scanner = new Scanner(new File("assets/logins/" + t1.getS() + "/password.txt"));
            // while(scanner.hasNextLine()){
            //     count = Integer.parseInt(scanner.nextLine());
            // }
            File userFolder = new File("assets/logins/" + t1.getS()); 
            if (!userFolder.exists()) { 
                userFolder.mkdirs();
                }

            FileWriter loginFiles = new FileWriter("assets/logins/" + t1.getS() + "/password.txt", false);
            // System.out.println("doing this lalalalal");
            // FileWriter numberFile = new FileWriter("assets/logins/number");

            // numberFile.write(String.valueOf(count+1));
            // numberFile.close();
            loginFiles.write(t2.getS()+ "\n"+"\n");
            loginFiles.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void makePlant(File file, String username, String pName, ArrayList<Pic> s){

        // System.out.println("file: " + file.toString());

        File destFolder = new File("assets/logins/" + username + "/"+ pName + "/");
            if (!destFolder.exists()) {
                destFolder.mkdirs(); 
            }

            String extension = "";
            int dotIndex = file.getName().lastIndexOf('.');
            if (dotIndex > 0) {
            extension = file.getName().substring(dotIndex); 
            }

            Path destPath = Paths.get(destFolder.getPath(), "thumbnail" + extension);

            // int counter = 1; 
            // while (Files.exists(destPath)) { 
            //     destPath = Paths.get(destFolder.getPath(), pName + counter); 
            //     counter++; }

            try {
                Files.copy(file.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
               
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // try {
                // System.out.println("assets/logins/" + username + ".txt");
                // FileWriter aPToFile = new FileWriter("assets/logins/" + username + "/" + "plantlist.txt", true);
                
                // aPToFile.append("plant: " + destPath.toString()+"\n");

                // System.out.println("plant: " + destPath.toString()+"\n");
                // aPToFile.close();

            // } catch (IOException e) {
            //     // TODO Auto-generated catch block
            //     e.printStackTrace();
            // }

            // s.remove(0);
    }


}
