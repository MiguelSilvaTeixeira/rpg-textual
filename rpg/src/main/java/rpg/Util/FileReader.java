package rpg.Util;

import rpg.exceptions.InvalidFilePathException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public static String readTxtFile(String path) {

        try {

            File file = new File(path);

            Scanner scanner = new Scanner(file);

            if (file.exists()) {

                StringBuilder data = new StringBuilder();

                while (scanner.hasNextLine()) {
                    data.append(scanner.nextLine()).append("\n");
                }

                return data.toString();

            }

        } catch (FileNotFoundException e) {

            throw new InvalidFilePathException(e.getMessage());

        }

        return null;

    }

}
