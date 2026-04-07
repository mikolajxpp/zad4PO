package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static data.Chunk.MAX_SIZE;

public class DataTxtReader extends DataReader{
    private BufferedReader bf;
    private final String path;
    public DataTxtReader(String path) {
        this.path = path;
        try {
            bf = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Incorrect path " + path + " for DataTxtReader", e);
        }
    }

    @Override
    public Chunk readChunk() {
        char[] buffer = new char[MAX_SIZE];
        try {
            int bytesRead = bf.read(buffer, 0, MAX_SIZE);
            if (bytesRead == -1) {
                return null;
            }
            Chunk chunk = new Chunk();
            chunk.setDataFromArray(buffer, bytesRead);
            return chunk;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read chunk from " + path, e);
        }
    }

    @Override
    public void close() {
        try {
            bf.close();
        } catch (IOException e) {
            throw new RuntimeException("Erorr while closing BufferedReader in DataTxtReader", e);
        }

    }
}
