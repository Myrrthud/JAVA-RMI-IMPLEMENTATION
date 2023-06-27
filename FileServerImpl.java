import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FileServerImpl extends UnicastRemoteObject implements FileServerInterface {
    private static final String FILE_DIRECTORY = "C:\\Users\\user\\Documents\\G2\\";

    protected FileServerImpl() throws RemoteException {
        super();
    }

    @Override
    public byte[] getFile(String filename) throws RemoteException {
        File file = new File(FILE_DIRECTORY, filename);

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] fileData = new byte[(int) file.length()];
            fis.read(fileData);
            return fileData;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
