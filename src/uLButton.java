import java.awt.Color;
import java.io.File;
import javax.swing.JFileChooser;

public class uLButton extends tButton{

    private Color bC, tC;
    
    public uLButton(String l ,String d , int x, int y, Color bC, Color tC){
        super(l, d, x, y, bC, tC);
    }

    public File uploadIMG(){
        File temp = new File("");

        JFileChooser uploader = new JFileChooser();
        uploader.setDialogTitle("");

        uploader.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
            "Image files", "jpg", "jpeg", "png", "gif"
        ));

        int result = uploader.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            temp = uploader.getSelectedFile();    
            // System.out.println("file chosen: " + temp.toString());
            
         }


     return temp;
}

}
