import appConfigs.AppArguments;
import appConfigs.ArgumentParser;
import cipher.StrategyCaesar;
import data.DataTxtReader;
import data.DataTxtWriter;

public class Main {
    public static void main(String[] args){
        ArgumentParser parser = new ArgumentParser();
        AppArguments config = parser.parse(args);
        AppExecutor appExecutor = new AppExecutor(
                new StrategyCaesar(config.getShift()),
                new DataTxtReader(config.getSourcePath()),
                new DataTxtWriter(config.getDestinationPath()),
                config);
        appExecutor.execute();
    }
}
