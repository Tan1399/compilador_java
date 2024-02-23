/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_2.compiladores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian
 */
public class LectorArchivo {
     public static List<Token> leerArchivo(String nombreArchivo) throws FileNotFoundException, IOException {
         List<Token> tokens = new ArrayList<>();
        File archivo = new File(nombreArchivo);
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            int numeroLinea = 1;
            while ((linea = br.readLine()) != null) {
                AnalizadorLexico al = new AnalizadorLexico(linea, numeroLinea);
                al.analizar(numeroLinea);
                tokens.addAll(al.getTokens());
                numeroLinea++;
            }

            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura: " + e.getMessage());
        }
        return tokens;
    }
    
}
