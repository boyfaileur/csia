
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
        
            File userFolder = new File("assets/logins/" + t1.getS()); 
            if (!userFolder.exists()) { 
                userFolder.mkdirs();
                }

            FileWriter loginFiles = new FileWriter("assets/logins/" + t1.getS() + "/password.txt", false);
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
            int count = 1;

            checkExist(destFolder, destPath, pName, extension);
            

     
            try {
                Files.copy(file.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
               
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

         
    }

    public void checkExist(File destFolder, Path destPath, String pName, String extension){

        if (new File (destPath.toString()).exists()){
            destPath = Paths.get(destFolder.getPath(), pName + count + extension);
            if (new File (destPath.toString()).exists()){
                count++;
                destPath = Paths.get(destFolder.getPath(), pName + count + extension);
                checkExist(destFolder, destPath, pName, extension);

            }
        }

    }


}
