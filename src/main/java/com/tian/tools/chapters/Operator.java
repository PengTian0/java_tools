
import java.util.*;

class Value {
    int i;
}
public class Operator{
    public static void main(String[] args){
        double a = 4.3;
        System.out.println(+a);
        a = 0.2;
        double b = 1 * -a;
        System.out.println(+b);
        System.out.println(a);

        Value v1 = new Value();
        Value v2 = new Value();
        v1.i = v2.i = 100;
        System.out.println(v1.equals(v2)); //false
        System.out.println(v1 == v2); //false
    }
}
