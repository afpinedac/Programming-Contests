/*
 * Aqui ese muestran algunos de los conceptos y pruebas de las expresiones 
 * regulares en JAVA
 */
package WellKnown.DataStructures;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 *  SIMBOLOS
 * 
 *    \ :  Escapar
 *    . : Cualquier caracter
 *    * : El patron se repite 0 a mas veces
 *    ? : se repite 0 o 1 vez (opcional)
 *    + : se repite 1 o mas veces
 *    {x,y} : se repite x veces hasta un maximo de y
 *    [] : conjunto de caracteres
 *    - :Rango de caracteres
 *    () : Agrupación o patrón -> todos, se puede referencias luego
 *    | expresión alternativa 
 *    ^ Inicio de la cadena o negación del conjunto de caracteres
 *    $ final de la cadena
 *    
 *  CARACTERES GENERICOS
 * 
 *    \w cualquier caracter
 *    \W cualquier NO caracter
 *    \d culaquier digito
 *    \D cualquier no digito
 *    \s cualquier espacio en blanco, tabulador
 *    \S cualquier no espacio
 *    \b busca emparejamiento a partir de un limite de palabra
 *    \B lo contario de \b
 * 
 *  EJEMPLOS
 *  
 *   ^c : que inicie con la letra c
 *   c$ : que termine con la letra c
 *   c+ : el caracter c 1 o mas veces
 *   c* : el caracter c 0 mas veces
 *   c? : el caracter c 0 o 1 vez
 *   \n : nueva linea
 *   \t : tabulador
 *   \  : escape para escribir adelante de caracteres especiales
 *  (cd): caracteres agrupados
 *  c|d : c ó d
 *  c{n} : el caracter c n veces
 *  c{n,} el caracter c n o mas veces
 *  c{n,m} el caracter c n hasta m veces
 * 
 * 
 * 
 * 
 */
public class RegularExpressions {

    public static void main(String[] args) {





        Pattern p = Pattern.compile("\\d");
        Matcher m = p.matcher("abcd");
        if (m.find()) {
            System.out.println("cumple");
        } else {
            System.out.println("No cumple");
        }



      




    }
}
