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

        while (scanner.hasNext()) {
                System.out.print(scanner.next() + "|");
        }
        scanner.close();
    }

    private String pathNameBuilder(String filename) {
        return "../../../../" + filename + ".csv";
    }
}
