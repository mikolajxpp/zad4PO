package cipher;

public class StrategyCaesar implements CipherStrategy {
    private final int shift;
    public StrategyCaesar(int shift){
        if(shift >=0){
            this.shift=shift%26;
        }
        else{
            this.shift=(26+shift%26);
        }
    }
    @Override
    public String encode(String text){ // nie szyfrujemy znakow spoza alfabetu
        StringBuilder outcome= new StringBuilder(); // zeby nie tworzyc nowego obiektu stringa za kazdym razem jak dodamy literke
        for (int i=0; i<text.length(); i++){
            char znak=text.charAt(i);
            if(znak>='A' && znak<='Z'){
                znak+=shift;
                if (znak>'Z'){
                    znak = (char)(znak - 'Z' + 'A' - 1);
                }
            }
            else if(znak>='a' && znak<='z'){
                znak+=shift;
                if (znak>'z'){
                    znak = (char)(znak - 'z' + 'a' - 1);
                }
            }
            outcome.append(znak);
        }
        return outcome.toString();
    }
    @Override
    public String decode(String text){ // tak jak w szyfrowaniu pomijamy znaki spoza alfabetu
        StringBuilder outcome= new StringBuilder();
        for (int i=0; i<text.length(); i++){
            char znak=text.charAt(i);
            if(znak>='A' && znak<='Z'){
                znak-=shift;
                if (znak<'A'){
                    znak = (char) ('Z' -  ('A' - znak) +1); 
                }
            }
            else if(znak>='a' && znak<='z'){
                znak-=shift;
                if (znak<'a'){
                    znak = (char)('z' -  ('a' - znak) +1); 
                }
            }
            outcome.append(znak);
        }
        return outcome.toString();
    }
}