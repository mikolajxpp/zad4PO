package appConfigs;

import cipher.CipherType;

public class ArgumentParser {
    public AppArguments parse(String args[]){
        AppArguments flags = new AppArguments();
        int i=0;
        int n=args.length;
        if(n%2!=0){
            System.out.println("Zła ilość argumentów");
            System.exit(1);
        }
        while (n%2==0 && i<n-1){
            switch(args[i]){
                case "-source":
                    flags.setSourcePath(args[i+1]);
                    break;
                case "-destination":
                    flags.setDestinationPath(args[i+1]);
                    break;
                case "-mode":
                    flags.setMode(AppMode.valueOf(args[i+1]));
                    break;
                case "-type":
                    flags.setCipherType(CipherType.valueOf(args[i+1].toUpperCase()));
                    break;
                case "-shift":
                    flags.setShift(Integer.parseInt(args[i+1].toUpperCase()));
            }
            i+=2;
        }
        return flags;
    }
}
