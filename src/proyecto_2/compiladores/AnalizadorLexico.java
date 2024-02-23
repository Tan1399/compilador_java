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
public class AnalizadorLexico {
       private String linea;
    private int numeroLinea;
    private List<Token> tokens = new ArrayList<>();
   // private TablaSimbolos tablaSimbolos;
  
    private static final TokenType[] TIPOS = {TokenType.PARENTESIS_ABRE, TokenType.PARENTESIS_CIERRA, TokenType.SEMICOLON, TokenType.PUNTO, TokenType.COMMA};
    public static final String[] PALABRAS_RESERVADAS = {"abstract","assert","boolean","break","byte","case","catch","char","class","continue","default","do","double","else","enum", "exports","extends","final","finally","float","for","if","implements","import","instanceof","int","interface","long","module","native","new","package","private","protected","public","requires","return","short","static","strictfp","super","switch","synchronized","this",
"throw","throws","transient","try","void","volatile","true","null", "false","var","const","java", "util","Scanner","String","short",
"goto","while"};

   
    public  AnalizadorLexico(String linea, int numeroLinea) {
        this.linea = linea;
        this.numeroLinea = numeroLinea;
          this.tokens = new ArrayList<>();
          // this.tablaSimbolos = new TablaSimbolos(); 
    }
    
  
    
    
    
  

    public void analizar(int numerolinea) {
        String numeroLineaFormateado = String.format("%05d", numerolinea);
    
    // Convertir numeroLineaFormateado de String a int después del formateo
    
      // boolean encontradoModule = false;
 // String patron = "//[^\\n]*|/\\*(.|[\\r\\n])*?\\*/|(\\d+\\.\\d+|\\d+|\"[^\"]*\")|[a-zA-Z]\\w*|[.,;:(){}\\[\\]+\\-*=<>!/]";
String patron = "//[^\\n]*|/\\*(.|[\\r\\n])*?\\*/|/\\*\\*(.|[\\r\\n])*?\\*/" +
                "|(-?\\d+\\.\\d+|-?\\d+|\"[^\"]*\")" +
                "|[a-zA-Z][_\\\\$a-zA-Z0-9]*|[.,;:(){}\\[\\]+\\-*=<>!/\\$]";
        // "(\\d+\\.\\d+|\\d+|\"[^\"]*\")|[a-zA-Z]\\w*|[.,;:(){}\\[\\]+\\-*]";
    Pattern p = Pattern.compile(patron);
    Matcher m = p.matcher(linea);
    int columna = 1;

    while (m.find()) {
        String tokenString = m.group();
       
        
        
        
    if (linea.length() > 80) {
       // tokens.add(new Token(TokenType.ERROR, "La línea física no puede tener más de 80 caracteres.", numeroLinea, 1));
        //System.out.println("La línea física no puede tener más de 80 caracteres.");
        return;
    }
    
  

        if (!validarLongitudLinea()) {
            tokens.add(new Token(TokenType.ERROR, "La línea física no puede tener más de 80 columnas o caracteres", numeroLineaFormateado, 1));
            System.out.println("La línea física no puede tener más de 80 columnas o caracteres");
            return;
        }
      // Si encontramos un identificador precedido por "int", lo agregamos a la tabla de símbolos
        

 
         if (isEspacio(tokenString)) {
                tokens.add(new Token(TokenType.SPACE, tokenString,numeroLineaFormateado, columna));
                continue;
            }
         
          if (isComentario(tokenString)) {
               tokens.add(new Token(TokenType.COMENTARIO, tokenString,numeroLineaFormateado, columna));
                continue;
            }
          
           if (ismulticomentario(tokenString)) {
               tokens.add(new Token(TokenType.COMENTARIO_MULTILINEAL, tokenString, numeroLineaFormateado, columna));
                continue;
            }
           
      

        if (isPalabraReservada(tokenString)) {
            
            tokens.add(new Token(TokenType.PALABRAS_RESERVADAS, tokenString,numeroLineaFormateado, columna));
        } else if (isparentesisapertura(tokenString)) {
            tokens.add(new Token(TokenType.PARENTESIS_ABRE, tokenString, numeroLineaFormateado, columna));
        } else if (isparentesiscierre(tokenString)) {
            tokens.add(new Token(TokenType.PARENTESIS_CIERRA, tokenString, numeroLineaFormateado, columna));
        } else if (isNumeroEntero(tokenString)) {
            tokens.add(new Token(TokenType.ENTERO, tokenString, numeroLineaFormateado, columna));
        } else if (isNumeroReal(tokenString)) {
            tokens.add(new Token(TokenType.REAL, tokenString, numeroLineaFormateado, columna));
        } else if (isCadena(tokenString)) {
            tokens.add(new Token(TokenType.CADENA, tokenString, numeroLineaFormateado, columna));
        } else if (isIdentificadorValido(tokenString)) {
            tokens.add(new Token(TokenType.IDENTIFICADOR, tokenString, numeroLineaFormateado, columna));
        } else if (iscoma (tokenString)) { tokens.add(new Token(TokenType.COMMA,tokenString, numeroLineaFormateado, columna)); }
        else if (isoperadoresaritmeticos(tokenString)) {
            
            tokens.add(new Token(TokenType.OPERADORES_ARITMETICOS, tokenString, numeroLineaFormateado, columna));
        }
         else if (isPunto(tokenString)) { tokens.add(new Token(TokenType.PUNTO,tokenString, numeroLineaFormateado, columna)); }
          else if (isdospuntos (tokenString)) { tokens.add(new Token(TokenType.DOSPUNTOS,tokenString, numeroLineaFormateado, columna)); }
        
        else if (ispuntoycoma (tokenString)) { tokens.add(new Token(TokenType.COLON,tokenString, numeroLineaFormateado, columna)); }
       // else if (iscomillla(tokenString)) { tokens.add(new Token(TokenType.COMILLA,tokenString, numerolinea, columna)); }
            else if (iscorcheteapertura(tokenString)) { tokens.add(new Token(TokenType.CORCHETEAPER,tokenString, numeroLineaFormateado, columna)); }
            else if (iscorchetecierre(tokenString)) { tokens.add(new Token(TokenType.CORCHETECIERRE,tokenString, numeroLineaFormateado, columna)); }
            else if (isparentesiscuadradoaper(tokenString)){tokens.add(new Token(TokenType.CUADRADOAPER,tokenString,numeroLineaFormateado,columna));}
            else if (isparentesiscuadradocierre(tokenString)){tokens.add(new Token(TokenType.CUADRADOCIERRE,tokenString,numeroLineaFormateado,columna));}
            
             else if (isdosparentesis(tokenString)){tokens.add(new Token(TokenType.DOSPARENTESIS,tokenString,numeroLineaFormateado,columna));}
             
             else if (isparentesiscoma(tokenString)){tokens.add(new Token(TokenType.PARENTESISCOMA,tokenString,numeroLineaFormateado,columna));}
                          else if (isshort(tokenString)){tokens.add(new Token(TokenType.SHORT,tokenString,numeroLineaFormateado,columna));}
               else if (isenteronegativo(tokenString)){tokens.add(new Token(TokenType.ENTERO_NEGATIVO,tokenString,numeroLineaFormateado,columna));}

        
        else {
            tokens.add(new Token(TokenType.ERROR, tokenString,numeroLineaFormateado, columna));
        }
        columna += tokenString.length();
    }
    
   
    
 
}
    
    
        
  
    
    
   

    private int getStartColumn(int index, String[] tokensLinea) {
        int startColumn = 0;
        for (int i = 0; i < index; i++) {
            startColumn += tokensLinea[i].length() + 1;
        }
        return startColumn;
    }

    private int getSiguientePosicion(int column, String tokenString) {
        return column + tokenString.length();
    }

    public boolean isPalabraReservada(String tokenString) {
        for (String palabraReservada : PALABRAS_RESERVADAS) {
            if (palabraReservada.equals(tokenString)) {
                return true;
            }
        }
        return false;
    }
    
    
    
    
    
    public boolean isparentesisapertura(String tokenString){
     return tokenString.matches("\\(");
    }
    
    public boolean isparentesiscierre(String tokenString){
     return tokenString.matches("\\)");
    }
    
    public boolean isdosparentesis(String tokenString){
    return tokenString.matches("[();]");
    }
    
    public boolean isparentesiscoma(String tokenString){
     return tokenString.matches("\\);");
    }
    
    public boolean iscoma(String tokenString){
     return tokenString.matches("\\,");
    }
    
    public boolean isenteronegativo(String tokenString){
    return tokenString.matches("-?\\d+");
    }
     public boolean isshort(String tokenString){
    return tokenString.matches("-?\\d+\\.\\d+|-?\\d+");
    }
    
    private boolean ispuntoycoma(String tokenString){
     return tokenString.matches("\\;");
    }
     private boolean iscorcheteapertura(String tokenString){
     return tokenString.matches("\\{");
    }
      private boolean iscorchetecierre(String tokenString){
     return tokenString.matches("\\}");
    }
       private boolean isparentesiscuadradoaper(String tokenString){
     return tokenString.matches("\\[");
    }
         private boolean isparentesiscuadradocierre(String tokenString){
     return tokenString.matches("\\]");
    }
         
           private boolean isoperadoresaritmeticos(String tokenString){
    return tokenString.matches("[+\\-*/%==!=<>]+");
    }
         
         /*private boolean iscomillla(String tokenString){
             
              return tokenString.contains("\"");
         }*/
    

    public boolean isIdentificadorValido(String tokenString) {
   return tokenString.matches("^[a-zA-Z][_\\$a-zA-Z0-9]*$") && !isPalabraReservada(tokenString);
    }
    
    private boolean isPunto(String tokenString){
     return tokenString.matches("\\.");
    
    
    }
    
     private boolean isdospuntos(String tokenString){
     return tokenString.matches("\\:");
    
    
    }
     
     private boolean ismulticomentario(String tokenString){
      return tokenString.matches("(\\/\\/[^\\n]*|\\/\\*(.|[\\r\\n])*?\\*\\/)");
     }
     
     
     
     
     

    private boolean isNumeroEntero(String tokenString) {
        return tokenString.matches("^[0-9]+$");
    }

    private boolean isNumeroReal(String tokenString) {
        return tokenString.matches("^[0-9]+\\.[0-9]+$");
    }

    private boolean isCadena(String tokenString) {
        return tokenString.matches("^\"[^\"]*\"$");
    }
    
      public boolean isEspacio(String tokenString) {
        return tokenString.matches("\\s+");
    }

    // Método para verificar si una cadena es un comentario que comienza con //
    public boolean isComentario(String tokenString) {
        return tokenString.startsWith("//");
    }
    
    
    
    private boolean validarLongitudLinea() {
    return linea.length() <= 80;
}

private boolean validarMultilinea() {
    return !linea.contains("\n") && !linea.contains("\r");
}

private boolean validarComandos() {
    String[] comandos = linea.trim().split("\\s+");
    for (String comando : comandos) {
        if (!isIdentificadorValido(comando) && !isNumeroValido(comando)) {
            return false;
        }
    }
    return true;
}

private boolean isNumeroValido(String comando) {
    
      String numero = null;
   try {
     
            Double.parseDouble(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
}



    public List<Token> getTokens() {
        return tokens;
    }
    
    
}
