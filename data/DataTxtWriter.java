package data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataTxtWriter extends DataWriter{
    private String path;
    private BufferedWriter bw;
    public DataTxtWriter(String path) {
        this.path = path;
        try {
            bw = new BufferedWriter(new FileWriter(path));
        } catch (IOException e) {
            throw new RuntimeException("Incorrect path for DataTxtWriter", e);
        }
    }
    @Override
    public void writeChunk(Chunk chunk) {
        try {
            bw.write(chunk.getData());
        } catch (IOException e) {
            throw new RuntimeException("Failed to write chunk "
                    + chunk.getData() + "to a file in" + path, e);
        }
    }

    @Override
    public void close() {
        try {
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to close BufferedWriter in DataTxtWriter", e);
        }
    }
}
