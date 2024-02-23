/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_2.compiladores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author Sebastian
 */
public class ArchivodeErrores {
    private String inputFilePath;
    private String outputFilePath;
    private StringBuilder errorContent;

    public ArchivodeErrores(String inputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = getOutputFilePath(inputFilePath);
        errorContent = new StringBuilder();
    }

    public void addError(int lineNumber, String errorMessage) {
        System.out.println("Error agregado en línea: " + lineNumber + ", mensaje: " + errorMessage);
    errorContent.append("Línea ").append(lineNumber).append(": ").append(errorMessage).append("\n");
    }

    public String getErrorContent() {
        return errorContent.toString();
    }

    public void imprimirErrores() {
        System.out.println("Contenido de Errores:\n" + errorContent.toString());
    }

    public void writeErrorFile() {
        try (FileReader fileReader = new FileReader(inputFilePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(outputFilePath);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            StringBuilder inputContent = new StringBuilder();
            String line;
            int lineNumber = 1;

            while ((line = bufferedReader.readLine()) != null) {
                String lineNumberString = String.format("%05d", lineNumber);
                inputContent.append(lineNumberString).append("  ").append(line).append("\n");
                lineNumber++;
            }

            bufferedWriter.write(inputContent.toString());
            bufferedWriter.write("\n**************************\n\n");

            for (String error : errorContent.toString().split("\n")) {
                bufferedWriter.write(error);
                bufferedWriter.newLine();
            }

            System.out.println("Archivo de errores actualizado exitosamente: " + outputFilePath);
        } catch (IOException e) {
            // Ajusta según las necesidades de tu aplicación
            e.printStackTrace();
            System.out.println("Error al crear el archivo de errores: " + e.getMessage());
        }
    }

    private String getOutputFilePath(String inputFilePath) {
        Path inputPath = FileSystems.getDefault().getPath(inputFilePath);
        String inputFileName = inputPath.getFileName().toString();
        String inputDirectoryPath = inputPath.getParent().toString();
        String outputFileName = inputFileName + ".txt";
        return FileSystems.getDefault().getPath(inputDirectoryPath, outputFileName).toString();
    }
}
