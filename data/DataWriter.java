package data;

public abstract class DataWriter {
    public abstract void writeChunk(Chunk chunk);
    public abstract void close();
}
