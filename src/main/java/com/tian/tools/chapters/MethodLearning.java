//package chapters;

public class MethodLearning {
    private static int testParameters(int a, int b){
        a = 1;
        return b;
    }

    private static TestClass testParameters(TestClass obj){
        obj.a = 1;
        TestClass obj2 = new TestClass(obj.a, obj.b);
        return obj2;
    }

    public static void main(String[] args){
        int a = 0;
        int b = 1;
        int c = testParameters(a, b);
        Print.print("I am printed by print");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        System.out.println("===========================");
        TestClass testObject0 = new TestClass();
        System.out.println(testObject0.a);
        System.out.println(testObject0.b);

        System.out.println("===========================");
        TestClass testObject = new TestClass(a, b);
        int d = testParameters(testObject.a, testObject.b);
        System.out.println(testObject.a);
        System.out.println(testObject.b);
        System.out.println(d);

        System.out.println("===========================");
        TestClass obj2 = testParameters(testObject);
        System.out.println(obj2.a);
        System.out.println(obj2.b);
       
        System.out.println("===========================");
        System.out.println(testObject.a);
        System.out.println(testObject.b);   

        if(testObject == obj2){
            System.out.println("testObject == obj2");
        }
    }
}

class TestClass{
    int a;
    int b;

    public TestClass(){
    }

    public TestClass(int a, int b){
        this.a = a;
        this.b = b;
    }

    public void setA(int a){
        a = a;
    }

    public void setB(int b){
        b = b;
    }

    public int getA(){
        return a;
    }

    public int getB(){
        return b;
    }
}

class Print{
    public static void print(String output){
        System.out.println(output);
    }
}
