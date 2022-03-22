/*Zoraz Haseeb
* 24/09/2021
* cms 256-001 */
package cmsc256;


public class RamString implements WackyStringInterface{
    //Declare instance variable
    private String word;

    //Parameterised constructor
    public RamString(String word) {
        if(word == null){
            throw new IllegalArgumentException("Word cannot be null");
        }
        this.word = word;
    }
    //Default constructor
    public RamString(){
        this("Rams! Let's Go Rams and CS@VCU!");
    }

    //Sets the String
    @Override
    public void setWackyString(String word) {
        if(word == null){
            throw new IllegalArgumentException("Word cannot be null");
        }
        this.word = word;
    }
    // This method returns the value of the String
    @Override
    public String getWackyString() {
        return word;
    }

    //This method counts the amount of times the word VCU or Rams appears in a sentence
    @Override
    public int countVCURams() {
        //Convert the whole string to lowercase for case sensitivity
        String lowercaseWord = word.toLowerCase();
        int count = 0;
        String Rams = "Rams";
        String VCU = "VCU";
        //For loop to iterate through the string to find either Rams or VCU in the string
        for(int i =0;i < word.length(); i++) {
            if (word.substring(i).length() >= 4 && lowercaseWord.substring(i).startsWith("rams")) {
                count++;
            }

            if (word.substring(i).length() >= 3 && word.substring(i).startsWith("VCU")) {
                count++;
            }
        }

        return count;
    }

    //Finds if the string has the word rams in it
    @Override
    public boolean hasRams() {
        boolean itHasRams = false;
        for (int i = 0; i < 2; i++){
            if(word.substring(i).startsWith("rams")){
                itHasRams = true;
            }
        }
        return itHasRams;
    }

    //Finds whether a specified prefix is included in the String at a different location
    @Override
    public boolean hasRepeatingPrefix(int numChars) {
        boolean itHasRepeatingPrefix = false;
        String prefix = "";
        //Prefix is loaded into its own string
        for(int i = 0; i == numChars ; i++){
            prefix += word.substring(i);
        }
        //For loop iterates through the string after the prefix to find the prefix again
        for(int j = numChars + 1; j <= word.length();j++){
            if(word.substring(j).startsWith(prefix) && word.substring(j).length() >= numChars + 1){
                itHasRepeatingPrefix = true;
            }
        }
        return itHasRepeatingPrefix;
    }

    //Method substitutes numbers for corresponding letters
    @Override
    public String makeNumberSubstitutions() {

          String newWord =  word.replaceAll("i", "1");
          String newWord2 = newWord.replaceAll("e", "3");
          String newWord3 = newWord2.replaceAll("s", "5");
          String newWord4 = newWord3.replaceAll("o", "0");
          String newWord5 = newWord4.replaceAll("I","1");
          String newWord6 = newWord5.replaceAll("E","3");
          String newWord7 = newWord6.replaceAll("S", "5");
          String newWord8 = newWord7.replaceAll("O", "1");
        return newWord8;
    }

    //Method removes not from the sentence
    @Override
    public String removeNot() {
        String newWord = word.replaceAll("not ","");
        String newWord1 = newWord.replaceAll("not","");


        return newWord1;

    }
}

