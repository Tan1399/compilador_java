/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_2.compiladores;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian
 */
public class Proyecto_2Compiladores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException, LexerException {
        
 
 
 
    
   
        
        String v_ruta = Paths.get("").toAbsolutePath().toString();
        String v_nombrearchivo="";
        
       
      
     //   ArchivodeErrores archivoErrores = new ArchivodeErrores(v_rutaerrores); 
        
        if (args.length == 0) {
        System.err.println("Debe proporcionar la ruta del archivo de entrada");
        System.exit(1);
    }

    // Obtener la ruta del archivo de entrada del primer argumento
   for (int i=0; i< args.length; i++){
            
          File t = new File(args[i]);  
          v_nombrearchivo= t.getName(); 
        }
        v_nombrearchivo= v_ruta + "\\"+ v_nombrearchivo;
        
 
  List<Token> tokens = null;
    try {
        tokens = LectorArchivo.leerArchivo(v_nombrearchivo);
    } catch (IOException e) {
        System.err.println("Error al leer el archivo: " + e.getMessage());
        System.exit(1);
    }
    
     List<String> erroresSemanticos = new ArrayList<>();
         
 ArchivodeErrores archivoErrores1 = new ArchivodeErrores( v_nombrearchivo);
     
 
    
  AnalizadorSintactico analizadorSintactico = new AnalizadorSintactico(tokens,  archivoErrores1);
   Tabla_Símbolos tbls = new Tabla_Símbolos();
AnalizadorSemantico ans = new AnalizadorSemantico(tokens);
  
    


    for (Token token : tokens) {
    if (token.getType() != TokenType.COMENTARIO && token.getType() != TokenType.SPACE) {
      // System.out.println(token);
        
    }
}
     
   
    
  analizadorSintactico.analizar();
//tbls.imprimirTabla();
ans.semanticaiguales();
ans.pruebasemantica();
ans.pruebasemantica2();
ans.analizarSemantica();
ans.analizarsemantica3();
ans.analizarsemantica4();
ans.analizarsemantica5();
ans.analizarsemantica6();
ans.analizarsemantica7();
ans.analizarsemantica8();


      
      
       //
    archivoErrores1.writeErrorFile();
    
    archivoErrores1.imprimirErrores();
        
       
     
        

         
      
      
     
      
        
        
       
    }
    
}
