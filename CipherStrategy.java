public interface CipherStrategy{
    String encode(String text);
    String decode(String text);
}