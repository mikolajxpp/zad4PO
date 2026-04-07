package data;

public abstract class DataReader {
    public abstract Chunk readChunk();
    public abstract void close();
}
