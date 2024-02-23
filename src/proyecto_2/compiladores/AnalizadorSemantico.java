/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_2.compiladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sebastian
 */
public class AnalizadorSemantico {
    
      private List<Token> tokens;
private Map<String, String> tablaSimbolos;

private List<String> errores;
public  AnalizadorSemantico  (List<Token> tokens) {
    tablaSimbolos = new HashMap<>();
    
      this.tokens = tokens;
         this.errores = new ArrayList<>();
}

// Método para agregar un identificador a la tabla de símbolos
public void agregarIdentificador(String identificador, String tipo) {
    tablaSimbolos.put(identificador, tipo);
}

 public boolean analizar() {
          semanticaint2 int2 = new semanticaint2 ();
          int2.validacion(tokens, errores);
          
          
                 
                 
                   
                       if (!errores.isEmpty()) {
            for (String error : errores) {
                System.out.println(error);
            }
            return false;
        }

        // Continuar con otras validaciones o análisis si es necesario
        return true;
              
              
              
          }
  public void analizarSemantica2() {
  Tabla_Símbolos tablaSimbolos = new Tabla_Símbolos();
    boolean declaracionEncontrada = false;

    for (int i = 0; i < tokens.size(); i++) {
        Token token = tokens.get(i);

        if (token.getType() == TokenType.PALABRAS_RESERVADAS && token.getLexeme().equals("char")||(token.getType() == TokenType.IDENTIFICADOR && token.getLexeme().equals("String"))) {
            declaracionEncontrada = true;
        } else if (declaracionEncontrada && token.getType() == TokenType.IDENTIFICADOR) {
            
            
            String identificador = token.getLexeme();
            
            
            Token siguienteToken = tokens.get(i + 1);

            if (siguienteToken.getType() == TokenType.COLON) {
                  String tipoDatoActual = "CARACTER";
            tablaSimbolos.agregarSimbolo(identificador, tipoDatoActual);
            System.out.println("Se agregó a la tabla: " + identificador + " (" + tipoDatoActual + ")");
            declaracionEncontrada = false; // Restablecer para la próxima declaración
               
            }
          
        } else if (tablaSimbolos.existeSimbolo(token.getLexeme()) && token.getType() == TokenType.IDENTIFICADOR) {
            Token siguienteToken = tokens.get(i + 1);

            if (siguienteToken.getType() == TokenType.OPERADORES_ARITMETICOS && siguienteToken.getLexeme().equals("=")) {
               // Después del identificador en la tabla de símbolos viene un "="
Token siguienteTokenDespuesIgual = tokens.get(i + 2);



    // Verificar que después del '=' solo hayan identificadores de tipo double o sc.nextDouble();
    int siguienteTokenIndex = i + 2;
    boolean permitirNextDouble = false;

   while (siguienteTokenIndex < tokens.size()) {
    Token siguienteTokenActual = tokens.get(siguienteTokenIndex);

    if (permitirNextDouble && siguienteTokenActual.getType() == TokenType.COLON) {
        // La asignación es válida
      //  System.out.println("Asignación válida para " + token.getLexeme());
        i = siguienteTokenIndex; // Saltar el punto y coma
        break;
    } else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR &&
            siguienteTokenActual.getLexeme().equals("sc") &&
            siguienteTokenIndex + 1 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 1).getType() == TokenType.PUNTO &&
            siguienteTokenIndex + 2 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 2).getType() == TokenType.IDENTIFICADOR &&
            tokens.get(siguienteTokenIndex + 2).getLexeme().equalsIgnoreCase("nextLine") &&
            siguienteTokenIndex + 3 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 3).getType() == TokenType.PARENTESIS_ABRE &&
            siguienteTokenIndex + 4 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 4).getType() == TokenType.PARENTESIS_CIERRA) {
        // Encontramos sc.nextDouble(), permitirlo en la siguiente iteración
        permitirNextDouble = true;
        break; // Detener la búsqueda
    } if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR) {
      
      
        String identificadorDespuesIgual = siguienteTokenActual.getLexeme();
        if (!tablaSimbolos.existeSimbolo(identificadorDespuesIgual) ||
                !tablaSimbolos.getTipoSimbolo(identificadorDespuesIgual).equals("CARACTER")) {
            System.out.println("Error semantico 050 luego del = deben ir identificadores y datos tipo CHAR. Línea: " + token.getLinea());
            break;
           
        }
    } else if (siguienteTokenActual.getType() == TokenType.OPERADORES_ARITMETICOS ||siguienteTokenActual.getType() == TokenType.ENTERO||siguienteTokenActual.getType() == TokenType.IDENTIFICADOR||siguienteTokenActual.getType() == TokenType.CADENA||siguienteTokenActual.getType() == TokenType.PARENTESIS_ABRE||siguienteTokenActual.getType() == TokenType.PARENTESIS_CIERRA||siguienteTokenActual.getType() == TokenType.COLON) {
       
        permitirNextDouble = false;
    } else {
       
        return; // Salir del método si hay un error
    }

    siguienteTokenIndex++;
}

    if (siguienteTokenIndex < tokens.size() &&
            tokens.get(siguienteTokenIndex).getType() == TokenType.COLON) {
        // La asignación es válida
       // System.out.println("Asignación válida para " + token.getLexeme());
        break;
       // i = siguienteTokenIndex; // Saltar el punto y coma
        
    } else {
        
    }

            }
        }
    }
 }
  
  public void pruebasemantica(){
    Tabla_Símbolos tablaSimbolos = new Tabla_Símbolos();
    boolean declaracionEncontrada = false;

    for (int i = 0; i < tokens.size(); i++) {
        Token token = tokens.get(i);

        if (token.getType() == TokenType.PALABRAS_RESERVADAS && token.getLexeme().equals("int")) {
            declaracionEncontrada = true;
        } else if (declaracionEncontrada && token.getType() == TokenType.IDENTIFICADOR) {
            
            
            String identificador = token.getLexeme();
            
            
            Token siguienteToken = tokens.get(i + 1);

            if (siguienteToken.getType() == TokenType.COLON) {
                  String tipoDatoActual = "ENTERO";
            tablaSimbolos.agregarSimbolo(identificador, tipoDatoActual);
         //   System.out.println("Se agregó a la tabla: " + identificador + " (" + tipoDatoActual + ")");
            declaracionEncontrada = false; // Restablecer para la próxima declaración
              
            }
         
        }
        else  
        if (tablaSimbolos.existeSimbolo(token.getLexeme()) && token.getType() == TokenType.IDENTIFICADOR) {
           String tipoIdentificador = tablaSimbolos.getTipoSimbolo(token.getLexeme());
    
    if ("ENTERO".equals(tipoIdentificador)) {
        Token siguienteToken = tokens.get(i + 1);
       

        if (siguienteToken.getType() == TokenType.OPERADORES_ARITMETICOS && siguienteToken.getLexeme().equals("=")) {
            // Después del identificador en la tabla de símbolos viene un "="
           // System.out.println("Procesando asignación para el identificador ENTERO: " + token.getLexeme());
           
            
             int siguienteTokenIndex = i + 2;
              boolean permitirNext = false;
            while (siguienteTokenIndex < tokens.size()) {
                Token siguienteTokenActual = tokens.get(siguienteTokenIndex);
 String identificadorDespuesIgual = siguienteTokenActual.getLexeme();
                if (siguienteTokenActual.getType() == TokenType.COLON) {
                    
                      
                    // La asignación es válida
                    //System.out.println("Asignación válida para " + token.getLexeme());
                    i = siguienteTokenIndex; // Saltar el punto y coma
            break;
                }else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR &&
            siguienteTokenActual.getLexeme().equals("sc") &&
            siguienteTokenIndex + 1 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 1).getType() == TokenType.PUNTO &&
            siguienteTokenIndex + 2 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 2).getType() == TokenType.IDENTIFICADOR &&
            tokens.get(siguienteTokenIndex + 2).getLexeme().equalsIgnoreCase("nextInt") &&
            siguienteTokenIndex + 3 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 3).getType() == TokenType.PARENTESIS_ABRE &&
            siguienteTokenIndex + 4 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 4).getType() == TokenType.PARENTESIS_CIERRA) {
        
        permitirNext = true;
     break;
                } else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR && tablaSimbolos.existeSimbolo(identificadorDespuesIgual) ||
                "ENTERO".equals(tablaSimbolos.getTipoSimbolo(identificadorDespuesIgual))||siguienteTokenActual.getType() == TokenType.ENTERO||siguienteTokenActual.getType() == TokenType.OPERADORES_ARITMETICOS) {
                            
                     //   System.out.println("a");
                               permitirNext = false;
                              
                           
                              
                        }else {
                            // Error si hay un token que no es de tipo entero después del '='
                            System.out.println("Error semántico 040 : Después del '=' deben ir identificadores y datos tipo entero. Línea: " + token.getLinea());
                           break;
                        }
                
                
         
                
                
               siguienteTokenIndex++;
                
            }
           
         
        
            
            
        }
        
        
        
       
    } else {
        // El identificador no es de tipo "ENTERO", puedes manejar este caso si es necesario
    }
    }

  
  }
  }
  
  public void pruebasemantica2(){
      Tabla_Símbolos tablaSimbolos = new Tabla_Símbolos();
    boolean declaracionEncontrada = false;

    for (int i = 0; i < tokens.size(); i++) {
        Token token = tokens.get(i);

        if (token.getType() == TokenType.PALABRAS_RESERVADAS && token.getLexeme().equals("char")) {
            declaracionEncontrada = true;
        } else if (declaracionEncontrada && token.getType() == TokenType.IDENTIFICADOR) {
            
            
            String identificador = token.getLexeme();
            
            
            Token siguienteToken = tokens.get(i + 1);

            if (siguienteToken.getType() == TokenType.COLON) {
                  String tipoDatoActual = "CARACTER";
            tablaSimbolos.agregarSimbolo(identificador, tipoDatoActual);
          //  System.out.println("Se agregó a la tabla: " + identificador + " (" + tipoDatoActual + ")");
            declaracionEncontrada = false; // Restablecer para la próxima declaración
               
            }
         
        }
        else  
        if (tablaSimbolos.existeSimbolo(token.getLexeme()) && token.getType() == TokenType.IDENTIFICADOR) {
           String tipoIdentificador = tablaSimbolos.getTipoSimbolo(token.getLexeme());
    
    if ("CARACTER".equals(tipoIdentificador)) {
        Token siguienteToken = tokens.get(i + 1);
       

        if (siguienteToken.getType() == TokenType.OPERADORES_ARITMETICOS && siguienteToken.getLexeme().equals("=")) {
            // Después del identificador en la tabla de símbolos viene un "="
            //System.out.println("Procesando asignación para el identificador ENTERO: " + token.getLexeme());
            //System.out.println("c");
            
             int siguienteTokenIndex = i + 2;
              boolean permitirNext = false;
            while (siguienteTokenIndex < tokens.size()) {
                Token siguienteTokenActual = tokens.get(siguienteTokenIndex);
 String identificadorDespuesIgual = siguienteTokenActual.getLexeme();
                if ( siguienteTokenActual.getType() == TokenType.COLON) {
                    
                    
                    // La asignación es válida
                  //  System.out.println("Asignación válida para " + token.getLexeme());
                    i = siguienteTokenIndex; // Saltar el punto y coma
               break;
                }else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR &&
            siguienteTokenActual.getLexeme().equals("sc") &&
            siguienteTokenIndex + 1 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 1).getType() == TokenType.PUNTO &&
            siguienteTokenIndex + 2 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 2).getType() == TokenType.IDENTIFICADOR &&
            tokens.get(siguienteTokenIndex + 2).getLexeme().equalsIgnoreCase("nextLine") &&
            siguienteTokenIndex + 3 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 3).getType() == TokenType.PARENTESIS_ABRE &&
            siguienteTokenIndex + 4 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 4).getType() == TokenType.PARENTESIS_CIERRA) {
        // Encontramos sc.nextDouble(), permitirlo en la siguiente iteración
        permitirNext = true;
      break;
                } else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR && tablaSimbolos.existeSimbolo(identificadorDespuesIgual) ||
                "CARACTER".equals(tablaSimbolos.getTipoSimbolo(identificadorDespuesIgual))||siguienteTokenActual.getType() == TokenType.CADENA) {
                           //   System.out.println("a");
                      
                               permitirNext = false;
                          
                        }else {
                            // Error si hay un token que no es de tipo entero después del '='
                            System.out.println("Error semántico 040 : Después del '=' deben ir identificadores y datos tipo Caracter. Línea: " + token.getLinea());
                           break;
                        }
                
                
         
                
                
               siguienteTokenIndex++;
                
            }
           
         
        
            
            
        }
        
        
        
       
    } else {
        // El identificador no es de tipo "ENTERO", puedes manejar este caso si es necesario
    }
    }

  
  }
  }
  
  
 
 

 public void analizarSemantica() {
    Tabla_Símbolos tablaSimbolos = new Tabla_Símbolos();
    boolean declaracionEncontrada = false;

    for (int i = 0; i < tokens.size(); i++) {
        Token token = tokens.get(i);

        if (token.getType() == TokenType.PALABRAS_RESERVADAS && token.getLexeme().equals("String")) {
            declaracionEncontrada = true;
        } else if (declaracionEncontrada && token.getType() == TokenType.IDENTIFICADOR) {
            
            
            String identificador = token.getLexeme();
            
            
            Token siguienteToken = tokens.get(i + 1);

            if (siguienteToken.getType() == TokenType.COLON) {
                  String tipoDatoActual = "STRING";
            tablaSimbolos.agregarSimbolo(identificador, tipoDatoActual);
          //  System.out.println("Se agregó a la tabla: " + identificador + " (" + tipoDatoActual + ")");
            declaracionEncontrada = false; // Restablecer para la próxima declaración
               
            }
         
        }
        else  
        if (tablaSimbolos.existeSimbolo(token.getLexeme()) && token.getType() == TokenType.IDENTIFICADOR) {
           String tipoIdentificador = tablaSimbolos.getTipoSimbolo(token.getLexeme());
    
    if ("STRING".equals(tipoIdentificador)) {
        Token siguienteToken = tokens.get(i + 1);
       

        if (siguienteToken.getType() == TokenType.OPERADORES_ARITMETICOS && siguienteToken.getLexeme().equals("=")) {
            // Después del identificador en la tabla de símbolos viene un "="
            //System.out.println("Procesando asignación para el identificador ENTERO: " + token.getLexeme());
            //System.out.println("c");
            
             int siguienteTokenIndex = i + 2;
              boolean permitirNext = false;
            while (siguienteTokenIndex < tokens.size()) {
                Token siguienteTokenActual = tokens.get(siguienteTokenIndex);
 String identificadorDespuesIgual = siguienteTokenActual.getLexeme();
                if (siguienteTokenActual.getType() == TokenType.COLON) {
                    
                    
                    // La asignación es válida
                 //   System.out.println("Asignación válida para " + token.getLexeme());
                    i = siguienteTokenIndex; // Saltar el punto y coma
               break;
                }else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR &&
            siguienteTokenActual.getLexeme().equals("sc") &&
            siguienteTokenIndex + 1 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 1).getType() == TokenType.PUNTO &&
            siguienteTokenIndex + 2 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 2).getType() == TokenType.IDENTIFICADOR &&
            tokens.get(siguienteTokenIndex + 2).getLexeme().equalsIgnoreCase("nextLine") &&
            siguienteTokenIndex + 3 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 3).getType() == TokenType.PARENTESIS_ABRE &&
            siguienteTokenIndex + 4 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 4).getType() == TokenType.PARENTESIS_CIERRA) {
        // Encontramos sc.nextDouble(), permitirlo en la siguiente iteración
        permitirNext = true;
      break;
                } else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR && tablaSimbolos.existeSimbolo(identificadorDespuesIgual) ||
                "STRING".equals(tablaSimbolos.getTipoSimbolo(identificadorDespuesIgual))||siguienteTokenActual.getType() == TokenType.CADENA) {
                           //   System.out.println("a");
                      
                               permitirNext = false;
                              
                         
                              
                        }else {
                            // Error si hay un token que no es de tipo entero después del '='
                            System.out.println("Error semántico: Después del '=' deben ir identificadores y datos tipo String. Línea: " + token.getLinea());
                           break;
                        }
                
                
         
                
                
               siguienteTokenIndex++;
                
            }
           
         
        
            
            
        }
        
        
        
       
    } else {
        // El identificador no es de tipo "ENTERO", puedes manejar este caso si es necesario
    }
    }

  
  }

 }


 
 
 public void  analizarsemantica3(){
 Tabla_Símbolos tablaSimbolos = new Tabla_Símbolos();
    boolean declaracionEncontrada = false;

    for (int i = 0; i < tokens.size(); i++) {
        Token token = tokens.get(i);

        if (token.getType() == TokenType.PALABRAS_RESERVADAS && token.getLexeme().equals("double")) {
            declaracionEncontrada = true;
        } else if (declaracionEncontrada && token.getType() == TokenType.IDENTIFICADOR) {
            
            
            String identificador = token.getLexeme();
            
            
            Token siguienteToken = tokens.get(i + 1);

            if (siguienteToken.getType() == TokenType.COLON) {
                  String tipoDatoActual = "DOUBLE";
            tablaSimbolos.agregarSimbolo(identificador, tipoDatoActual);
           // System.out.println("Se agregó a la tabla: " + identificador + " (" + tipoDatoActual + ")");
            declaracionEncontrada = false; // Restablecer para la próxima declaración
               
            }
         
        }
        else  
        if (tablaSimbolos.existeSimbolo(token.getLexeme()) && token.getType() == TokenType.IDENTIFICADOR) {
           String tipoIdentificador = tablaSimbolos.getTipoSimbolo(token.getLexeme());
    
    if ("DOUBLE".equals(tipoIdentificador)) {
        Token siguienteToken = tokens.get(i + 1);
       

        if (siguienteToken.getType() == TokenType.OPERADORES_ARITMETICOS && siguienteToken.getLexeme().equals("=")) {
            // Después del identificador en la tabla de símbolos viene un "="
            //System.out.println("Procesando asignación para el identificador ENTERO: " + token.getLexeme());
          // System.out.println("c");
            
             int siguienteTokenIndex = i + 2;
              boolean permitirNext = false;
            while (siguienteTokenIndex < tokens.size()) {
                Token siguienteTokenActual = tokens.get(siguienteTokenIndex);
 String identificadorDespuesIgual = siguienteTokenActual.getLexeme();
                if (siguienteTokenActual.getType() == TokenType.COLON) {
                    
                    
                    // La asignación es válida
                   // System.out.println("Asignación válida para " + token.getLexeme());
                    i = siguienteTokenIndex; // Saltar el punto y coma
               break;
                }else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR &&
            siguienteTokenActual.getLexeme().equals("sc") &&
            siguienteTokenIndex + 1 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 1).getType() == TokenType.PUNTO &&
            siguienteTokenIndex + 2 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 2).getType() == TokenType.IDENTIFICADOR &&
            tokens.get(siguienteTokenIndex + 2).getLexeme().equalsIgnoreCase("nextDouble") &&
            siguienteTokenIndex + 3 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 3).getType() == TokenType.PARENTESIS_ABRE &&
            siguienteTokenIndex + 4 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 4).getType() == TokenType.PARENTESIS_CIERRA) {
        // Encontramos sc.nextDouble(), permitirlo en la siguiente iteración
        permitirNext = true;
      break;
                } else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR && tablaSimbolos.existeSimbolo(identificadorDespuesIgual) ||
                "DOUBLE".equals(tablaSimbolos.getTipoSimbolo(identificadorDespuesIgual))||siguienteTokenActual.getType() == TokenType.ENTERO||siguienteTokenActual.getType() == TokenType.REAL||siguienteTokenActual.getType() == TokenType.ENTERO_NEGATIVO||siguienteTokenActual.getType() == TokenType.REAL_NEGATIVO||siguienteTokenActual.getType() == TokenType.OPERADORES_ARITMETICOS||siguienteTokenActual.getType() == TokenType.SHORT) {
                             // System.out.println("a");
                      
                               permitirNext = false;
                              
                         
                              
                        }else {
                            // Error si hay un token que no es de tipo entero después del '='
                            System.out.println("Error semántico: Después del '=' deben ir identificadores y datos tipo double. Línea: " + token.getLinea());
                           break;
                        }
                
                
         
                
                
               siguienteTokenIndex++;
                
            }
           
         
        
            
            
        }
        
        
        
       
    } else {
        // El identificador no es de tipo "ENTERO", puedes manejar este caso si es necesario
    }
    }

  
  }
 }
 
 
  public void  analizarsemantica4(){
Tabla_Símbolos tablaSimbolos = new Tabla_Símbolos();
    boolean declaracionEncontrada = false;

    for (int i = 0; i < tokens.size(); i++) {
        Token token = tokens.get(i);

        if (token.getType() == TokenType.PALABRAS_RESERVADAS && token.getLexeme().equals("byte")) {
            declaracionEncontrada = true;
        } else if (declaracionEncontrada && token.getType() == TokenType.IDENTIFICADOR) {
            
            
            String identificador = token.getLexeme();
            
            
            Token siguienteToken = tokens.get(i + 1);

            if (siguienteToken.getType() == TokenType.COLON) {
                  String tipoDatoActual = "BYTE";
            tablaSimbolos.agregarSimbolo(identificador, tipoDatoActual);
           // System.out.println("Se agregó a la tabla: " + identificador + " (" + tipoDatoActual + ")");
            declaracionEncontrada = false; // Restablecer para la próxima declaración
               
            }
         
        }
        else  
        if (tablaSimbolos.existeSimbolo(token.getLexeme()) && token.getType() == TokenType.IDENTIFICADOR) {
           String tipoIdentificador = tablaSimbolos.getTipoSimbolo(token.getLexeme());
    
    if ("BYTE".equals(tipoIdentificador)) {
        Token siguienteToken = tokens.get(i + 1);
       

        if (siguienteToken.getType() == TokenType.OPERADORES_ARITMETICOS && siguienteToken.getLexeme().equals("=")) {
            // Después del identificador en la tabla de símbolos viene un "="
            //System.out.println("Procesando asignación para el identificador ENTERO: " + token.getLexeme());
        
            
             int siguienteTokenIndex = i + 2;
              boolean permitirNext = false;
            while (siguienteTokenIndex < tokens.size()) {
                Token siguienteTokenActual = tokens.get(siguienteTokenIndex);
 String identificadorDespuesIgual = siguienteTokenActual.getLexeme();
                if (siguienteTokenActual.getType() == TokenType.COLON) {
                    
                    
                    // La asignación es válida
                  //  System.out.println("Asignación válida para " + token.getLexeme());
                    i = siguienteTokenIndex; // Saltar el punto y coma
               break;
                }else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR &&
            siguienteTokenActual.getLexeme().equals("sc") &&
            siguienteTokenIndex + 1 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 1).getType() == TokenType.PUNTO &&
            siguienteTokenIndex + 2 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 2).getType() == TokenType.IDENTIFICADOR &&
            tokens.get(siguienteTokenIndex + 2).getLexeme().equalsIgnoreCase("nextByte") &&
            siguienteTokenIndex + 3 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 3).getType() == TokenType.PARENTESIS_ABRE &&
            siguienteTokenIndex + 4 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 4).getType() == TokenType.PARENTESIS_CIERRA) {
        // Encontramos sc.nextDouble(), permitirlo en la siguiente iteración
        permitirNext = true;
      break;
                } else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR && tablaSimbolos.existeSimbolo(identificadorDespuesIgual) ||
                "BYTE".equals(tablaSimbolos.getTipoSimbolo(identificadorDespuesIgual))||siguienteTokenActual.getType() == TokenType.ENTERO||siguienteTokenActual.getType() == TokenType.OPERADORES_ARITMETICOS||siguienteTokenActual.getType() == TokenType.SHORT||siguienteTokenActual.getType() == TokenType.ENTERO_NEGATIVO) {
                             
                      
                               permitirNext = false;
                              
                         
                              
                        }else {
                            // Error si hay un token que no es de tipo entero después del '='
                            System.out.println("Error semántico: Después del '=' deben ir identificadores y datos tipo byte. Línea: " + token.getLinea());
                           break;
                        }
                
                
         
                
                
               siguienteTokenIndex++;
                
            }
           
         
        
            
            
        }
        
        
        
       
    } else {
        // El identificador no es de tipo "ENTERO", puedes manejar este caso si es necesario
    }
    }

  
  }
 }
  
    public void  analizarsemantica5(){
Tabla_Símbolos tablaSimbolos = new Tabla_Símbolos();
    boolean declaracionEncontrada = false;

    for (int i = 0; i < tokens.size(); i++) {
        Token token = tokens.get(i);

        if (token.getType() == TokenType.PALABRAS_RESERVADAS && token.getLexeme().equals("long")) {
            declaracionEncontrada = true;
        } else if (declaracionEncontrada && token.getType() == TokenType.IDENTIFICADOR) {
            
            
            String identificador = token.getLexeme();
            
            
            Token siguienteToken = tokens.get(i + 1);

            if (siguienteToken.getType() == TokenType.COLON) {
                  String tipoDatoActual = "LONG";
            tablaSimbolos.agregarSimbolo(identificador, tipoDatoActual);
           // System.out.println("Se agregó a la tabla: " + identificador + " (" + tipoDatoActual + ")");
            declaracionEncontrada = false; // Restablecer para la próxima declaración
               
            }
         
        }
        else  
        if (tablaSimbolos.existeSimbolo(token.getLexeme()) && token.getType() == TokenType.IDENTIFICADOR) {
           String tipoIdentificador = tablaSimbolos.getTipoSimbolo(token.getLexeme());
    
    if ("LONG".equals(tipoIdentificador)) {
        Token siguienteToken = tokens.get(i + 1);
       

        if (siguienteToken.getType() == TokenType.OPERADORES_ARITMETICOS && siguienteToken.getLexeme().equals("=")) {
            // Después del identificador en la tabla de símbolos viene un "="
            //System.out.println("Procesando asignación para el identificador ENTERO: " + token.getLexeme());
         //   System.out.println("c");
            
             int siguienteTokenIndex = i + 2;
              boolean permitirNext = false;
            while (siguienteTokenIndex < tokens.size()) {
                Token siguienteTokenActual = tokens.get(siguienteTokenIndex);
 String identificadorDespuesIgual = siguienteTokenActual.getLexeme();
                if (siguienteTokenActual.getType() == TokenType.COLON) {
                    
                    
                    // La asignación es válida
                   // System.out.println("Asignación válida para " + token.getLexeme());
                    i = siguienteTokenIndex; // Saltar el punto y coma
               break;
                }else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR &&
            siguienteTokenActual.getLexeme().equals("sc") &&
            siguienteTokenIndex + 1 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 1).getType() == TokenType.PUNTO &&
            siguienteTokenIndex + 2 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 2).getType() == TokenType.IDENTIFICADOR &&
            tokens.get(siguienteTokenIndex + 2).getLexeme().equalsIgnoreCase("nextLong") &&
            siguienteTokenIndex + 3 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 3).getType() == TokenType.PARENTESIS_ABRE &&
            siguienteTokenIndex + 4 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 4).getType() == TokenType.PARENTESIS_CIERRA) {
        // Encontramos sc.nextDouble(), permitirlo en la siguiente iteración
        permitirNext = true;
      break;
                } else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR && tablaSimbolos.existeSimbolo(identificadorDespuesIgual) ||
                "LONG".equals(tablaSimbolos.getTipoSimbolo(identificadorDespuesIgual))||siguienteTokenActual.getType() == TokenType.ENTERO||siguienteTokenActual.getType() == TokenType.OPERADORES_ARITMETICOS) {
                             
                      
                               permitirNext = false;
                              
                         
                              
                        }else {
                            // Error si hay un token que no es de tipo entero después del '='
                            System.out.println("Error semántico: Después del '=' deben ir identificadores y datos tipo Long. Línea: " + token.getLinea());
                           break;
                        }
                
                
         
                
                
               siguienteTokenIndex++;
                
            }
           
         
        
            
            
        }
        
        
        
       
    } else {
        // El identificador no es de tipo "ENTERO", puedes manejar este caso si es necesario
    }
    }

  
  }
 }
    
    
      public void  analizarsemantica6(){
Tabla_Símbolos tablaSimbolos = new Tabla_Símbolos();
    boolean declaracionEncontrada = false;

    for (int i = 0; i < tokens.size(); i++) {
        Token token = tokens.get(i);

        if (token.getType() == TokenType.PALABRAS_RESERVADAS && token.getLexeme().equals("float")) {
            declaracionEncontrada = true;
        } else if (declaracionEncontrada && token.getType() == TokenType.IDENTIFICADOR) {
            
            
            String identificador = token.getLexeme();
            
            
            Token siguienteToken = tokens.get(i + 1);

            if (siguienteToken.getType() == TokenType.COLON) {
                  String tipoDatoActual = "FLOAT";
            tablaSimbolos.agregarSimbolo(identificador, tipoDatoActual);
           // System.out.println("Se agregó a la tabla: " + identificador + " (" + tipoDatoActual + ")");
            declaracionEncontrada = false; // Restablecer para la próxima declaración
               
            }
         
        }
        else  
        if (tablaSimbolos.existeSimbolo(token.getLexeme()) && token.getType() == TokenType.IDENTIFICADOR) {
           String tipoIdentificador = tablaSimbolos.getTipoSimbolo(token.getLexeme());
    
    if ("FLOAT".equals(tipoIdentificador)) {
        Token siguienteToken = tokens.get(i + 1);
       

        if (siguienteToken.getType() == TokenType.OPERADORES_ARITMETICOS && siguienteToken.getLexeme().equals("=")) {
            // Después del identificador en la tabla de símbolos viene un "="
            //System.out.println("Procesando asignación para el identificador ENTERO: " + token.getLexeme());
         //   System.out.println("c");
            
             int siguienteTokenIndex = i + 2;
              boolean permitirNext = false;
            while (siguienteTokenIndex < tokens.size()) {
                Token siguienteTokenActual = tokens.get(siguienteTokenIndex);
 String identificadorDespuesIgual = siguienteTokenActual.getLexeme();
                if (siguienteTokenActual.getType() == TokenType.COLON) {
                    
                    
                    // La asignación es válida
                  //  System.out.println("Asignación válida para " + token.getLexeme());
                    i = siguienteTokenIndex; // Saltar el punto y coma
               break;
                }else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR &&
            siguienteTokenActual.getLexeme().equals("sc") &&
            siguienteTokenIndex + 1 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 1).getType() == TokenType.PUNTO &&
            siguienteTokenIndex + 2 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 2).getType() == TokenType.IDENTIFICADOR &&
            tokens.get(siguienteTokenIndex + 2).getLexeme().equalsIgnoreCase("nextFloat") &&
            siguienteTokenIndex + 3 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 3).getType() == TokenType.PARENTESIS_ABRE &&
            siguienteTokenIndex + 4 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 4).getType() == TokenType.PARENTESIS_CIERRA) {
        // Encontramos sc.nextDouble(), permitirlo en la siguiente iteración
        permitirNext = true;
      break;
                } else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR && tablaSimbolos.existeSimbolo(identificadorDespuesIgual) ||
                "FLOAT".equals(tablaSimbolos.getTipoSimbolo(identificadorDespuesIgual))||siguienteTokenActual.getType() == TokenType.ENTERO||siguienteTokenActual.getType() == TokenType.OPERADORES_ARITMETICOS||siguienteTokenActual.getType() == TokenType.ENTERO_NEGATIVO||siguienteTokenActual.getType() == TokenType.REAL||siguienteTokenActual.getType() == TokenType.REAL_NEGATIVO||siguienteTokenActual.getType() == TokenType.SHORT) {
                             
                      
                               permitirNext = false;
                              
                         
                              
                        }else {
                            // Error si hay un token que no es de tipo entero después del '='
                            System.out.println("Error semántico: Después del '=' deben ir identificadores y datos tipo float. Línea: " + token.getLinea());
                           break;
                        }
                
                
         
                
                
               siguienteTokenIndex++;
                
            }
           
         
        
            
            
        }
        
        
        
       
    } else {
        // El identificador no es de tipo "ENTERO", puedes manejar este caso si es necesario
    }
    }

  
  }
 }
      
       
      public void analizarsemantica7(){
Tabla_Símbolos tablaSimbolos = new Tabla_Símbolos();
    boolean declaracionEncontrada = false;

    for (int i = 0; i < tokens.size(); i++) {
        Token token = tokens.get(i);

        if (token.getType() == TokenType.PALABRAS_RESERVADAS && token.getLexeme().equals("boolean")) {
            declaracionEncontrada = true;
        } else if (declaracionEncontrada && token.getType() == TokenType.IDENTIFICADOR) {
            
            
            String identificador = token.getLexeme();
            
            
            Token siguienteToken = tokens.get(i + 1);

            if (siguienteToken.getType() == TokenType.COLON) {
                  String tipoDatoActual = "BOOL";
            tablaSimbolos.agregarSimbolo(identificador, tipoDatoActual);
           // System.out.println("Se agregó a la tabla: " + identificador + " (" + tipoDatoActual + ")");
            declaracionEncontrada = false; // Restablecer para la próxima declaración
               
            }
         
        }
        else  
        if (tablaSimbolos.existeSimbolo(token.getLexeme()) && token.getType() == TokenType.IDENTIFICADOR) {
           String tipoIdentificador = tablaSimbolos.getTipoSimbolo(token.getLexeme());
    
    if ("BOOL".equals(tipoIdentificador)) {
        Token siguienteToken = tokens.get(i + 1);
       

        if (siguienteToken.getType() == TokenType.OPERADORES_ARITMETICOS && siguienteToken.getLexeme().equals("=")) {
            // Después del identificador en la tabla de símbolos viene un "="
            //System.out.println("Procesando asignación para el identificador ENTERO: " + token.getLexeme());
         //   System.out.println("c");
            
             int siguienteTokenIndex = i + 2;
              boolean permitirNext = false;
            while (siguienteTokenIndex < tokens.size()) {
                Token siguienteTokenActual = tokens.get(siguienteTokenIndex);
 String identificadorDespuesIgual = siguienteTokenActual.getLexeme();
                if (siguienteTokenActual.getType() == TokenType.COLON) {
                    
                    
                    // La asignación es válida
                  //  System.out.println("Asignación válida para " + token.getLexeme());
                    i = siguienteTokenIndex; // Saltar el punto y coma
               break;
                }else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR &&
            siguienteTokenActual.getLexeme().equals("sc") &&
            siguienteTokenIndex + 1 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 1).getType() == TokenType.PUNTO &&
            siguienteTokenIndex + 2 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 2).getType() == TokenType.IDENTIFICADOR &&
            tokens.get(siguienteTokenIndex + 2).getLexeme().equalsIgnoreCase("nextBoolean") &&
            siguienteTokenIndex + 3 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 3).getType() == TokenType.PARENTESIS_ABRE &&
            siguienteTokenIndex + 4 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 4).getType() == TokenType.PARENTESIS_CIERRA) {
        // Encontramos sc.nextDouble(), permitirlo en la siguiente iteración
        permitirNext = true;
      break;
                } else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR && tablaSimbolos.existeSimbolo(identificadorDespuesIgual) ||
                "BOOL".equals(tablaSimbolos.getTipoSimbolo(identificadorDespuesIgual))||siguienteTokenActual.getType() == TokenType.PALABRAS_RESERVADAS && siguienteTokenActual.getLexeme().equals("true")||siguienteTokenActual.getLexeme().equals("false")) {
                             
                      
                               permitirNext = false;
                              
                         
                              
                        }else {
                            // Error si hay un token que no es de tipo entero después del '='
                            System.out.println("Error semántico: Después del '=' deben ir identificadores y datos tipo boolean. Línea: " + token.getLinea());
                           break;
                        }
                
                
         
                
                
               siguienteTokenIndex++;
                
            }
           
         
        
            
            
        }
        
        
        
       
    } else {
        // El identificador no es de tipo "ENTERO", puedes manejar este caso si es necesario
    }
    }

  
  }
 }
      
         public void  analizarsemantica8(){
Tabla_Símbolos tablaSimbolos = new Tabla_Símbolos();
    boolean declaracionEncontrada = false;

    for (int i = 0; i < tokens.size(); i++) {
        Token token = tokens.get(i);

        if (token.getType() == TokenType.PALABRAS_RESERVADAS && token.getLexeme().equals("short")) {
            declaracionEncontrada = true;
        } else if (declaracionEncontrada && token.getType() == TokenType.IDENTIFICADOR) {
            
            
            String identificador = token.getLexeme();
            
            
            Token siguienteToken = tokens.get(i + 1);

            if (siguienteToken.getType() == TokenType.COLON) {
                  String tipoDatoActual = "SHORT";
            tablaSimbolos.agregarSimbolo(identificador, tipoDatoActual);
           // System.out.println("Se agregó a la tabla: " + identificador + " (" + tipoDatoActual + ")");
            declaracionEncontrada = false; // Restablecer para la próxima declaración
               
            }
         
        }
        else  
        if (tablaSimbolos.existeSimbolo(token.getLexeme()) && token.getType() == TokenType.IDENTIFICADOR) {
           String tipoIdentificador = tablaSimbolos.getTipoSimbolo(token.getLexeme());
    
    if ("SHORT".equals(tipoIdentificador)) {
        Token siguienteToken = tokens.get(i + 1);
       

        if (siguienteToken.getType() == TokenType.OPERADORES_ARITMETICOS && siguienteToken.getLexeme().equals("=")) {
            // Después del identificador en la tabla de símbolos viene un "="
            //System.out.println("Procesando asignación para el identificador ENTERO: " + token.getLexeme());
         //   System.out.println("c");
            
             int siguienteTokenIndex = i + 2;
              boolean permitirNext = false;
            while (siguienteTokenIndex < tokens.size()) {
                Token siguienteTokenActual = tokens.get(siguienteTokenIndex);
 String identificadorDespuesIgual = siguienteTokenActual.getLexeme();
                if (siguienteTokenActual.getType() == TokenType.COLON) {
                    
                    
                    // La asignación es válida
                 //   System.out.println("Asignación válida para " + token.getLexeme());
                    i = siguienteTokenIndex; // Saltar el punto y coma
               break;
                }else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR &&
            siguienteTokenActual.getLexeme().equals("sc") &&
            siguienteTokenIndex + 1 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 1).getType() == TokenType.PUNTO &&
            siguienteTokenIndex + 2 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 2).getType() == TokenType.IDENTIFICADOR &&
            tokens.get(siguienteTokenIndex + 2).getLexeme().equalsIgnoreCase("nextShort") &&
            siguienteTokenIndex + 3 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 3).getType() == TokenType.PARENTESIS_ABRE &&
            siguienteTokenIndex + 4 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 4).getType() == TokenType.PARENTESIS_CIERRA) {
        // Encontramos sc.nextDouble(), permitirlo en la siguiente iteración
        permitirNext = true;
      break;
                } else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR && tablaSimbolos.existeSimbolo(identificadorDespuesIgual) ||
                "SHORT".equals(tablaSimbolos.getTipoSimbolo(identificadorDespuesIgual))||siguienteTokenActual.getType() == TokenType.ENTERO ||siguienteTokenActual.getType() == TokenType.ENTERO_NEGATIVO||siguienteTokenActual.getType() == TokenType.SHORT ) {
                             
                      
                               permitirNext = false;
                              
                         
                              
                        }else {
                            // Error si hay un token que no es de tipo entero después del '='
                            System.out.println("Error semántico: Después del '=' deben ir identificadores y datos tipo Short. Línea: " + token.getLinea());
                           break;
                        }
                
                
         
                
                
               siguienteTokenIndex++;
                
            }
           
         
        
            
            
        }
        
        
        
       
    } else {
        // El identificador no es de tipo "ENTERO", puedes manejar este caso si es necesario
    }
    }

  
  }
 }
         
         
          public void semanticaiguales2(){
             
           Tabla_Símbolos tablaSimbolos = new Tabla_Símbolos();
boolean declaracionEncontrada = false;
String tipoDatoActual = "";

for (int i = 0; i < tokens.size(); i++) {
    
    Token token = tokens.get(i);
    
       System.out.println("Token actual: " + tokens.get(i).getLexeme());
    
    

    if (token.getType() == TokenType.PALABRAS_RESERVADAS) {
        declaracionEncontrada = true;

      tipoDatoActual = obtenerTipoDato(token);
    
    } else if (declaracionEncontrada && token.getType() == TokenType.IDENTIFICADOR) {
    
     
        
        String identificador = token.getLexeme();
           
            
         Token siguienteToken = i + 1 < tokens.size() ? tokens.get(i + 1) : null;
            
                  if (tablaSimbolos.existeSimboloConTipoDiferente(identificador)) {
         tablaSimbolos.agregarSimbolo(identificador, tipoDatoActual);
            System.out.println("error");
         // Salir del método si hay un error
        return;
    }

       

        if (siguienteToken != null && siguienteToken.getType() == TokenType.COLON) {
  // Lógica para el tipo de dato y la adición a la tabla de símbolos
             tablaSimbolos.agregarSimbolo(identificador, tipoDatoActual);
            System.out.println("Se agregó a la tabla: " + identificador + " (" + tipoDatoActual + ")");
            declaracionEncontrada = false;
          
           // Restablecer para la próxima declaración
            
        }
        
        
      
          System.out.println("Identificador existente: " + token.getLexeme());
         
        
    
        
      
    }
    
      
    
    
    
    
         
        
            
            
             

        
}

for (int i = 0; i < tokens.size(); i++) {
    Token token = tokens.get(i);

    if (tablaSimbolos.existeSimbolo(token.getLexeme()) && token.getType() == TokenType.IDENTIFICADOR)
        {
             Token siguienteToken = tokens.get(i + 1);

        // Verificar que el siguiente token sea un operador de asignación
        
        if (siguienteToken.getType() == TokenType.OPERADORES_ARITMETICOS && siguienteToken.getLexeme().equals("=") ) {
            
            
            
            System.out.println("Identificador existente: " + token.getLexeme());
            System.out.println("a");
            
            
            
            
             String tipoDato = tablaSimbolos.getTipoSimbolo(token.getLexeme());
             int siguienteTokenIndex = i + 2;
    boolean permitirNextDouble = false;
    
    
    switch (tipoDato){
        case "BOOL": 
            
             while (siguienteTokenIndex < tokens.size()) {
    Token siguienteTokenActual = tokens.get(siguienteTokenIndex);

    if (permitirNextDouble && siguienteTokenActual.getType() == TokenType.COLON) {
        // La asignación es válida
        System.out.println("Asignación válida para " + token.getLexeme());
        i = siguienteTokenIndex; // Saltar el punto y coma
        break;
    } else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR &&
            siguienteTokenActual.getLexeme().equals("sc") &&
            siguienteTokenIndex + 1 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 1).getType() == TokenType.PUNTO &&
            siguienteTokenIndex + 2 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 2).getType() == TokenType.IDENTIFICADOR &&
            tokens.get(siguienteTokenIndex + 2).getLexeme().equalsIgnoreCase("nextBoolean") &&
            siguienteTokenIndex + 3 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 3).getType() == TokenType.PARENTESIS_ABRE &&
            siguienteTokenIndex + 4 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 4).getType() == TokenType.PARENTESIS_CIERRA) {
        // Encontramos sc.nextDouble(), permitirlo en la siguiente iteración
        permitirNextDouble = true;
        break; // Detener la búsqueda
    } else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR) {
        // Verificar si el identificador está en la tabla y es de tipo double
        String identificadorDespuesIgual = siguienteTokenActual.getLexeme();
        if (!tablaSimbolos.existeSimbolo(identificadorDespuesIgual) ||
                !tablaSimbolos.getTipoSimbolo(identificadorDespuesIgual).equals("BOOL")) {
            System.out.println("Error semantico 050 luego del = deben ir identificadores y datos tipo boolean. Línea: " + token.getLinea());
           break;
        }
    } else if (siguienteTokenActual.getType() == TokenType.COLON || siguienteTokenActual.getType() == TokenType.PALABRAS_RESERVADAS && siguienteTokenActual.getLexeme().equals("true")|| siguienteTokenActual.getLexeme().equals("false") ) {
       
        permitirNextDouble = false;
    } else {
        System.out.println("Error: Tipos de dato no compatible con la asignación. Línea: " + token.getLinea());
        return; // Salir del método si hay un error
    }

    siguienteTokenIndex++;
}

    if (siguienteTokenIndex < tokens.size() &&
            tokens.get(siguienteTokenIndex).getType() == TokenType.COLON) {
        // La asignación es válida
        System.out.println("Asignación válida para " + token.getLexeme());
        i = siguienteTokenIndex; // Saltar el punto y coma
    } else {
        
    }
           
           
               case "SHORT": 
                   
                      while (siguienteTokenIndex < tokens.size()) {
    Token siguienteTokenActual = tokens.get(siguienteTokenIndex);

    if (permitirNextDouble && siguienteTokenActual.getType() == TokenType.COLON) {
        // La asignación es válida
        System.out.println("Asignación válida para " + token.getLexeme());
        i = siguienteTokenIndex; // Saltar el punto y coma
        break;
    } else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR &&
            siguienteTokenActual.getLexeme().equals("sc") &&
            siguienteTokenIndex + 1 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 1).getType() == TokenType.PUNTO &&
            siguienteTokenIndex + 2 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 2).getType() == TokenType.IDENTIFICADOR &&
            tokens.get(siguienteTokenIndex + 2).getLexeme().equalsIgnoreCase("nextShort") &&
            siguienteTokenIndex + 3 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 3).getType() == TokenType.PARENTESIS_ABRE &&
            siguienteTokenIndex + 4 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 4).getType() == TokenType.PARENTESIS_CIERRA) {
        // Encontramos sc.nextDouble(), permitirlo en la siguiente iteración
        permitirNextDouble = true;
        break; // Detener la búsqueda
    } else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR) {
        // Verificar si el identificador está en la tabla y es de tipo double
        String identificadorDespuesIgual = siguienteTokenActual.getLexeme();
        if (!tablaSimbolos.existeSimbolo(identificadorDespuesIgual) ||
                !tablaSimbolos.getTipoSimbolo(identificadorDespuesIgual).equals("SHORT")) {
            System.out.println("Error semantico 050 luego del = deben ir identificadores y datos tipo Short. Línea: " + token.getLinea());
            break;
           
        }
    } else if (siguienteTokenActual.getType() == TokenType.OPERADORES_ARITMETICOS ||siguienteTokenActual.getType() == TokenType.ENTERO||siguienteTokenActual.getType() == TokenType.ENTERO_NEGATIVO||siguienteTokenActual.getType() == TokenType.IDENTIFICADOR||siguienteTokenActual.getType()==TokenType.COLON) {
       
        permitirNextDouble = false;
    } else {
       System.out.println("error valores luego del = no permitidos"+token.getLinea());
      // Salir del método si hay un error
    }

    siguienteTokenIndex++;
}

    if (siguienteTokenIndex < tokens.size() &&
            tokens.get(siguienteTokenIndex).getType() == TokenType.COLON) {
        // La asignación es válida
        System.out.println("Asignación válida para " + token.getLexeme());
        i = siguienteTokenIndex; // Saltar el punto y coma
    } else {
        
    }
                   
                   
                   
    
    }
             
             switch (tipoDato) {
                 case"default":
                     break;
                    
                case "SHORT":
                 


                    
                    
                   
         
            }
             
             
             switch (tipoDato){
             case"default":
                     break;
              case "DOUBLE":
                  
                   while (siguienteTokenIndex < tokens.size()) {
    Token siguienteTokenActual = tokens.get(siguienteTokenIndex);

    if (permitirNextDouble && siguienteTokenActual.getType() == TokenType.COLON) {
        // La asignación es válida
        System.out.println("Asignación válida para " + token.getLexeme());
        i = siguienteTokenIndex; // Saltar el punto y coma
        break;
    } else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR &&
            siguienteTokenActual.getLexeme().equals("sc") &&
            siguienteTokenIndex + 1 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 1).getType() == TokenType.PUNTO &&
            siguienteTokenIndex + 2 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 2).getType() == TokenType.IDENTIFICADOR &&
            tokens.get(siguienteTokenIndex + 2).getLexeme().equalsIgnoreCase("nextDouble") &&
            siguienteTokenIndex + 3 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 3).getType() == TokenType.PARENTESIS_ABRE &&
            siguienteTokenIndex + 4 < tokens.size() &&
            tokens.get(siguienteTokenIndex + 4).getType() == TokenType.PARENTESIS_CIERRA) {
        // Encontramos sc.nextDouble(), permitirlo en la siguiente iteración
        permitirNextDouble = true;
        break; // Detener la búsqueda
    } else if (siguienteTokenActual.getType() == TokenType.IDENTIFICADOR) {
        // Verificar si el identificador está en la tabla y es de tipo double
        String identificadorDespuesIgual = siguienteTokenActual.getLexeme();
        if (!tablaSimbolos.existeSimbolo(identificadorDespuesIgual) ||
                !tablaSimbolos.getTipoSimbolo(identificadorDespuesIgual).equals("DOUBLE")) {
            System.out.println("Error semantico 050 luego del = deben ir identificadores y datos tipo double. Línea: " + token.getLinea());
           break;
        }
    } else if (siguienteTokenActual.getType() == TokenType.OPERADORES_ARITMETICOS ||siguienteTokenActual.getType() == TokenType.ENTERO||siguienteTokenActual.getType() == TokenType.REAL||siguienteTokenActual.getType() == TokenType.COLON||siguienteTokenActual.getType() == TokenType.PARENTESIS_ABRE||siguienteTokenActual.getType() == TokenType.PARENTESIS_CIERRA) {
       
        permitirNextDouble = false;
    } else {
       
        return; // Salir del método si hay un error
    }

    siguienteTokenIndex++;
}

    if (siguienteTokenIndex < tokens.size() &&
            tokens.get(siguienteTokenIndex).getType() == TokenType.COLON) {
        // La asignación es válida
        System.out.println("Asignación válida para " + token.getLexeme());
        i = siguienteTokenIndex; // Saltar el punto y coma
    } else {
        
    }
                  
                  
             break;
             }
            
            
 if (tablaSimbolos.getTipoSimbolo(token.getLexeme()).equals("DOUBLE")) {
    // Verificar que después del '=' solo hayan identificadores de tipo double o sc.nextDouble();
  

  
}
    }
         
         
         
         }
          }
          }

          
         
         
         
         
         public void semanticaiguales(){
             
           Tabla_Símbolos tablaSimbolos = new Tabla_Símbolos();
boolean declaracionEncontrada = false;
String tipoDatoActual = "";

for (int i = 0; i < tokens.size(); i++) {
    Token token = tokens.get(i);

    if (token.getType() == TokenType.PALABRAS_RESERVADAS) {
        

      tipoDatoActual = obtenerTipoDato(token);
    declaracionEncontrada = true;
    } else if (declaracionEncontrada && token.getType() == TokenType.IDENTIFICADOR) {
    
     
        
        String identificador = token.getLexeme();
           
            
         Token siguienteToken = i + 1 < tokens.size() ? tokens.get(i + 1) : null;
            
                  if (tablaSimbolos.existeSimboloConTipoDiferente(identificador)) {
         tablaSimbolos.agregarSimbolo(identificador, tipoDatoActual);
            System.out.println("error Semantico 039 la variable ya está asignada ");
         // Salir del método si hay un error
        return;
    }

       

        if (siguienteToken != null && siguienteToken.getType() == TokenType.COLON) {
  // Lógica para el tipo de dato y la adición a la tabla de símbolos
             tablaSimbolos.agregarSimbolo(identificador, tipoDatoActual);
           // System.out.println("Se agregó a la tabla: " + identificador + " (" + tipoDatoActual + ")");
            declaracionEncontrada = false;
           // Restablecer para la próxima declaración
     
        }
    } 
}


         
         
         
         }
         
                 public class semanticaint2{
    public boolean validacion(List<Token> tokens, List<String> errores) {
        
           Tabla_Símbolos tablaSimbolos = new Tabla_Símbolos();
boolean declaracionEncontrada = false;
String tipoDatoActual = "";

for (int i = 0; i < tokens.size(); i++) {
    Token token = tokens.get(i);

    if (token.getType() == TokenType.PALABRAS_RESERVADAS && token.getLexeme().equals("int")) {
        

      tipoDatoActual = obtenerTipoDato(token);
    declaracionEncontrada = true;
    } else if (declaracionEncontrada && token.getType() == TokenType.IDENTIFICADOR) {
    
     
        
        String identificador = token.getLexeme();
           
            
         Token siguienteToken = i + 1 < tokens.size() ? tokens.get(i + 1) : null;
            
                  if (tablaSimbolos.existeSimboloConTipoDiferente(identificador)) {
         tablaSimbolos.agregarSimbolo(identificador, tipoDatoActual);
            System.out.println("error");
         // Salir del método si hay un error
        return true;
    }

       

        if (siguienteToken != null && siguienteToken.getType() == TokenType.COLON) {
  // Lógica para el tipo de dato y la adición a la tabla de símbolos
             tablaSimbolos.agregarSimbolo(identificador, tipoDatoActual);
            System.out.println("Se agregó a la tabla: " + identificador + " (" + tipoDatoActual + ")");
            declaracionEncontrada = false;
           // Restablecer para la próxima declaración
     
        }
    }else if (tablaSimbolos.existeSimbolo(token.getLexeme()) && token.getType() == TokenType.IDENTIFICADOR) {
            Token siguienteToken = tokens.get(i + 1);

            if (siguienteToken.getType() == TokenType.OPERADORES_ARITMETICOS && siguienteToken.getLexeme().equals("=")) {
                
                 Token siguienteToken2 = tokens.get(i + 2);
                 
                 if (siguienteToken2.getType() == TokenType.IDENTIFICADOR && siguienteToken2.getLexeme().equals("sc")) {
                      Token siguienteToken3 = tokens.get(i + 3);
                        if (siguienteToken3.getType() == TokenType.PUNTO) {
                      Token siguienteToken4 = tokens.get(i + 4);
                      
                       if (siguienteToken4.getType() == TokenType.IDENTIFICADOR && siguienteToken4.getLexeme().equals("nextInt")) {
                      Token siguienteToken5 = tokens.get(i + 5); 
                         if (siguienteToken5.getType() == TokenType.PARENTESIS_ABRE ) {
                      Token siguienteToken6 = tokens.get(i + 6); 
                             if (siguienteToken6.getType() == TokenType.PARENTESIS_CIERRA ) {
                      Token siguienteToken7 = tokens.get(i + 7); 
                      
                               if (siguienteToken7.getType() == TokenType.COLON ) {
                     
                      
                      
                 }else{errores.add("falta punto y coma linea "+siguienteToken7.getLinea());}
                      
                 }else{errores.add("falta parétesis de cierre "+siguienteToken6.getLinea());}
                      
                      
                 }else{errores.add("falta parétesis de apertura "+siguienteToken5.getLinea());}
                      
                 }else{errores.add("falta identificador "+siguienteToken4.getLinea());}
                        }else{errores.add("falta punto "+siguienteToken3.getLinea());} 
                    
               
}
                 if (tablaSimbolos.getTipoSimbolo(token.getLexeme()).equals("ENTERO")) {
                 
                 
                 }
      }
         
}
        
        
     
    }
   
      return errores.isEmpty();
    }
    
                 
                 }        
         
         public  void semanticaint(){
             
              Tabla_Símbolos tablaSimbolos = new Tabla_Símbolos();
boolean declaracionEncontrada = false;
String tipoDatoActual = "";

for (int i = 0; i < tokens.size(); i++) {
    Token token = tokens.get(i);

    if (token.getType() == TokenType.PALABRAS_RESERVADAS && token.getLexeme().equals("int")) {
        

      tipoDatoActual = obtenerTipoDato(token);
    declaracionEncontrada = true;
    } else if (declaracionEncontrada && token.getType() == TokenType.IDENTIFICADOR) {
    
     
        
        String identificador = token.getLexeme();
           
            
         Token siguienteToken = i + 1 < tokens.size() ? tokens.get(i + 1) : null;
            
                  if (tablaSimbolos.existeSimboloConTipoDiferente(identificador)) {
         tablaSimbolos.agregarSimbolo(identificador, tipoDatoActual);
            System.out.println("error");
         // Salir del método si hay un error
        return;
    }

       

        if (siguienteToken != null && siguienteToken.getType() == TokenType.COLON) {
  // Lógica para el tipo de dato y la adición a la tabla de símbolos
             tablaSimbolos.agregarSimbolo(identificador, tipoDatoActual);
            System.out.println("Se agregó a la tabla: " + identificador + " (" + tipoDatoActual + ")");
            declaracionEncontrada = false;
           // Restablecer para la próxima declaración
     
        }
    }else if (tablaSimbolos.existeSimbolo(token.getLexeme()) && token.getType() == TokenType.IDENTIFICADOR) {
            Token siguienteToken = tokens.get(i + 1);

            if (siguienteToken.getType() == TokenType.OPERADORES_ARITMETICOS && siguienteToken.getLexeme().equals("=")) {
               // Después del identificador en la tabla de símbolos viene un "="
}
          
      }
         
}
         }
     private String obtenerTipoDato(Token token) {
      if (token.getLexeme().equals("boolean")) {
        return "BOOL";
    } else if (token.getLexeme().equals("double")) {
        return "DOUBLE";
    } else if (token.getLexeme().equals("short")) {
        return "SHORT";
    } else if (token.getLexeme().equals("long")) {
        return "LONG";
    } else if (token.getLexeme().equals("char")) {
        return "CARACTER";
    } else if (token.getLexeme().equals("byte")) {
        return "BYTE";
    } else if (token.getLexeme().equals("float")) {
        return "FLOAT";
    } else if (token.getLexeme().equals("int")) {
        return "ENTERO";
    } else if (token.getLexeme().equals("String")) {
        return "STRING";
    } 

    return "";
}

private String obtenerTipoDatoPalabraReservada(String palabraReservada) {
    // Lógica para determinar el tipo de dato basado en palabras reservadas
    switch (palabraReservada) {
        case "boolean":
            return "BOOL";
        case "double":
            return "DOUBLE";
        case "short":
            return "SHORT";
        case "long":
            return "LONG";
        case "char":
            return "CARACTER";
        case "byte":
            return "BYTE";
        case "float":
            return "FLOAT";
        case "int":
            return "ENTERO";
        default:
          
            return "INDEFINIDO";
    }
}

private String obtenerTipoDatoIdentificador(Token token) {
    if (token.getLexeme().equals("String")) {
        return "STRING";
    } else {
      
        return "INDEFINIDO";
    }
}
         }

      
      
      
      
 
 
 

        
        
        

     
   



   
    



    



