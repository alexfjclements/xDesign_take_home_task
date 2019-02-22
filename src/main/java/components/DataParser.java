package components;

import models.MunroList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataParser {
    private MunroList munroList;


    public DataParser(String filename) throws FileNotFoundException {
        String filePath = pathNameBuilder(filename);
        Scanner scanner = new Scanner(new File(filePath));

        scanner.useDelimiter(",");

        while(scanner.hasNext()) {
            String lineOfText = scanner.nextLine();
            if (lineOfText.startsWith("Running")) {
                continue;
            }
                scanner.next();
        }

//        Running No,DoBIH Number,Streetmap,Geograph,Hill-bagging,Name,SMC Section,RHB Section,_Section,Height (m),Height (ft),Map 1:50,Map 1:25,Grid Ref,GridRefXY,xcoord,ycoord,1891,1921,1933,1953,1969,1974,1981,1984,1990,1997,Post 1997,Comments

        scanner.close();
    }

    private String pathNameBuilder(String filename) {
        return "../../../../" + filename + ".csv";
    }
}
