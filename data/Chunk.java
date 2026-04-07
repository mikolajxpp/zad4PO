package data;

public class Chunk {
    public static final int MAX_SIZE = 1024;
    private String dataChunk;
    private int currSize = MAX_SIZE;
    void setDataFromArray(char[] data, int size) {
        dataChunk = new String(data, 0, size);
        currSize = size;
    }
    public void setDataFromString(String data) {
        dataChunk = data;
    }
    public String getData() {
        return dataChunk;
    }
    public int getSize() {
        return currSize;
    }
}
