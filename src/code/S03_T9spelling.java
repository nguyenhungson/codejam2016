/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.util.List;
import utils.IOFile;

/**
 *
 * @author sonnh4
 */
public class S03_T9spelling {

    public static final String inputFileName = "src/file/03.C-large-practice.in";
    public static final String outputFileName = "src/file/03.C-large-practice.out";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> listDataInput = IOFile.getDataFromFile(inputFileName);
        StringBuilder strOut = new StringBuilder();
        int N = Integer.parseInt(listDataInput.get(0));
        int indexList = 1;

        while (indexList <= N) {
            String strInput = listDataInput.get(indexList);
            String result = String.format("Case #%s: %s\n", indexList, spelling(strInput));
            strOut.append(result);
            indexList++;
        }

        System.out.println(strOut);
        IOFile.writeOutputToFile(strOut, outputFileName);

    }

    private static String spelling(String strInput) {
        String arrKeyboard[] = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String arrStr[] = strInput.split("");
        String rs = "";
        int sizeArr = arrStr.length;
        int sizeArrKey = arrKeyboard.length;
        int preKey = -1;
        
        for (int i=0; i<sizeArr; i++) {
            for(int j=0; j<sizeArrKey; j++){
                if(arrKeyboard[j].contains(arrStr[i])){
                    int numPress = arrKeyboard[j].indexOf(arrStr[i]) + 1;
                    if(preKey == j){
                        rs += " ";
                    }
                    
                    for(int k=0; k<numPress; k++){
                        rs += j;
                    }
                    
                    preKey = j;
                    break;
                }
            }
            
        }
        
        return rs;
    }

}
