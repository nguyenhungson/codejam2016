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
public class S05_Watersheds {

    public static final String inputFileName = "src/file/05.B-small-practice.in";
    public static final String outputFileName = "src/file/05.B-small-practice.out";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> listDataInput = IOFile.getDataFromFile(inputFileName);
        StringBuilder strOut = new StringBuilder();
        String arrFirst[] = listDataInput.get(0).split(" ");
        int T = Integer.parseInt(arrFirst[0]);
        int indexList = 1;
        int indexData = 1;

        while (indexData <= T) {
            String mapSize[] = listDataInput.get(indexList).split(" ");
            int height = Integer.parseInt(mapSize[0]);
            int width = Integer.parseInt(mapSize[1]);
            int[][] map = new int[height][width];

            for (int i = 0; i < height; i++) {
                indexList++;
                String strRow[] = listDataInput.get(indexList).split(" ");
                for (int j = 0; j < width; j++) {
                    map[i][j] = Integer.parseInt(strRow[j]);
                }
            }

            String[][] mapLabel = mapLabel(map, height, width);
            String caseRs = String.format("Case #%s:\n", indexData);
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    caseRs += mapLabel[i][j] + " ";
                }
                caseRs += "\n";
            }
            System.out.println(caseRs);
            strOut.append(caseRs);

            indexData++;
            indexList++;
        }

        IOFile.writeOutputToFile(strOut, outputFileName);

    }

    public static String[][] mapLabel(int[][] map, int height, int width) {
        String[][] mapLabel = new String[height][width];
        String arrLabel[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int indexUseLabel = 0;
        int maxAlti = 10000;

        for (int i = 0; i < height; i++) {
            int top = -1, bottom = -1;
            if (i == 0) {
                top = maxAlti;
            }
            if (i == height - 1) {
                bottom = maxAlti;
            }
            for (int j = 0; j < width; j++) {
                int left = -1, right = -1;
                if (j == 0) {
                    left = maxAlti;
                }
                if (j == width - 1) {
                    right = maxAlti;
                }

                int iMin = i;
                int jMin = j;
                int curValur = map[i][j];

                if (top != maxAlti && map[i - 1][j] < curValur) {
                    curValur = map[i - 1][j];
                    iMin = i - 1;
                    jMin = j;
                }
                if (left != maxAlti && map[i][j - 1] < curValur) {
                    curValur = map[i][j - 1];
                    iMin = i;
                    jMin = j - 1;
                }
                if (right != maxAlti && map[i][j + 1] < curValur) {
                    curValur = map[i][j + 1];
                    iMin = i;
                    jMin = j + 1;
                }
                if (bottom != maxAlti && map[i + 1][j] < curValur) {
                    iMin = i + 1;
                    jMin = j;
                }

                if (iMin != i || jMin != j) {
                    if (mapLabel[iMin][jMin] == null) {
                        if (mapLabel[i][j] == null) {
                            mapLabel[i][j] = arrLabel[indexUseLabel];
                            indexUseLabel++;
                        }
                        mapLabel[iMin][jMin] = mapLabel[i][j];
                    } else {
                        if (mapLabel[i][j] != null) {
                            String oldChar = mapLabel[i][j];
                            String newChar = mapLabel[iMin][jMin];
                            mapLabel = updateLabel(mapLabel, height, width, oldChar, newChar);
                        }
                        mapLabel[i][j] = mapLabel[iMin][jMin];
                    }
                } else {
                    if (mapLabel[i][j] == null) {
                        mapLabel[i][j] = arrLabel[indexUseLabel];
                        indexUseLabel++;
                    }
                }
            }
        }

        return mapLabel;
    }

    public static String[][] updateLabel(String[][] mapLabel, int height, int width, String oldChar, String newChar) {
        String[][] mapNew = mapLabel;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (mapLabel[i][j] != null && mapLabel[i][j].equals(oldChar)) {
                    mapNew[i][j] = mapLabel[i][j].replaceAll(oldChar, newChar);
                }
            }
        }

        return mapNew;
    }

}
