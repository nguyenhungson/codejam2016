/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.util.Arrays;
import java.util.List;
import utils.IOFile;

/**
 *
 * @author sonnh4
 */
public class S01_StoreCredit {
    
    public static final String inputFileName = "src/file/01.A-large-practice.in";
    public static final String outputFileName = "src/file/01.A-large-practice.out";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> listDataInput = IOFile.getDataFromFile(inputFileName);
        StringBuilder strOut = new StringBuilder();
        int N = Integer.parseInt(listDataInput.get(0));
        int indexList = 1;
        int listSize = listDataInput.size();
        
        while(indexList < listSize){
            for(int i=0; i<N; i++){
                int C = Integer.parseInt(listDataInput.get(indexList));
                indexList ++;
                int I = Integer.parseInt(listDataInput.get(indexList));
                indexList ++;
                int P[] = Arrays.asList(listDataInput.get(indexList).split(" ")).stream().mapToInt(Integer::parseInt).toArray();
                indexList ++;
                
                for(int j=0; j<I; j++){
                    int sumPrice = 0;
                    int isFind = 0;
                    for(int k=j+1; k<I; k++){
                        sumPrice = P[j] + P[k];
                        if(sumPrice == C){
                            String result = String.format("Case #%s: %s %s\n", i+1, j+1, k+1);
                            strOut.append(result);
                            isFind = 1;
                            break;
                        }
                    }
                    
                    if(isFind == 1){
                        break;
                    }
                }
            }
        }
        
        System.out.println(strOut);
        IOFile.writeOutputToFile(strOut, outputFileName);
        
    }
    
}
