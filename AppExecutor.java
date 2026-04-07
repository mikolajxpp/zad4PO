import data.Chunk;
import data.DataReader;
import data.DataWriter;

import java.util.function.Function;

public class AppExecutor {
    private final CipherStrategy strategy;
    private final DataReader reader;
    private final DataWriter writer;
    private final AppArguments arguments;

    public AppExecutor(CipherStrategy strategy, DataReader reader, DataWriter writer, AppArguments arguments) {
        this.strategy = strategy;
        this.reader = reader;
        this.writer = writer;
        this.arguments = arguments;
    }

    private void processData(Function<String, String> cipherAction) {
        Chunk entryChunk = reader.readChunk();
        while (entryChunk != null && entryChunk.getSize() > 0) {
            Chunk writeChunk = new Chunk();
            writeChunk.setDataFromString(cipherAction.apply(entryChunk.getData()));
            entryChunk = reader.readChunk();
            writer.writeChunk(writeChunk);
        }
        writer.close();
        reader.close();
    }
    public void execute() {
        if (arguments.getMode() == AppMode.CIPHER) {
            processData(strategy::encode);
        } else {
            processData(strategy::decode);
        }
    }
}

