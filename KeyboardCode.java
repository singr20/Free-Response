import java.util.*;

public class KeyboardCode
{   
    String[] ALPHABET = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    String[] keyboard = {"Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M"};
    String code = ""; //Assume code is a message that has been converted into Keyboard Code (ex. "ITSSG" - HELLO).
    
    String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    String[] pNouns = {"JACKSON","LIAM", "OLIVIA", "LONDON", "JUPITER"}; //etc.
    
    public KeyboardCode(){
    
        convertCode(code);
        
    }
    
    public String convertCode(String a)
    {
        //Part A - Decipher code (String a) into the letters from the alphabet array (ex. convert "ITSSG" to "HELLO") and return the new string.
        String deciphered = "";
        
        for(int i = 0; i < a.length(); i++){
            String character = a.substring(i,i+1);
            for(int b = 0; b < keyboard.length; b++){
                if(keyboard[b].equals(character))
                    deciphered += ALPHABET[b];
            }
            if(character.equals(" "))
                deciphered += " ";
        }
        
        capitalizeCode(deciphered);
        
        return deciphered;
    }
    
    public String capitalizeCode(String a){
        //Part B - Make sure everything in String a is correctly capitalized. Assume pNouns contains all proper nouns.
        String cptlzd = "";
        
        String[] splitted = a.split(" ");
        
        for(int i = 0; i < splitted.length; i++){
            String word = splitted[i];
            boolean pNoun = false;
            for(int b = 0; b < pNouns.length; b++){
                if(pNouns[b].equals(word)){
                    pNoun = true;
                }
            }
            
            if(i == 0 || pNoun){
                cptlzd += word.substring(0,1);
                for(int c = 1; c < word.length(); c++){
                    String character = word.substring(c,c+1);
                    for(int x = 0; x < ALPHABET.length; x++){
                        if(character.equals(ALPHABET[x])){
                            cptlzd += alphabet[x];
                        }
                    }
                }
            }
            else{
                for(int c = 0; c < word.length(); c++){
                    String character = word.substring(c,c+1);
                    for(int x = 0; x < ALPHABET.length; x++){
                        if(character.equals(ALPHABET[x]))
                            cptlzd += alphabet[x];
                    }
                }
            }
            
            cptlzd += " ";
        }
        
        return cptlzd;
    }
}
