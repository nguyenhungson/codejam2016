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
public class S02_ReverseWords {

    public static final String inputFileName = "src/file/02.B-large-practice.in";
    public static final String outputFileName = "src/file/02.B-large-practice.out";

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
            String result = String.format("Case #%s: %s\n", indexList, reverseWords(strInput));
            strOut.append(result);
            indexList++;
        }

        System.out.println(strOut);
        IOFile.writeOutputToFile(strOut, outputFileName);

    }

    private static String reverseWords(String strInput) {
        String arrStr[] = strInput.split(" ");
        String rs = "";
        int sizeArr = arrStr.length;
        for (int i = sizeArr - 1; i >= 0; i--) {
            rs += arrStr[i] + " ";
        }
        return rs;
    }

}
