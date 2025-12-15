import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.JFileChooser;

public class uLButton extends tButton{

    private Color bC, tC;
    
    public uLButton(String l ,String d , int x, int y, Color bC, Color tC){
        super(l, d, x, y, bC, tC);
    }

    public String uploadIMG(String username){
        String temp = "";

        JFileChooser uploader = new JFileChooser();
        uploader.setDialogTitle("");

        uploader.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
            "Image files", "jpg", "jpeg", "png", "gif"
        ));

        int result = uploader.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = uploader.getSelectedFile();

            File destFolder = new File("assets/images/" + username + "/");
            if (!destFolder.exists()) {
                destFolder.mkdirs(); 
            }

            Path destPath = Paths.get(destFolder.getPath(), selectedFile.getName());

            try {
                Files.copy(selectedFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            temp = destPath.toString();
     }
     return temp;
}

}
