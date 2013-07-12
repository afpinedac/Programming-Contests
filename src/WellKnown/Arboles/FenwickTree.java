package WellKnown.Arboles;

import java.util.Arrays;


/*
 * 
 * Este es un arbol de frecuencias acumuladas 
 * sirve para solucionar el problema del RSQ(Range Sum Query) 
 * 
 * 
 */
public class FenwickTree {

    static int ft[];

    /*
     * Aumenta el valor de la posicion k v veces, ademas de actualizarlo hasta 
     * que termine el vector
     * 
     */
    static void ft_adjust(int k, int v) {
        while (k < ft.length) {
            ft[k] += v;
            k += LSOne(k);
        }
    }

    /*
     * devuelve la frecuencia acumulada desde 1 hasta b  
     */
    static int ft_rsq(int b) {
        int s = 0;
        while (b > 0) {
            s += ft[b];
            b -= LSOne(b);
        }
        return s;
    }

    /*
     * Devuelve la frencuencia acumulada desde [a,b]
     */
    static int ft_rsq(int a, int b) {
        return ft_rsq(b) - ((a == 1) ? 0 : ft_rsq(a - 1));
    }

    /*
     * Devuelve el 1 menos significate (Less Significant One)
     */
    static int LSOne(int v) {
        return (v) & (-v);
    }

    public static void main(String[] args) throws Exception {

        ft = new int[9];
         ft_adjust(5, 4);
         ft_adjust(8, 2);
         ft_adjust(3, 2);
        System.out.println(ft_rsq(1, 8));

        System.out.println(Arrays.toString(ft));






    }
}
