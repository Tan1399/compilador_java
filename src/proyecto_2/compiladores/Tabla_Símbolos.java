/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_2.compiladores;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sebastian
 */
public class Tabla_Símbolos {
    
  private HashMap<String, String> tabla;

    public Tabla_Símbolos() {
        tabla = new HashMap<String, String>();
    }

    public void agregarSimbolo(String lexema, String tipo) {
        tabla.put(lexema, tipo);
    }
    public String obtenerTipo(String identificador) {
        return tabla.get(identificador);
    }

    public boolean existeSimbolo(String identificador) {
        return tabla.containsKey(identificador);
    }
        public String getTipoSimbolo(String identificador) {
        if (tabla.containsKey(identificador)) {
            return tabla.get(identificador);
        } else {
            return null;
        }
    }
        
        
         public boolean existeSimboloConTipoDiferente(String identificador) {
        if (tabla.containsKey(identificador)) {
            String tipoExistente = tabla.get(identificador);
            return !tipoExistente.equals(identificador);
        }
        return false;
    }


    public void imprimirTabla() {
        System.out.println("Tabla de Símbolos:");
        for (String lexema : tabla.keySet()) {
            String tipo = tabla.get(lexema);
           System.out.println("Lexema: " + lexema + " Tipo: " + tipo);
        }
    }
    
    
    
    
}
