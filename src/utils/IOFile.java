/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sonnh4
 */
public class IOFile {
    
    public static List<String> getDataFromFile(String inputFileName){
        List<String> listData = new ArrayList<>();
        try{
            BufferedReader reader = Files.newBufferedReader(Paths.get(inputFileName), StandardCharsets.UTF_8);
            String strLine;
            while ((strLine = reader.readLine()) != null) {
                listData.add(strLine);
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        
        return listData;
    }
    
    public static void writeOutputToFile(StringBuilder str, String outFileName) {
        Path file = Paths.get(outFileName);
        String strOut = str.toString();
        try {
            Files.write(file, strOut.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("Write file success");
    }
    
}
