/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utils.IOFile;

/**
 *
 * @author sonnh4
 */
public class S04_AlienLanguage {

    public static final String inputFileName = "src/file/04.A-large-practice.in";
    public static final String outputFileName = "src/file/04.A-large-practice.out";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> listDataInput = IOFile.getDataFromFile(inputFileName);
        StringBuilder strOut = new StringBuilder();
        String arrFirst[] = listDataInput.get(0).split(" ");
        int L = Integer.parseInt(arrFirst[0]);
        int D = Integer.parseInt(arrFirst[1]);
        int N = Integer.parseInt(arrFirst[2]);
        List<String> listExactly = new ArrayList<>();
        int indexList = 1;

        while (indexList <= D) {
            listExactly.add(listDataInput.get(indexList));
            indexList++;
        }
        
        int limitN = N + D;
        List<Pattern> listTest = new ArrayList<>();
        while(indexList <= limitN){
            String testCase = listDataInput.get(indexList).replace('(', '[').replace(')', ']');
            Pattern pattern = Pattern.compile(testCase);
            listTest.add(pattern);
            indexList++;
        }
        
        int sizePattern = listTest.size();
        for(int i=0; i<sizePattern; i++){
            int count = 0;
            for(String itemExac : listExactly){
                Matcher m = listTest.get(i).matcher(itemExac);
                if(m.matches()){
                    count ++;
                }
            }
            String rs = String.format("Case #%s: %s\n", i + 1, count);
            strOut.append(rs);
        }

        System.out.println(strOut);
        IOFile.writeOutputToFile(strOut, outputFileName);

    }

}
