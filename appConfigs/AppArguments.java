package appConfigs;

import cipher.CipherType;

public class AppArguments {
    private String sourcePath;
    private String destinationPath;
    private AppMode mode;
    private CipherType cipherType;
    private int shift;

    //settery 
    public void setSourcePath(String sourcePath){
        this.sourcePath=sourcePath;
    }
    public void setDestinationPath(String destinationPath){
        this.destinationPath=destinationPath;
    }
    public void setMode(AppMode mode){
        this.mode=mode;
    }
    public void setCipherType(CipherType cipherType){
        this.cipherType=cipherType;
    }
    public void setShift(int shift){
        this.shift=shift;
    }

    //gettery
    public String getSourcePath(){
        return sourcePath;
    }
    public String getDestinationPath(){
        return destinationPath;
    }
    public AppMode getMode(){
        return mode;
    }
    public CipherType getCipherType(){
        return cipherType;
    } 
    public int getShift(){
        return shift;
    }
}
