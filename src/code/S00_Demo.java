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
public class S00_Demo {
    
    public static final String inputFileName = "src/file/00.input";
    public static final String outputFileName = "src/file/00.output";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> listDataInput = IOFile.getDataFromFile(inputFileName);
        StringBuilder strOut = new StringBuilder();
        for(String row : listDataInput){
            String output = row + " abc\n";
            strOut.append(output);
        }
        
        IOFile.writeOutputToFile(strOut, outputFileName);
        
    }
    
}
