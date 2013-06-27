package WellKnown.Matematicas;

public class PrimalityTest {
    
  

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i=i+2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8,9,19,24,27,23};
        for (int x : a) {
            System.out.println(x + "=" + isPrime(x));
        }

    }
}
