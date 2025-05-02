import arbitraryarithmetic.*;
//project java

public class MyInfArith {

    public static void main(String[] args) {

        String type = args[0];
        String operation = args[1];
        String op1 = args[2];
        String op2 = args[3];

        switch (type) {
            case "int" ->                 {
                    Ainteger a=Ainteger.parse(op1);
                    Ainteger b=Ainteger.parse(op2);
                    switch (operation) {
                        case "add" ->
                            System.out.println(a.add(b));
                        case "sub" ->
                            System.out.println(a.subtract(b));
                        case "mul" ->
                            System.out.println(a.multiply(b));
                        case "div" ->
                            System.out.println(a.divide(b));
                        default ->
                            System.out.println("Invalid operation");
                    }                      }
            case "float" ->                 {
                    AFloat a = AFloat.parse(op1);
                    AFloat b = AFloat.parse(op2);
                    switch (operation) {
                        case "add" ->
                            System.out.println(a.add(b));
                        case "sub" ->
                            System.out.println(a.subtract(b));
                        case "mul" ->
                            System.out.println(a.multiply(b));
                        case "div" ->
                            System.out.println(a.divide(b));
                        default ->
                            System.out.println("Invalid operation");
                    }                      }
            default -> System.out.println("Invalid type (int/float expected)");
        }
    }
}
