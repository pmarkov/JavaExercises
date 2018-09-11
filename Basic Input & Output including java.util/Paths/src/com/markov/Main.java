package com.markov;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(path);
        System.out.println();

//        Path filePath = FileSystems.getDefault().getPath("files\\SubdirectoryFile.txt");
//        Path filePath = FileSystems.getDefault().getPath("files", "SubdirectoryFile.txt");

        Path filePath = Paths.get(".", "files", "SubdirectoryFile.txt");
        printFile(filePath);
        System.out.println();

        filePath = Paths.get("D:\\JavaPrograms\\Basic Input & Output including java.util\\outThere.txt");
        printFile(filePath);

        filePath = Paths.get(".");
        System.out.println(filePath.toAbsolutePath());

        // D:\\Examples\.\subfolder\..\directory - ".." means move back to the parent directory
        // D:\\Examples\directory

        Path path2 = FileSystems.getDefault().getPath(".", "files", "..", "files", "SubdirectoryFile.txt");
        System.out.println(path2.normalize());
        printFile(path2.normalize());

        Path path3 = FileSystems.getDefault().getPath("thisfiledoesn'texist.txt");
        System.out.println(path3.toAbsolutePath());

        filePath = FileSystems.getDefault().getPath("files");
        System.out.println("Exists = " + Files.exists(filePath));
        System.out.println("Exists = " + Files.exists(path3));
    }

    private static void printFile(Path path) {
        try (BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
