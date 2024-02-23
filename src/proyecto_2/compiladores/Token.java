/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_2.compiladores;

/**
 *
 * @author Sebastian
 */
public class Token {
    
      private final TokenType type;
    private final String linea;
    private final int columna;
    private final String lexeme;
 
 public Token(TokenType type, String lexeme, String linea, int columna) {
        this.type = type;
        this.lexeme = lexeme;
        this.linea = linea;
        this.columna = columna;
    }

    public TokenType getType() {
        return type;
    }

    public String getLexeme() {
        return lexeme;
    }

    public String getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }

    public String getValue() {
        if (type == TokenType.ENTERO || type == TokenType.REAL || type == TokenType.IDENTIFICADOR || type == TokenType.CADENA || type == TokenType.PARENTESIS_ABRE|| type == TokenType.PARENTESIS_CIERRA) {
            return lexeme;
        } else {
            return type.toString();
        }
    }

    public String toString() {
        return "Token{type=" + type + ", lexeme='" + lexeme + "', linea=" + linea + ", columna=" + columna + "}";
    }
    

   
}

enum TokenType {
    BEGIN, CHAR, ELSE, END, IF, INTEGER, MODULE, READ, READINT, READREAL, REAL,
    REPEAT, RETURN, THEN, UNTIL, VAR, WRITE, WRITEINT, WRITELN, WRITEREAL, WRITESTRING,COMENTARIO,

    // Identificadores y literales
    PALABRA_RESERVADA, IDENTIFICADOR, INTEGER_LITERAL, REAL_LITERAL, STRING_LITERAL,

    // Operadores
    PLUS, MINUS, MULTIPLY, DIVIDE, ASSIGNMENT, EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_OR_EQUALS,
    GREATER_THAN, GREATER_THAN_OR_EQUALS, AND, OR, NOT,SPACE, OPERADORES_ARITMETICOS,DOSPARENTESIS, PARENTESISCOMA,ENTERO_NEGATIVO,REAL_NEGATIVO,SHORT,

    // Símbolos de puntuación
    COMMA, SEMICOLON, COLON, PARENTESIS_ABRE, PARENTESIS_CIERRA, LEFT_BRACKET, RIGHT_BRACKET, LEFT_BRACE, RIGHT_BRACE,COMILLA,
    PALABRAS_RESERVADAS, READ_INT,PUNTO,DOSPUNTOS, SIMBOLO,SIMBOLOPEGADO,CADENA,ENTERO,LINEAENBLANCO,PALABRASRESERVADAS_MODULA2, CORCHETEAPER,CORCHETECIERRE, CUADRADOAPER,CUADRADOCIERRE,
    ERROR,COMENTARIO_MULTILINEAL,

    // Fin de archivo
    EOF
}




class LexerException extends Exception {
    public LexerException(String message) {
        super(message);
    }
    
}
