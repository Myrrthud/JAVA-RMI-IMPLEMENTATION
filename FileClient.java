import java.io.FileOutputStream;
import java.rmi.Naming;

public class FileClient {
    public static void main(String[] args) {
        try {
            FileServerInterface fileServer = (FileServerInterface) Naming.lookup("rmi://localhost/FileServer");

            String filename = "file.txt";
            byte[] fileData = fileServer.getFile(filename);

            if (fileData != null) {
                // Save the file to disk
                String outputFilename = "message.txt";
                FileOutputStream fos = new FileOutputStream(outputFilename);
                fos.write(fileData);
                fos.close();

                System.out.println("File retrieved and saved as " + outputFilename);
            } else {
                System.out.println("File not found on the server.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
