/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_2.compiladores;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sebastian
 */
public class AnalizadorSintactico {
    
      private List<Token> tokens;
    private int index;
     private List<String> errores;
     private int numeroDeLinea;
       private int indice;
         private ArchivodeErrores archivoErrores; 
       
       
    public AnalizadorSintactico(List<Token> tokens,ArchivodeErrores archivoErrores) {
        this.tokens = tokens;
        this.index = 0;
        this.errores = new ArrayList<>();
        this.numeroDeLinea = 1;
         this.indice = 0;
           this.archivoErrores = archivoErrores;
         
         
        
           
        
         
    }
    
      public boolean analizar() {
          
          despuesdemain validador = new despuesdemain();
                   validador.validars(tokens, errores);
                   //contadorscanner validador2 = new contadorscanner();
                   //validador2.validars(tokens, errores);
                   
                 ValidarScanner a = new ValidarScanner();
                 
                 a.validar(tokens, errores);
                 
                 Scannervalidacion scan = new Scannervalidacion();
                 
                 scan.scannervalidation(tokens, errores);
                 
                 println println = new println();
                 
                 println.validacion(tokens, errores);
                 
                 tipodatos tp = new tipodatos();
                 tp.validacion(tokens, errores);
                 
                 entradadatos entrd= new entradadatos();
                 entrd.validacion(tokens, errores);
                 
                  elsentes elseantes = new elsentes();
                  
                  elseantes.validacion(tokens, errores);
                 
                 
                  estructuraifcondicion est = new  estructuraifcondicion();
                  est.validacion(tokens, errores);
                  
                  
                 // estructuraif ifc = new estructuraif();
                //  ifc.validacion(tokens, errores);
                  
                   estructuraifcomando estic = new  estructuraifcomando ();
                   estic.validacion(tokens, errores);
                   
                   EstructuraIfarribaelse elseif = new EstructuraIfarribaelse();
                   elseif.validacion(tokens, errores);
                   
                  // estructurawhileif estwhile = new  estructurawhileif();
                   //estwhile.validacion(tokens, errores);
                   
                   estructurawhilecondicion estcondicion = new  estructurawhilecondicion();
                   estcondicion.validacion(tokens, errores);
                   
                 //  estructurawhilecomando estwhilecom = new    estructurawhilecomando();
                 //   estwhilecom.validacion(tokens, errores);
                    
                    estructuraiguales esti = new estructuraiguales();
                    esti.validacion2(tokens, errores);
                    
                    estructurasimbolodivision estcdv = new estructurasimbolodivision();
                    
                    estcdv.validacion(tokens, errores, archivoErrores);
                    EstructuraWhileComando2 estc = new EstructuraWhileComando2();
                    estc.validacion(tokens, errores);
                    
                    elseif elsei= new  elseif();
                    
                    elsei.validacion(tokens, errores);
                    
                    estructurawhileif2 ifi = new  estructurawhileif2();
                    ifi.validacion(tokens, errores);
                    
                    
                    
                   
                 
                 
                   
                       if (!errores.isEmpty()) {
            for (String error : errores) {
                System.out.println(error);
            }
            return false;
        }

        // Continuar con otras validaciones o análisis si es necesario
        return true;
              
              
              
          }
      
      
  
      
      
      public  class despuesdemain{
      
             private int contadorScanner = 0; // Contador para rastrear la aparición de static Scanner sc = new Scanner(System.in);

    public boolean validars(List<Token> tokens, List<String> errores) {
        boolean encontradoMain = false;
        boolean encontradoScanner = false;

        for (int i = 0; i < tokens.size(); i++) {
            Token tokenActual = tokens.get(i);

            if (tokenActual.getType() == TokenType.PALABRAS_RESERVADAS && tokenActual.getLexeme().equals("public")) {
                Token siguienteToken = tokens.get(i + 1);

                // Validar estructura public static void main(String args[])
                if (siguienteToken.getType() == TokenType.PALABRAS_RESERVADAS
                        && siguienteToken.getLexeme().equals("static")) {
                    Token siguienteToken2 = tokens.get(i + 2);
                    if (siguienteToken2.getType() == TokenType.PALABRAS_RESERVADAS
                            && siguienteToken2.getLexeme().equals("void")) {
                        Token siguienteToken3 = tokens.get(i + 3);
                        if (siguienteToken3.getType() == TokenType.IDENTIFICADOR
                                && siguienteToken3.getLexeme().equals("main")) {
                            Token siguienteToken4 = tokens.get(i + 4);
                            if (siguienteToken4.getType() == TokenType.PARENTESIS_ABRE) {
                               
                                Token siguienteToken5 = tokens.get(i + 5);
                                if (siguienteToken5.getType() == TokenType.IDENTIFICADOR
                                        && siguienteToken5.getLexeme().equals("String")) {
                                    Token siguienteToken6 = tokens.get(i + 6);
                                    if (siguienteToken6.getType() == TokenType.IDENTIFICADOR
                                            && siguienteToken6.getLexeme().equals("args")) {
                                        Token siguienteToken7 = tokens.get(i + 7);
                                        if (siguienteToken7.getType() == TokenType.CUADRADOAPER) {
                                            Token siguienteToken8 = tokens.get(i + 8);
                                            if (siguienteToken8.getType() == TokenType.CUADRADOCIERRE) {
                                               
                                                
                                                 Token siguienteToken9 = tokens.get(i + 9);
                                                 if (siguienteToken9.getType() == TokenType.PARENTESIS_CIERRA)
                                                {
                                                encontradoMain = true;
                                                i += 9; // Saltar la estructura validada
                                                break;
                                            }
                                                 
                                                 
                                                
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (tokenActual.getType() == TokenType.PALABRAS_RESERVADAS
                    && tokenActual.getLexeme().equals("static"))
                   
            {
                   
                
              
                Token siguienteToken = tokens.get(i + 1);
                // Validar estructura static Scanner sc = new Scanner(System.in);
                if (siguienteToken.getType() == TokenType.PALABRAS_RESERVADAS
                        && siguienteToken.getLexeme().equals("Scanner")) {
                   
                    Token siguienteToken2 = tokens.get(i + 2);
                    if (siguienteToken2.getType() == TokenType.IDENTIFICADOR
                            && siguienteToken2.getLexeme().equals("sc")) {
                        Token siguienteToken3 = tokens.get(i + 3);
                        if (siguienteToken3.getType() == TokenType.OPERADORES_ARITMETICOS
                                && siguienteToken3.getLexeme().equals("=")) {
                            Token siguienteToken4 = tokens.get(i + 4);
                            if (siguienteToken4.getType() == TokenType.PALABRAS_RESERVADAS
                                    && siguienteToken4.getLexeme().equals("new")) {
                                
                                Token siguienteToken5 = tokens.get(i + 5);
                                if (siguienteToken5.getType() == TokenType.PALABRAS_RESERVADAS
                                        && siguienteToken5.getLexeme().equals("Scanner")) {
                                    Token siguienteToken6 = tokens.get(i + 6);
                                    if (siguienteToken6.getType() == TokenType.PARENTESIS_ABRE
                                            && siguienteToken6.getLexeme().equals("(")) {
                                        Token siguienteToken7 = tokens.get(i + 7);
                                        if (siguienteToken7.getType() == TokenType.IDENTIFICADOR
                                                && siguienteToken7.getLexeme().equals("System")) {
                                            Token siguienteToken8 = tokens.get(i + 8);
                                            if (siguienteToken8.getType() == TokenType.PUNTO) {
                                                Token siguienteToken9 = tokens.get(i + 9);
                                                if (siguienteToken9.getType() == TokenType.IDENTIFICADOR
                                                        && siguienteToken9.getLexeme().equals("in")) {
                                                   
                                                    Token siguienteToken10 = tokens.get(i + 10);
                                                    if (siguienteToken10.getType() == TokenType.PARENTESIS_CIERRA) {
                                                     
                                                         Token siguienteToken11 = tokens.get(i + 11);
                                                         
                                                           if (siguienteToken11.getType() == TokenType.COLON) {
                                                     
                                                 
                                                        
                                                        encontradoScanner = true;
                                                        
                                                        contadorScanner++;
                                                        System.out.println(contadorScanner++);
                                                        i += 11; // Saltar la estructura validada
                                                        break;
                                                    }
                                                        
                                                        
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (!encontradoMain) {
            errores.add("Error: La estructura 'public static void main(String args[])' es obligatoria.");
        }

        if (contadorScanner != 1) {
          //  errores.add("Error: La estructura 'static Scanner sc = new Scanner(System.in);' debe aparecer una vez.");
        }

        return encontradoMain && encontradoScanner && contadorScanner == 1;
    }
          
           }
      
      public class contadorscanner{
          
            public boolean validars(List<Token> tokens, List<String> errores) {
        int contadorScanner = 0;

        for (int i = 0; i < tokens.size(); i++) {
            Token tokenActual = tokens.get(i);

            // Validar estructura static Scanner sc = new Scanner(System.in);
            if (esEstructuraScannerCorrecta(tokenActual, tokens, i)) {
                contadorScanner++;
                
               
               
                i += 11; // Saltar la estructura validada
                
                
            }
            
        }
        if (contadorScanner > 1) {
            errores.add("Error: La estructura 'static Scanner sc = new Scanner(System.in)' debe aparecer una vez.");
            
        }
        return  contadorScanner == 1;
      
      
      }
            
            
        private boolean esEstructuraScannerCorrecta(Token token, List<Token> tokens, int indice) {
        // Validar estructura static Scanner sc = new Scanner(System.in);
        if (token.getType() == TokenType.PALABRAS_RESERVADAS && token.getLexeme().equals("static")) {
              
            Token siguienteToken = tokens.get(indice + 1);
            if (siguienteToken.getType() == TokenType.PALABRAS_RESERVADAS && siguienteToken.getLexeme().equals("Scanner")) {
                Token siguienteToken2 = tokens.get(indice + 2);
                if (siguienteToken2.getType() == TokenType.IDENTIFICADOR && siguienteToken2.getLexeme().equals("sc")) {
                   
                    Token siguienteToken3 = tokens.get(indice + 3);
                    if (siguienteToken3.getType() == TokenType.OPERADORES_ARITMETICOS && siguienteToken3.getLexeme().equals("=")) {
                         
                        Token siguienteToken4 = tokens.get(indice + 4);
                        if (siguienteToken4.getType() == TokenType.PALABRAS_RESERVADAS && siguienteToken4.getLexeme().equals("new")) {
                           
                            Token siguienteToken5 = tokens.get(indice + 5);
                            if (siguienteToken5.getType() == TokenType.PALABRAS_RESERVADAS && siguienteToken5.getLexeme().equals("Scanner")) {
                                 
                                Token siguienteToken6 = tokens.get(indice + 6);
                                if (siguienteToken6.getType() == TokenType.PARENTESIS_ABRE && siguienteToken6.getLexeme().equals("(")) {
                                  
                                    Token siguienteToken7 = tokens.get(indice + 7);
                                    if (siguienteToken7.getType() == TokenType.IDENTIFICADOR && siguienteToken7.getLexeme().equals("System")) {
                                          
                                        Token siguienteToken8 = tokens.get(indice + 8);
                                        if (siguienteToken8.getType() == TokenType.PUNTO ) {
                                            
                                            Token siguienteToken9 = tokens.get(indice + 9);
                                            if (siguienteToken9.getType() == TokenType.IDENTIFICADOR && siguienteToken9.getLexeme().equals("in")) {
                                                Token siguienteToken10 = tokens.get(indice + 10);
                                                 if (siguienteToken10.getType() == TokenType.PARENTESIS_CIERRA && siguienteToken9.getLexeme().equals(")")) {
                                                  Token siguienteToken11 = tokens.get(indice + 11);
                                                
                                                if (siguienteToken11.getType() == TokenType.COLON) {
                                                  
                                                
                                            }
                                            }
                                                 
                                                
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
      
        return false;
          
    }
        
     
        
      
      
    

    
}
      
         public class ValidarScanner {
   public boolean validar(List<Token> tokens, List<String> errores) {
            StringBuilder codigo = new StringBuilder();
        for (Token token : tokens) {
            codigo.append(token.getLexeme()).append(" ");
        }

        // Expresión regular para buscar la estructura "static Scanner sc = new Scanner(System.in);"
        String regex = "\\s*static\\s+Scanner\\s+sc\\s*=\\s*new\\s+Scanner\\s*\\(\\s*System\\s*\\.\\s*\\s*in\\s*\\)\\s*;";

        // Verificar si hay una coincidencia con la expresión regular
        // Utilizar un Matcher para encontrar las coincidencias
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(codigo);
        
        

        // Contador para las estructuras encontradas
        int contadorEstructuras = 0;

        // Contar las estructuras encontradas
        while (matcher.find()) {
            contadorEstructuras++;
        }

        // Imprimir la cantidad de estructuras encontradas
   

        // Verificar si solo hay una estructura
        if (contadorEstructuras == 1) {
            return true;
        } else {
            errores.add("Error: La estructura 'static Scanner sc = new Scanner(System.in);' debe aparecer una vez.");
            return false;
        }
}
    }
         
             public class Scannervalidacion{
         
         public  boolean scannervalidation (List<Token> tokens, List<String> errores){
         boolean encontradoScanner = false;
         boolean encontradoidentificador=false;
          boolean encontradoigual=false;
          boolean encontradonew=false;
          boolean encontradoScanner2=false;
          boolean parentesisentrada=false;
          boolean identificador2=false;
          boolean punto=false;
          boolean identificador3= false;
          boolean parentesiscierre= false;
          boolean puntoycoma= false;
        

    for (int i = 0; i < tokens.size() - 1; i++) {
        Token tokenActual = tokens.get(i);
        if (tokenActual.getType() == TokenType.PALABRAS_RESERVADAS && tokenActual.getLexeme().equals("static")) {
          encontradoScanner  = true;
            Token siguienteToken = tokens.get(i + 1);
          
         
          
            
            if (siguienteToken.getType() == TokenType.PALABRAS_RESERVADAS && siguienteToken.getLexeme().equals("Scanner")  ){
               encontradoidentificador=true;
               
               
                  Token siguienteToken1 = tokens.get(i + 2);
        
                  if (siguienteToken1.getType() == TokenType.IDENTIFICADOR && siguienteToken1.getLexeme().equals("sc"))
                  {
                       String numeroLinea1 = siguienteToken1.getLinea();
                         
                   
            encontradoigual=true;
                          Token siguienteToken2 = tokens.get(i + 3);
                          
                             if (siguienteToken2.getType() == TokenType.OPERADORES_ARITMETICOS && siguienteToken2.getLexeme().equals("=")) {
               encontradonew=true;
                          Token siguienteToken3 = tokens.get(i + 4);
                          
               if (siguienteToken3.getType() == TokenType.PALABRAS_RESERVADAS && siguienteToken3.getLexeme().equals("new")) {
               encontradoScanner2=true;
                          Token siguienteToken4 = tokens.get(i + 5);
                          
                            if (siguienteToken4.getType() == TokenType.PALABRAS_RESERVADAS&& siguienteToken4.getLexeme().equals("Scanner")) {
          parentesisentrada=true;
                          Token siguienteToken5 = tokens.get(i + 6);
                          
                 if (siguienteToken5.getType() == TokenType.PARENTESIS_ABRE && siguienteToken5.getLexeme().equals("(")) {
             identificador2=true;
                          Token siguienteToken6 = tokens.get(i + 7);
                                    
                if (siguienteToken6.getType() == TokenType.IDENTIFICADOR && siguienteToken6.getLexeme().equals("System") ) {
               punto=true;
                          Token siguienteToken7 = tokens.get(i + 8);
                if (siguienteToken7.getType() == TokenType.PUNTO ) {
                      
                     
                   identificador3=true ;
                          Token siguienteToken8 = tokens.get(i + 9);
                          
                              if (siguienteToken8.getType() == TokenType.IDENTIFICADOR && siguienteToken8.getLexeme().equals("in") ) {
               parentesiscierre= true;
                          Token siguienteToken9 = tokens.get(i + 10);
                          
                 if (siguienteToken9.getType() == TokenType.PARENTESIS_CIERRA ) {
                     
                 
            
             
             Token siguienteToken10 = tokens.get(i + 11);
             
                 if (siguienteToken10.getType() == TokenType.COLON ) {
                     
                   
                     
                 
             puntoycoma= true;
                        
               
            }else{
                 
                 errores.add("Error 010 falta punto y coma");
                 }
             
                        
               
            }else {
                                        String numeroLinea = siguienteToken9.getLinea();
                                       
                                       errores.add("falta parentesis de cierre" +"' en la línea "+numeroLinea);}
               
            }else {
                                        String numeroLinea = siguienteToken8.getLinea();
                                       
                                       errores.add("falta identificador in"+"' en la línea "+numeroLinea);}
               
            }else {
                                        String numeroLinea = siguienteToken7.getLinea();
                                       
                                       errores.add("falta punto"+"' en la línea "+numeroLinea);}
               
            }else {
                                        String numeroLinea = siguienteToken6.getLinea();
                                       
                                       errores.add("falta System"+"' en la línea "+numeroLinea);}
               
            }else {
                                        String numeroLinea = siguienteToken5.getLinea();
                                       
                                       errores.add("falta parentesis de de apertura "+"' en la línea "+numeroLinea);}
               
            }else {
                                        String numeroLinea = siguienteToken4.getLinea();
                                       
                                       errores.add("falta  Scanner"+"' en la línea "+numeroLinea);}
                            
              
               
            }else {
                                        String numeroLinea = siguienteToken3.getLinea();
                                       
                                       errores.add("falta el new"+"' en la línea "+numeroLinea);}
               
            }else {
                                        String numeroLinea = siguienteToken2.getLinea();
                                       
                                       errores.add("falta el = en la línea "+numeroLinea);}
               
            }else{
                      
                      String numeroLinea = siguienteToken1.getLinea();
                  errores.add("Falta el sc en la linea"+numeroLinea);
                  }
                
               
            }else{
              String numeroLinea = siguienteToken.getLinea();
                  errores.add("Falta el scanner en la linea"+numeroLinea);
            
            }
            
            
        }
    }
    
     if (!  encontradoidentificador) {
       // errores.add("Error:036 Falta el el identificador");
        return true;
    }
    if (! encontradoigual) {
      
        
   //     errores.add("Error:030 Falta el operador = '.");
         return true;
    }
   
    if (!  encontradonew) {
  //      errores.add("Error:031 Falta el new'.");
          return true;
    }
    if (! encontradoScanner2) {
    //    errores.add("Error:032  Falta el Scanner");
    }
    if (! parentesisentrada) {
     //   errores.add("Error:033 Falta el ( ");
        return true;
    }
    if (! identificador2) {
    //    errores.add("Error:034 Falta el identificador");
        return true;
    }
    if (!  identificador3) {
    //    errores.add("Error:034 Falta el identificador");
        return true;
    }
    if (!  parentesiscierre) {
      //  errores.add("Error:035 Falta el parentesis de cierre");
        return true;
    }
    if (! puntoycoma) {
        
  
        return true;
    }
   


    return true; 
}
            
             
         }
             
             
               public class println{
                public  boolean validacion(List<Token> tokens, List<String> errores){
                    
                     for (int i = 0; i < tokens.size() - 1; i++) {
        Token tokenActual = tokens.get(i);
        
         if (tokenActual.getType() == TokenType.IDENTIFICADOR && tokenActual.getLexeme().equals("println")) {
        
            Token siguienteToken = tokens.get(i + 1);
            
                  if (siguienteToken.getType() == TokenType.PARENTESIS_ABRE){
        
           
            
                 Token siguienteToken2 = tokens.get(i + 2);
                 
                 
                     if (siguienteToken2.getType() == TokenType.CADENA||siguienteToken2.getType() == TokenType.IDENTIFICADOR ) {
        
            Token siguienteToken3 = tokens.get(i + 3);
            
            
                     if (siguienteToken3.getType() == TokenType.PARENTESIS_CIERRA ) {
        
            Token siguienteToken4 = tokens.get(i + 4);
            
            
                                 if (siguienteToken4.getType() == TokenType.COLON){
        
           
            
            
            
            
            
         }else { 
                                        String numeroLinea4 = siguienteToken4.getLinea();
                                     errores.add(" ERROR 010 : Falta punto y coma"+numeroLinea4);}
            
            
            
            
            
         }else { 
                           String numeroLinea3 = siguienteToken3.getLinea();
                         
                         errores.add(" ERROR 09 : Falta paréntesis de cierre"+numeroLinea3 );}
            
            
            
         }else {
                           String numeroLinea2 = siguienteToken2.getLinea();
                         errores.add("Error 011: Falta cadena o identificador "+numeroLinea2);}
            
            
            
         }else {
                        String numeroLinea = siguienteToken.getLinea();
                      
                      errores.add("falta paréntesis de apertura"+numeroLinea);}
            
                
           
            
            
            
         }
        
        
        
                     
                     
                     
                     }
                    
                    
                
                
                
                    
                    return true; 
                }
               
               
               
               }
               
               
               public class tipodatos{
                public  boolean validacion(List<Token> tokens, List<String> errores){
                     for (int i = 0; i < tokens.size() - 1; i++) {
                     Token tokenActual = tokens.get(i);
                     
                     if (tokenActual.getType() == TokenType.PALABRAS_RESERVADAS && tokenActual.getLexeme().equals("char")||tokenActual.getLexeme().equals("int")||tokenActual.getLexeme().equals("long")||tokenActual.getLexeme().equals("float")||tokenActual.getLexeme().equals("double")||tokenActual.getLexeme().equals("byte")||tokenActual.getLexeme().equals("boolean")||tokenActual.getLexeme().equals("short")){
                     
                       Token siguienteToken = tokens.get(i + 1);
                       
                       
                        if (siguienteToken.getType() == TokenType.IDENTIFICADOR){
                            
                            Token siguienteToken2 = tokens.get(i + 2);
                              if (siguienteToken2.getType() == TokenType.COLON){
                     
                      
                     }else{
                                    String numeroLinea2 = siguienteToken.getLinea();
                                  errores.add("ERROR 010 : Falta punto y coma"+numeroLinea2);}
                     
                      
                     }else{
                            
                              String numeroLinea = siguienteToken.getLinea();
                            errores.add("Falta identificador"+numeroLinea);}
                       
                       
                     }
                     
                     
                     
                     }
                    
                    
                
                return true;
                }
               
               
               }
               
               public class entradadatos{
                 public  boolean validacion(List<Token> tokens, List<String> errores){
                     
                      for (int i = 0; i < tokens.size() - 1; i++) {
                     Token tokenActual = tokens.get(i);
                     
                     if (tokenActual.getType()==TokenType.IDENTIFICADOR){
                        
                         
                          Token siguienteToken = tokens.get(i + 1);
                          
                           if (siguienteToken.getType()==TokenType.OPERADORES_ARITMETICOS && siguienteToken.getLexeme().equals("=")){
                         
                          Token siguienteToken2 = tokens.get(i + 2);
                          
                           if (siguienteToken2.getType()==TokenType.IDENTIFICADOR && siguienteToken2.getLexeme().equals("sc")){
                         
                          Token siguienteToken3 = tokens.get(i + 3);
                          
                                                     if (siguienteToken3.getType()==TokenType.PUNTO ){
                                                           
                         
                          Token siguienteToken4 = tokens.get(i + 4);
                          
                                                  if (siguienteToken4.getType()==TokenType.IDENTIFICADOR && siguienteToken4.getLexeme().equals("nextByte")||siguienteToken4.getLexeme().equals("nextLine")||siguienteToken4.getLexeme().equals("nextInt")||siguienteToken4.getLexeme().equals("nextShort")||siguienteToken4.getLexeme().equals("nextLong")||siguienteToken4.getLexeme().equals("nextFloat")||siguienteToken4.getLexeme().equals("nextDouble")||siguienteToken4.getLexeme().equals("nextBoolean")){
                       
                          Token siguienteToken5 = tokens.get(i + 5);
                          
                                           if (siguienteToken5.getType()==TokenType.PARENTESIS_ABRE ){
                         
                          Token siguienteToken6 = tokens.get(i + 6);
                          
                                         if (siguienteToken6.getType()==TokenType.PARENTESIS_CIERRA ){
                         
                          Token siguienteToken7 = tokens.get(i + 7);
                          
                          
                    if (siguienteToken7.getType()==TokenType.COLON){
                         
                       
                          
                          
                          
                          
                          
                     
                     }else{  
                        
                          String numeroLinea5 = siguienteToken5.getLinea();
                        errores.add("Error 010 falta punto y coma"+ numeroLinea5);}
                          
                          
                          
                          
                          
                     
                     }else{
                                               String numeroLinea4 = siguienteToken4.getLinea();
                                             errores.add("falta paréntesis de cierre en la linea "+numeroLinea4);}
                          
                          
                          
                          
                          
                     
                     }else {
                                               String numeroLinea3 = siguienteToken3.getLinea();
                                               errores.add("Falta parentesisis de apertura en la linea "+ numeroLinea3);}
                          
                          
                          
                     
                     }else {
                                                         String numeroLinea2 = siguienteToken2.getLinea();
                                                      errores.add("falta identificador en la linea "+numeroLinea2);}
                          
                          
                          
                          
                          
                     
                     }else {
                                                          String numeroLinea = siguienteToken.getLinea();
                                                         errores.add("Error falta punto en la linea "+numeroLinea);}
                          
                          
                          
                     
                     }
                          
                          
                          
                     
                     }
                     
                     }
                      
                      
                      }
                     
                     
                     return true; 
                 }
               
               }
               
               
               
               
               
               public class estructuraifcondicion{
                   
    public boolean validacion(List<Token> tokens, List<String> errores) {
    String regexCondicionBuilder = "[a-zA-Z_]\\w*|[<>!=]=?|\\d+(\\.\\d+)?";
    
   
    Pattern patternCondicionBuilder = Pattern.compile(regexCondicionBuilder);
 
    int i = 0;
    while (i < tokens.size()) {
        Token tokenActual = tokens.get(i);

        if (tokenActual.getType() == TokenType.PALABRAS_RESERVADAS && tokenActual.getLexeme().equals("if")) {
           
            i++; // Avanzamos al siguiente token
            StringBuilder condicionBuilder = new StringBuilder();
      
            if (i < tokens.size() && tokens.get(i).getType() == TokenType.PARENTESIS_ABRE) {
                
                i++;
                
// Avanzamos al siguiente token después del paréntesis de apertura


if (i < tokens.size()) {
    String tokenLexeme = tokens.get(i).getLexeme();
    Matcher matcher = patternCondicionBuilder.matcher(tokenLexeme);

    if (!matcher.matches()) {
        errores.add("Error: Después del paréntesis de apertura debe venir una condición en el if en la linea "+ tokens.get(i).getLinea());
       
    }
} else {
    // Si no hay más tokens, hay un error en la estructura del if
 //   errores.add("Error: Falta la condición después del paréntesis de apertura en el if");
   
}

                // Construir la condición dentro de los paréntesis
   while (i < tokens.size() && tokens.get(i).getType() != TokenType.PARENTESIS_CIERRA) {
    String tokenLexeme = tokens.get(i).getLexeme();

    // Verificar si el token es un operador o parte de una condición
    Matcher matcher = patternCondicionBuilder.matcher(tokenLexeme);
    if (matcher.matches()) {
        condicionBuilder.append(tokenLexeme).append(" ");
    }

    i++;
}

// Verificar el paréntesis de cierre después de la condición
if (i < tokens.size() && tokens.get(i).getType() == TokenType.PARENTESIS_CIERRA) {
    // La estructura del if es válida
    String condicion = condicionBuilder.toString().trim();
    System.out.println(condicion);
   
    i++;
   
    
    
    
    
    // Aquí puedes realizar la validación adicional con la expresión regular principal
} else {
    // Falta el paréntesis de cierre después de la condición del if
 //   errores.add("Error: Falta el paréntesis de cierre después de la condición del if(...)");
}

                // Avanzar al siguiente token
                i++;
            } else {
         //     errores.add("Error: Falta el paréntesis de apertura después del if");
                break; // Salir del bucle principal
            }
        } else {
            // Avanzar al siguiente token si no es un if
            i++;
        }
       
    }

    return errores.isEmpty();
}
              
    
               
               }
               
               
                  public class estructurawhilecondicion{
                   
    public boolean validacion(List<Token> tokens, List<String> errores) {
    String regexCondicionBuilder = "[a-zA-Z_]\\w*|[<>!=]=?|\\d+(\\.\\d+)?";
    
   
    Pattern patternCondicionBuilder = Pattern.compile(regexCondicionBuilder);
 
    int i = 0;
    while (i < tokens.size()) {
        Token tokenActual = tokens.get(i);

        if (tokenActual.getType() == TokenType.PALABRAS_RESERVADAS && tokenActual.getLexeme().equals("while")) {
           
            i++; // Avanzamos al siguiente token
            StringBuilder condicionBuilder = new StringBuilder();
      
            if (i < tokens.size() && tokens.get(i).getType() == TokenType.PARENTESIS_ABRE) {
                
                i++;
                
// Avanzamos al siguiente token después del paréntesis de apertura


if (i < tokens.size()) {
    String tokenLexeme = tokens.get(i).getLexeme();
    Matcher matcher = patternCondicionBuilder.matcher(tokenLexeme);

    if (!matcher.matches()) {
        errores.add("Error: Después del paréntesis de apertura debe venir una condición en el while"+ tokens.get(i).getLinea());
       
    }
} else {
    // Si no hay más tokens, hay un error en la estructura del if
  //  errores.add("Error: Falta la condición después del paréntesis de apertura en el if");
   
}

                // Construir la condición dentro de los paréntesis
   while (i < tokens.size() && tokens.get(i).getType() != TokenType.PARENTESIS_CIERRA) {
    String tokenLexeme = tokens.get(i).getLexeme();

    // Verificar si el token es un operador o parte de una condición
    Matcher matcher = patternCondicionBuilder.matcher(tokenLexeme);
    if (matcher.matches()) {
        condicionBuilder.append(tokenLexeme).append(" ");
    }

    i++;
}

// Verificar el paréntesis de cierre después de la condición
if (i < tokens.size() && tokens.get(i).getType() == TokenType.PARENTESIS_CIERRA) {
    // La estructura del if es válida
    String condicion = condicionBuilder.toString().trim();
  //  System.out.println(condicion);
   
    i++;
   
    
    
    
    
    // Aquí puedes realizar la validación adicional con la expresión regular principal
} else {
    // Falta el paréntesis de cierre después de la condición del if
  //  errores.add("Error: Falta el paréntesis de cierre después de la condición del if(...)");
}

                // Avanzar al siguiente token
                i++;
            } else {
           //     errores.add("Error: Falta el paréntesis de apertura después del if");
                break; // Salir del bucle principal
            }
        } else {
            // Avanzar al siguiente token si no es un if
            i++;
        }
       
    }

    return errores.isEmpty();
}
              
    
               
               }
                  
                  public class EstructuraWhileComando2 {
    public boolean validacion(List<Token> tokens, List<String> errores) {

        String regexCondicionBuilder = "[a-zA-Z_]\\w*|[<>!=]=?|\\d+(\\.\\d+)?";
        Pattern patternCondicionBuilder = Pattern.compile(regexCondicionBuilder);
        String regexCondicionBuilder1 =  "\\s*[a-zA-Z_/]\\w*\\s*;?\\s*|\\s*println\\(\\w+\\);\\s*";
        Pattern patternCondicionBuilder1 = Pattern.compile(regexCondicionBuilder1);
        

        int i = 0;
        while (i < tokens.size()) {
            Token tokenActual = tokens.get(i);

            if (tokenActual.getType() == TokenType.PALABRAS_RESERVADAS && "while".equals(tokenActual.getLexeme())) {

                i++;

                if (i < tokens.size() && tokens.get(i).getType() == TokenType.PARENTESIS_ABRE) {
                    i++; // Avanzamos al siguiente token después del paréntesis de apertura

                    // Construir la condición dentro de los paréntesis
                    StringBuilder condicionBuilder = new StringBuilder();
                         
                    while (i < tokens.size() && tokens.get(i).getType() != TokenType.PARENTESIS_CIERRA) {
                        String tokenLexeme = tokens.get(i).getLexeme();
                        Matcher matcher = patternCondicionBuilder.matcher(tokenLexeme);
                        if (matcher.matches()) {
                            condicionBuilder.append(tokenLexeme).append(" ");
                        } else {
                            break; // Salir del bucle si el token no cumple con la expresión regular
                        }
                        i++;
                    }

                    // Verificar el paréntesis de cierre después de la condición
                    if (i < tokens.size() && tokens.get(i).getType() == TokenType.PARENTESIS_CIERRA) {
                        i++; // Avanzar al siguiente token después del paréntesis de cierre

                        // Validar el corchete de apertura
                        if (i < tokens.size() && tokens.get(i).getType() == TokenType.CORCHETEAPER) {
                            StringBuilder comandoBuilder = new StringBuilder();
                            i++; // Avanzar al siguiente token después del corchete de apertura

                            // Validar la presencia de un comando dentro del while
                            if (i < tokens.size()) {
                                String tokenLexeme = tokens.get(i).getLexeme();
                                Matcher matcher = patternCondicionBuilder1.matcher(tokenLexeme);

                                if (!matcher.matches()) {
                                    errores.add("Error: Después del corchete de apertura debe venir un comando en al linea "+tokens.get(i).getLinea());
                                }
                            }

                            // Construir el comando dentro de los corchetes
                       
                            while (i < tokens.size() && tokens.get(i).getType() != TokenType.CORCHETECIERRE) {
                                String tokenLexeme = tokens.get(i).getLexeme();

                                // Verificar si el token es un operador o parte de un comando
                                Matcher matcher = patternCondicionBuilder1.matcher(tokenLexeme);
                                if (matcher.matches()) {
                                    comandoBuilder.append(tokenLexeme).append(" ");
                                    break;
                                }
                                i++;
                                
                                 
                            }
                            
                            

                            // Validar el corchete de cierre después del comando
                            if (i < tokens.size() && tokens.get(i).getType() == TokenType.CORCHETECIERRE) {
                                
                                  String condicion1 = comandoBuilder.toString().trim();
                               // System.out.println("a");
                             //   System.out.println(condicion1);
                                i++;// Avanzar al siguiente token después del corchete de cierre
                             
                            } else {
                                errores.add("Error: Después del comando dentro del while debe venir un corchete de cierre en al linea "+tokens.get(i).getLinea());
                              
                            }
                            i++;
                        } else {
                            errores.add("Error: Después del paréntesis de cierre debe venir un corchete de apertura en la linea "+tokens.get(i).getLinea());
                            
                        }
                    } else {
                        errores.add("Error: Falta el paréntesis de cierre después de la condición del while en la linea "+tokens.get(i).getLinea());
                      
                    }
                } else {
                    errores.add("Error: Falta el paréntesis de apertura después del while en al linea "+tokens.get(i).getLinea());
                }
            } else {
                // Avanzar al siguiente token si no es un while
                i++;
            }
        }

        return errores.isEmpty();
    }
}
                  
                    public class estructurawhilecomando {
    public boolean validacion(List<Token> tokens, List<String> errores) {

        String regexCondicionBuilder = "[a-zA-Z_]\\w*|[<>!=]=?|\\d+(\\.\\d+)?";
        Pattern patternCondicionBuilder = Pattern.compile(regexCondicionBuilder);
     String regexCondicionBuilder1 = "\\s*[a-zA-Z_/]\\w*\\s*;?\\s*|\\s*println\\(\\w+\\);\\s*";
        Pattern patternCondicionBuilder1 = Pattern.compile(regexCondicionBuilder1);
     int i = 0;
        while (i < tokens.size()) {
            Token tokenActual = tokens.get(i);

            if (tokenActual.getType() == TokenType.PALABRAS_RESERVADAS && tokenActual.getLexeme().equals("while")) {

                i++;
                StringBuilder condicionBuilder = new StringBuilder();
                StringBuilder condicionBuilder2 = new StringBuilder();

                if (i < tokens.size() && tokens.get(i).getType() == TokenType.PARENTESIS_ABRE) {

                    i++; // Avanzamos al siguiente token después del paréntesis de apertura

                    // Construir la condición dentro de los paréntesis
                    while (i < tokens.size() && tokens.get(i).getType() != TokenType.PARENTESIS_CIERRA) {
                        String tokenLexeme = tokens.get(i).getLexeme();
                        Matcher matcher = patternCondicionBuilder.matcher(tokenLexeme);
                        if (matcher.matches()) {
                            condicionBuilder.append(tokenLexeme).append(" ");
                        } else {
                            break; // Salir del bucle si el token no cumple con la expresión regular
                        }
                        i++;
                    }

                    // Verificar el paréntesis de cierre después de la condición
                    if (i < tokens.size() && tokens.get(i).getType() == TokenType.PARENTESIS_CIERRA) {
                        // La estructura del if es válida
                        String condicion = condicionBuilder.toString().trim();

                        i++;

                        if (i < tokens.size() && tokens.get(i).getType() == TokenType.CORCHETEAPER) {

                            i++;

                            if (i < tokens.size()) {
                                String tokenLexeme = tokens.get(i).getLexeme();
                                Matcher matcher = patternCondicionBuilder1.matcher(tokenLexeme);

                                if (!matcher.matches()) {
                                  //  errores.add("Error: Después del corchete de apertura debe venir un comando ");

                                }
                            } else {
                               
                            }

                            while (i < tokens.size() && tokens.get(i).getType() != TokenType.CORCHETECIERRE) {
                                String tokenLexeme = tokens.get(i).getLexeme();

                                // Verificar si el token es un operador o parte de una condición
                                Matcher matcher = patternCondicionBuilder1.matcher(tokenLexeme);
                                if (matcher.matches()) {
                                    condicionBuilder2.append(tokenLexeme).append(" ");
                                    
                                }
                                i++;
                                

                            }

                            if (i < tokens.size() && tokens.get(i).getType() == TokenType.CORCHETECIERRE) {
                                // La estructura del if es válida
                                String condicion1 = condicionBuilder2.toString().trim();
                               // System.out.println("a");
                              // System.out.println(condicion1);

                                
                       i++;
                            }
                            
                            
                        }
                        
                        else {
                          
                        }
                      
                    
                    } else {
                       
                    }

                  
                   
                } else {
                    
                     
                }
                
              
            } else { 
                 i++;
            }
            
        
        }

        return errores.isEmpty();
    }
}
                  
                  
                  
               
               
               
             
               
               
               
              public class estructuraifcomando {
    public boolean validacion(List<Token> tokens, List<String> errores) {

        String regexCondicionBuilder = "[a-zA-Z_]\\w*|[<>!=]=?|\\d+(\\.\\d+)?";
        Pattern patternCondicionBuilder = Pattern.compile(regexCondicionBuilder);
        String regexCondicionBuilder1 = "\\s*[a-zA-Z_/]\\w*\\s*;?\\s*|\\s*println\\(\\w+\\);\\s*";
        Pattern patternCondicionBuilder1 = Pattern.compile(regexCondicionBuilder1);

        int i = 0;
        while (i < tokens.size()) {
            Token tokenActual = tokens.get(i);

            if (tokenActual.getType() == TokenType.PALABRAS_RESERVADAS && tokenActual.getLexeme().equals("if")) {

                i++; // Avanzamos al siguiente token
                StringBuilder condicionBuilder = new StringBuilder();
                StringBuilder condicionBuilder2 = new StringBuilder();

                if (i < tokens.size() && tokens.get(i).getType() == TokenType.PARENTESIS_ABRE) {

                    i++; // Avanzamos al siguiente token después del paréntesis de apertura

                    // Construir la condición dentro de los paréntesis
                    while (i < tokens.size() && tokens.get(i).getType() != TokenType.PARENTESIS_CIERRA) {
                        String tokenLexeme = tokens.get(i).getLexeme();
                        Matcher matcher = patternCondicionBuilder.matcher(tokenLexeme);
                        if (matcher.matches()) {
                            condicionBuilder.append(tokenLexeme).append(" ");
                        } else {
                            break; // Salir del bucle si el token no cumple con la expresión regular
                        }
                        i++;
                    }

                    // Verificar el paréntesis de cierre después de la condición
                    if (i < tokens.size() && tokens.get(i).getType() == TokenType.PARENTESIS_CIERRA) {
                        // La estructura del if es válida
                        String condicion = condicionBuilder.toString().trim();

                        // Aquí puedes realizar la validación adicional con la expresión regular principal

                        i++;

                        if (i < tokens.size() && tokens.get(i).getType() == TokenType.CORCHETEAPER) {
                            

                            i++;

                            if (i < tokens.size()) {
                                String tokenLexeme = tokens.get(i).getLexeme();
                                Matcher matcher = patternCondicionBuilder1.matcher(tokenLexeme);

                                if (!matcher.matches()) {
                                    errores.add("Error: Después del corchete de apertura debe venir un comando en la linea "+tokens.get(i).getLinea());

                                }
                            } else {
                                // errores.add("Error: Falta la condición después del paréntesis de apertura en el if");
                            }

                            // Construir la condición dentro de los corchetes
                            while (i < tokens.size() && tokens.get(i).getType() != TokenType.CORCHETECIERRE) {
                                String tokenLexeme = tokens.get(i).getLexeme();

                                // Verificar si el token es un operador o parte de una condición
                                Matcher matcher = patternCondicionBuilder1.matcher(tokenLexeme);
                                if (matcher.matches()) {
                                    condicionBuilder2.append(tokenLexeme).append(" ");
                                }
                                
                                i++;

                               
                            }

                            if (i < tokens.size() && tokens.get(i).getType() == TokenType.CORCHETECIERRE) {
                                // La estructura del if es válida
                                String condicion1 = condicionBuilder2.toString().trim();
                              //  System.out.println(condicion1);

                                i++;
                               
                                // Aquí puedes realizar la validación adicional con la expresión regular principal
                            }
                            

                           
                        }
                        
                       
                        else {
                            // errores.add("Error: Después del paréntesis de cierre debe venir un corchete de
                            // apertura");
                        }
                        
                    
                    } else {
                        // errores.add("Error: Falta el paréntesis de cierre después de la condición del
                        // if(...)");
                       
                    }

                  
                   
                } else {
                    // errores.add("Error: Falta el paréntesis de apertura después del if");
                     // Salir del bucle principal
                    
                }
                
               
            } else {
                
                // Avanzar al siguiente token si no es un if
                i++;
               
            }
            
           
        }

        return errores.isEmpty();
    }
}
              
              
               public class estructurawhileif{
                   
                   public boolean validacion(List<Token> tokens, List<String> errores) {
    String regexCondicionBuilder = "[a-zA-Z_]\\w*|[<>!=]=?|\\d+(\\.\\d+)?";
    Pattern patternCondicionBuilder = Pattern.compile(regexCondicionBuilder);
     String regexCondicionBuilder2 = "\\s*[a-zA-Z_/]\\w*\\s*;?";
   
   
    Pattern patternCondicionBuilder2 = Pattern.compile(regexCondicionBuilder2);

    int i = 0;
    while (i < tokens.size()) {
        Token tokenActual = tokens.get(i);

        if (tokenActual.getType() == TokenType.PALABRAS_RESERVADAS && tokenActual.getLexeme().equals("while")) {
          
            i++; // Avanzamos al siguiente token
            StringBuilder condicionBuilder = new StringBuilder();
            StringBuilder condicionBuilder2 = new StringBuilder();

            if (i < tokens.size() && tokens.get(i).getType() == TokenType.PARENTESIS_ABRE) {
                
                i++; // Avanzamos al siguiente token después del paréntesis de apertura

                // Construir la condición dentro de los paréntesis
                while (i < tokens.size() && tokens.get(i).getType() != TokenType.PARENTESIS_CIERRA) {
                    String tokenLexeme = tokens.get(i).getLexeme();
                    Matcher matcher = patternCondicionBuilder.matcher(tokenLexeme);
                    if (matcher.matches()) {
                        condicionBuilder.append(tokenLexeme).append(" ");
                    } else {
                        
                        break; // Salir del bucle si el token no cumple con la expresión regular
                    }
                    i++;
                }

                // Verificar el paréntesis de cierre después de la condición
                if (i < tokens.size() && tokens.get(i).getType() == TokenType.PARENTESIS_CIERRA) {
                    // La estructura del if es válida
                    String condicion = condicionBuilder.toString().trim();
                   
                    // Aquí puedes realizar la validación adicional con la expresión regular principal
                    
                    
                      i++;
                      
                       if (i < tokens.size() && tokens.get(i).getType() == TokenType.CORCHETEAPER) {
                          
                           
                           
                           i++;
                           
                           
                           while (i < tokens.size() && tokens.get(i).getType() != TokenType.CORCHETECIERRE) {
                              
                    String tokenLexeme = tokens.get(i).getLexeme();
                    Matcher matcher = patternCondicionBuilder2.matcher(tokenLexeme);
                    if (matcher.matches()) {
                        condicionBuilder2.append(tokenLexeme).append(" ");
                    } 
                    i++;
                }
                           
                           if (i < tokens.size() && tokens.get(i).getType() == TokenType.CORCHETECIERRE) {
                              
                              
                      i++; 
                    // La estructura del if es válida
                    String condicion2 = condicionBuilder2.toString().trim();
                    //System.out.println(condicion2);
                   
                    // Aquí puedes realizar la validación adicional con la expresión regular principal
                    
                    
                     
                      
                      
                      
                           } else {
                           
                           errores.add("Falta corchete de cierre");
                             }
                           
                           
       
        
        
        
        
    } else {
        errores.add("Error: Después del paréntesis de cierre debe venir un corchete de apertura");
    }
                       
                    
                }
                
                
                
                   else {
                    // Falta el paréntesis de cierre después de la condición del if
                    errores.add("Error: Falta el paréntesis de cierre después de la condición del if(...)");
                   
                }

                // Avanzar al siguiente token
                
            } else {
             //   errores.add("Error: Falta el paréntesis de apertura después del if");
             
            }
        } else {
            // Avanzar al siguiente token si no es un if
            i++;
        }
    }

    return errores.isEmpty();
}
                   
               
               
               }
               
               
               public class estructurawhileif2 {
    public boolean validacion(List<Token> tokens, List<String> errores) {
    String regexCondicionBuilder = "[a-zA-Z_]\\w*|[<>!=]=?|\\d+(\\.\\d+)?";
    Pattern patternCondicionBuilder = Pattern.compile(regexCondicionBuilder);
    String regexCondicionBuilder2 = "\\s*[a-zA-Z_/]\\w*\\s*;?\\s*|\\s*println\\(\\w+\\);\\s*";
    Pattern patternCondicionBuilder2 = Pattern.compile(regexCondicionBuilder2);

    int i = 0;
    while (i < tokens.size()) {
        Token tokenActual = tokens.get(i);

        if (tokenActual.getType() == TokenType.PALABRAS_RESERVADAS && tokenActual.getLexeme().equals("if")) {
            i++; // Avanzamos al siguiente token
            StringBuilder condicionBuilder = new StringBuilder();
            StringBuilder condicionBuilder2 = new StringBuilder();

            if (i < tokens.size() && tokens.get(i).getType() == TokenType.PARENTESIS_ABRE) {
                i++; // Avanzamos al siguiente token después del paréntesis de apertura

                // Construir la condición dentro de los paréntesis
                while (i < tokens.size() && tokens.get(i).getType() != TokenType.PARENTESIS_CIERRA) {
                    String tokenLexeme = tokens.get(i).getLexeme();
                    Matcher matcher = patternCondicionBuilder.matcher(tokenLexeme);
                    if (matcher.matches()) {
                        condicionBuilder.append(tokenLexeme).append(" ");
                    } else {
                      //  errores.add("Error: Condición no válida dentro del paréntesis");
                    }
                    i++;
                }

                // Verificar el paréntesis de cierre después de la condición
                if (i < tokens.size() && tokens.get(i).getType() == TokenType.PARENTESIS_CIERRA) {
                    i++; // Avanzamos al siguiente token después del paréntesis de cierre

                    if (i < tokens.size() && tokens.get(i).getType() == TokenType.CORCHETEAPER) {
                        i++; // Avanzamos al siguiente token después del corchete de apertura

                        while (i < tokens.size() && tokens.get(i).getType() != TokenType.CORCHETECIERRE) {
                            String tokenLexeme = tokens.get(i).getLexeme();
                            Matcher matcher = patternCondicionBuilder2.matcher(tokenLexeme);
                            if (matcher.matches()) {
                                condicionBuilder2.append(tokenLexeme).append(" ");
                            } else {
                                errores.add("Error: Comando no válido dentro de los corchetes en la linea: "+tokens.get(i).getLinea());
                            }
                            i++;
                        }

                        // Verificar el corchete de cierre después del comando
                        if (i < tokens.size() && tokens.get(i).getType() == TokenType.CORCHETECIERRE) {
                            i++; // Avanzamos al siguiente token después del corchete de cierre
                        } else {
                            errores.add("Error: Falta corchete de cierre en la linea "+tokens.get(i).getLinea());
                        }
                    } else {
                        errores.add("Error: Después del paréntesis de cierre debe venir un corchete de apertura en la linea "+tokens.get(i).getLinea());
                    }
                } else {
                    errores.add("Error: Falta el paréntesis de cierre después de la condición del if(...) en la linea "+tokens.get(i).getLinea());
                }
            } else {
                errores.add("Error: Falta el paréntesis de apertura después del if en la linea "+tokens.get(i).getLinea());
            }
        } else {
            i++; // Avanzar al siguiente token si no es un if
        }
    }

    return errores.isEmpty();
}
}
               
               
               
               
               public class estructuraif{
                   
                   public boolean validacion(List<Token> tokens, List<String> errores) {
    String regexCondicionBuilder = "[a-zA-Z_]\\w*|[<>!=]=?|\\d+(\\.\\d+)?";
    Pattern patternCondicionBuilder = Pattern.compile(regexCondicionBuilder);
     String regexCondicionBuilder2 = "[a-zA-Z_]\\w*|[<>!=]=?|\\d+(\\.\\d+)?";
    Pattern patternCondicionBuilder2 = Pattern.compile(regexCondicionBuilder2);

    int i = 0;
    while (i < tokens.size()) {
        Token tokenActual = tokens.get(i);

        if (tokenActual.getType() == TokenType.PALABRAS_RESERVADAS && tokenActual.getLexeme().equals("if")) {
          
            i++; // Avanzamos al siguiente token
            StringBuilder condicionBuilder = new StringBuilder();
            StringBuilder condicionBuilder2 = new StringBuilder();

            if (i < tokens.size() && tokens.get(i).getType() == TokenType.PARENTESIS_ABRE) {
                
                i++; // Avanzamos al siguiente token después del paréntesis de apertura

                // Construir la condición dentro de los paréntesis
                while (i < tokens.size() && tokens.get(i).getType() != TokenType.PARENTESIS_CIERRA) {
                    String tokenLexeme = tokens.get(i).getLexeme();
                    Matcher matcher = patternCondicionBuilder.matcher(tokenLexeme);
                    if (matcher.matches()) {
                        condicionBuilder.append(tokenLexeme).append(" ");
                    } else {
                        
                        break; // Salir del bucle si el token no cumple con la expresión regular
                    }
                    i++;
                }

                // Verificar el paréntesis de cierre después de la condición
                if (i < tokens.size() && tokens.get(i).getType() == TokenType.PARENTESIS_CIERRA) {
                    // La estructura del if es válida
                    String condicion = condicionBuilder.toString().trim();
                   
                    // Aquí puedes realizar la validación adicional con la expresión regular principal
                    
                    
                      i++;
                      
                       if (i < tokens.size() && tokens.get(i).getType() == TokenType.CORCHETEAPER) {
                      
                           
                           
                           i++;
                           
                           
                           while (i < tokens.size() && tokens.get(i).getType() != TokenType.CORCHETECIERRE) {
                               
                    String tokenLexeme = tokens.get(i).getLexeme();
                    Matcher matcher = patternCondicionBuilder2.matcher(tokenLexeme);
                    if (matcher.matches()) {
                        condicionBuilder2.append(tokenLexeme).append(" ");
                    } else {
                        break;
                       
                    }
                     i++;
                 
                }
                           
                           if (i < tokens.size() && tokens.get(i).getType() == TokenType.CORCHETECIERRE) {
                                  
                              //  System.out.println("a");
                    // La estructura del if es válida
                    String condicion2 = condicionBuilder2.toString().trim();
                    //System.out.println(condicion2);
                   
                    // Aquí puedes realizar la validación adicional con la expresión regular principal
                    
                    
                     
                      
                      
                       
                      i++;
                           }else {
                           
                           errores.add("Falta corchete de cierre");
                           
                          
                           }
                           
                          
      
        
        
        
       
    } else {
        errores.add("Error: Después del paréntesis de cierre debe venir un corchete de apertura");
    }
                  
                    
                }
                
                
                
                   else {
                    // Falta el paréntesis de cierre después de la condición del if
                    errores.add("Error: Falta el paréntesis de cierre después de la condición del if(...)");
            
                }

       
            } else {
                errores.add("Error: Falta el paréntesis de apertura después del if");
           break; 
            }
        } else {
            
           i++;
        }
    }

    return errores.isEmpty();
}
                   
               
               
               }
               
               
               public class EstructuraIfarribaelse {
    public boolean validacion(List<Token> tokens, List<String> errores) {


        int i = 0;
        boolean tieneIfPrevio = false;

        while (i < tokens.size()) {
            Token tokenActual = tokens.get(i);

            if (tokenActual.getType() == TokenType.PALABRAS_RESERVADAS && tokenActual.getLexeme().equals("if")) {
                tieneIfPrevio = true; // Indicar que hay un "if" antes del "else"
            } else if (tokenActual.getType() == TokenType.PALABRAS_RESERVADAS && tokenActual.getLexeme().equals("else")) {
                if (!tieneIfPrevio) {
                    errores.add("Error: Encontrado un 'else' sin un 'if' correspondiente."+tokenActual.getLinea());
                }
                tieneIfPrevio = false; // Reiniciar el indicador después de procesar el "else"
            }

           

            i++;
        }
          return errores.isEmpty();  

    }
}
               
               
               public class estructuraiguales{
                public boolean validacion2(List<Token> tokens, List<String> errores){
                    
                     for (int i = 1; i < tokens.size(); i++) {
                         
                         
                     Token tokenActual = tokens.get(i);
                      Token tokenAnterior = tokens.get(i - 1);
                     
                     
                        if (tokenActual.getType()==TokenType.OPERADORES_ARITMETICOS && tokenActual.getLexeme().equals("=") ){
                            
                            if ( tokenAnterior.getType() != TokenType.IDENTIFICADOR &&
                    !(tokenAnterior.getType() == TokenType.OPERADORES_ARITMETICOS && tokenAnterior.getLexeme().equals("!")) &&
                    !(tokenAnterior.getType() == TokenType.ENTERO) &&
                    !(tokenAnterior.getType() == TokenType.ENTERO_NEGATIVO) &&
                    !(tokenAnterior.getType() == TokenType.REAL) &&
                    !(tokenAnterior.getType() == TokenType.REAL_NEGATIVO) &&
                    !(tokenAnterior.getType() == TokenType.CADENA)&&
                    !(tokenAnterior.getType() == TokenType.OPERADORES_ARITMETICOS && tokenAnterior.getLexeme().equals("<"))) {
                                
                                
                                errores.add("Error: antes del '=' deben ir datos válidos " + tokenAnterior.getLinea());
                    
                    Token token2 = tokens.get(i + 1);
                    if(token2.getType()==TokenType.IDENTIFICADOR||token2.getType()==TokenType.OPERADORES_ARITMETICOS && token2.getLexeme().equals("=")||token2.getType()==TokenType.CADENA||token2.getType()==TokenType.ENTERO||token2.getType()==TokenType.REAL||token2.getType()==TokenType.ENTERO_NEGATIVO ||token2.getType()==TokenType.REAL_NEGATIVO){
                    
                    
                    }else{
                    errores.add("Error 060 Valores no váilidos luego de = "+token2.getLinea());
                    }
                    
                    
                }
                        
                        
                        }
                     
                     
                     
                     
                     }
                
                
              
        return errores.isEmpty();  
                }
                
              
               
               }
               
                public class estructurasimbolodivision{
                public boolean validacion(List<Token> tokens, List<String> errores,  ArchivodeErrores archivoErrores){
                    
                     for (int i = 1; i < tokens.size(); i++) {
                         
                         
                     Token tokenActual = tokens.get(i);
                      Token tokenAnterior = tokens.get(i - 1);
                     
                     
                        if (tokenActual.getType()==TokenType.OPERADORES_ARITMETICOS && tokenActual.getLexeme().equals("/") ){
                            
                            if ( tokenAnterior.getType() != TokenType.IDENTIFICADOR &&
                    !(tokenAnterior.getType() == TokenType.PARENTESIS_CIERRA) &&
                    !(tokenAnterior.getType() == TokenType.ENTERO) &&
                    !(tokenAnterior.getType() == TokenType.ENTERO_NEGATIVO) &&
                    !(tokenAnterior.getType() == TokenType.REAL) &&
                    !(tokenAnterior.getType() == TokenType.REAL_NEGATIVO)) {
                              
                                
                                errores.add("Error: antes del '/' debe datos válidos. Línea: " + tokenAnterior.getLinea());
                    
                    Token token2 = tokens.get(i + 1);
                    if(token2.getType()==TokenType.IDENTIFICADOR|| token2.getType()==TokenType.ENTERO||token2.getType()==TokenType.REAL||token2.getType()==TokenType.ENTERO_NEGATIVO ||token2.getType()==TokenType.REAL_NEGATIVO){
                    
                    
                    }else{
                        int lineNumberError = Integer.parseInt(token2.getLinea());
                    errores.add("Error 060 Valores no váilidos luego de / "+token2.getLinea());
                     archivoErrores.addError(lineNumberError, "Error 060 Valores no válidos luego de / ");
                    }
                    
                    
                }
                        
                        
                        }
                     
                     
                     
                     
                     }
                
                
              
        return errores.isEmpty();  
                }
                
              
               
               }
                
                 public class elseif{
                                        
    public boolean validacion(List<Token> tokens, List<String> errores) {
    String regexCondicionBuilder = "\\s*[a-zA-Z_/]\\w*\\s*;?\\s*|\\s*println\\(\\w+\\);\\s*";
    
   
    Pattern patternCondicionBuilder = Pattern.compile(regexCondicionBuilder);
 
    int i = 0;
    while (i < tokens.size()) {
        Token tokenActual = tokens.get(i);

        if (tokenActual.getType() == TokenType.PALABRAS_RESERVADAS && tokenActual.getLexeme().equals("else")) {
           
            i++; // Avanzamos al siguiente token
            StringBuilder condicionBuilder = new StringBuilder();
      
            if (i < tokens.size() && tokens.get(i).getType() == TokenType.CORCHETEAPER) {
                
                i++;
                
// Avanzamos al siguiente token después del paréntesis de apertura


if (i < tokens.size()) {
    String tokenLexeme = tokens.get(i).getLexeme();
    Matcher matcher = patternCondicionBuilder.matcher(tokenLexeme);

    if (!matcher.matches()) {
        errores.add("Error: Después del corchete de apertura debe venir una condición en el else linea: "  + tokens.get(i).getLinea());
    
    }
} else {
    // Si no hay más tokens, hay un error en la estructura del if
  //  errores.add("Error: Falta la condición después del paréntesis de apertura en el if");
   
}

                // Construir la condición dentro de los paréntesis
   while (i < tokens.size() && tokens.get(i).getType() != TokenType.CORCHETECIERRE) {
    String tokenLexeme = tokens.get(i).getLexeme();

    // Verificar si el token es un operador o parte de una condición
    Matcher matcher = patternCondicionBuilder.matcher(tokenLexeme);
    if (matcher.matches()) {
        condicionBuilder.append(tokenLexeme).append(" ");
    }

    i++;
}

// Verificar el paréntesis de cierre después de la condición
if (i < tokens.size() && tokens.get(i).getType() == TokenType.CORCHETECIERRE) {
    // La estructura del if es válida
    String condicion = condicionBuilder.toString().trim();
  //  System.out.println(condicion);
   
   
   
    
    
    
    
    // Aquí puedes realizar la validación adicional con la expresión regular principal
} else {
    // Falta el paréntesis de cierre después de la condición del if
    errores.add("Error: Falta el corchete de cierre después de la condición linea: "+tokens.get(i).getLinea());
   
}

                // Avanzar al siguiente token
                i++;
            } else {
               errores.add("Error: Falta el corchete de apertura después del else linea: "+tokens.get(i).getLinea());
              
            }
        } else {
            // Avanzar al siguiente token si no es un if
            i++;
        }
       
    }

    return errores.isEmpty();
}
               
                
}
                 
                 
                 public class elsentes{
                       public boolean validacion(List<Token> tokens, List<String> errores) {
                           
                             for (int i = 1; i < tokens.size(); i++) {
                         
                         
                     Token tokenActual = tokens.get(i);
                      Token tokenAnterior = tokens.get(i - 1);
                            if (tokenActual.getType() == TokenType.PALABRAS_RESERVADAS && tokenActual.getLexeme().equals("else")) {
                                
                                                            if ( tokenAnterior.getType() != TokenType.CORCHETEAPER ) {
                                                                
                                                                errores.add("Antes del else debe ir  un corchete de cierre linea:"+tokenAnterior.getLinea());
                                                            }
                                
                            }   
                                
                            }
                           
                       
                       
                        return errores.isEmpty();
                       }
                 
                 }
}

        
        
               

               
               
               
               
         
         




     

    
