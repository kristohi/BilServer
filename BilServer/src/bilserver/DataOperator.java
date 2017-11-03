/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilserver;

/**
 *
 * @author JKK
 */
public class DataOperator {

    String[] stringsFromArduino;
    String[] stringsFromGUI;

    int maxStrings = 10;
    
    private String W;
    private String S;
    private String A;
    private String D;

    public DataOperator() {
        this.stringsFromArduino = new String[maxStrings];
        this.stringsFromGUI = new String[maxStrings];
    }

    public void handleStringsFromArduino(String string, int stringNumber) {
        //this.stringFromArduino = string;
        if (stringNumber < maxStrings && stringNumber >= 0) {
            this.stringsFromArduino[stringNumber] = string;
            System.out.println("TESTING:" + string);
        }
    }

    public void setStringsFromGUI(String[] strings){
        for(int i = 0; 1 < 10; i++){
        this.stringsFromGUI[i] = strings[i];

    }
        
        //String W = strings[0];
        
        
        
    }
    
    public String setStrings(String string) {
        return string;

    }

    public int setMaxStrings(int maxStrings) {
        return maxStrings;
    }

    public String[] getStrings() {
        return stringsFromArduino;
    }

    public int getMaxStrings() {
        return maxStrings;
    }

    /*
        Sets the 
    */
    
    public void goForward(){
        this.setStrings(dataToarduino[])
        
    }
    
    
}
