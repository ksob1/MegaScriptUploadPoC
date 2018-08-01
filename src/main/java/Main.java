import java.io.*;

public class Main {
        public static void main(String[] args){
            String username = "";
            String password = "";
            String scriptName = "megaDownload.sh";
            String scriptDir = "/home/kris/mega/";
            ProcessBuilder pb;
            if(!username.isEmpty() && !password.isEmpty()){
                pb  = new ProcessBuilder("/bin/sh", scriptDir+scriptName, username, password);
            }else{
                pb  = new ProcessBuilder("/bin/sh", scriptDir+scriptName);
            }
            pb.directory(new File(scriptDir));
            try {
                Process p = pb.start();
                p.waitFor(); // this is necessary, as it prevents application from closing before the upload finishes
            }catch(Exception e){
                e.printStackTrace();
            }
        }
}