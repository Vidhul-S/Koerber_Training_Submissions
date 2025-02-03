import java.util.HashSet;
import java.util.Set;

public class Trial {
    public static void main(String []args){
        Trial t = new Trial();
        t.prime(100000000);
        System.out.println(t);
        String s = "Hello";
        for(char c :s.toCharArray()){
            System.out.println("It works");
        }
    }
    static Set<Integer> primeNumber = new HashSet<>();
    public Trial(){
        primeNumber.add(2);
    }
    public Set<Integer> prime(int n){

        for(int j=0;j<=n;j++){

            int c=0;
            for(Integer i : primeNumber){

                if (j % i == 0) {
                    c++;
                }
            }
            if(c == 0){
                primeNumber.add(j);
            }
        }
        return primeNumber;
    }
}

