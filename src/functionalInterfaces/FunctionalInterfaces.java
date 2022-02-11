package functionalInterfaces;

public class FunctionalInterfaces {
    /*Functional interfaces are interfaces that can collect only one abstract method.
      A functional interface can collect many static or default methods.
      Lambda Expressions are used to declare instances of functional interfaces.
      @FunctionalInterface annotation is used to tell the compiler interface is a functional interface.
      In this way, if there is a problem with functional interface rules, the compiler will throw an error.
      You can check Runnable interface for a good example.*/

    @FunctionalInterface
    interface Square{
        int getSquare(int value);
    }
    @FunctionalInterface
    interface Sum{
        int getSum(int value1, int value2);
    }
    @FunctionalInterface
    interface CheckPositive{
        boolean checkPositiveOfNumber(int value);
    }


    public static void main(String[] args) {
        int number1 = 4;
        int number2 = 8;

        Square square = (int input) ->input*input; // 1 Variable
        System.out.println("Square of "+number1 +" is :" + square.getSquare(number1));

        Sum sum = (int input1, int input2)->input1+input2; // 2 Variable
        System.out.println("Sum of "+number1 + " and " + number2+" is :" + sum.getSum(number1,number2));

        CheckPositive checkPositive = (int input)->{ // 1 Variable with condition
            int number = sum.getSum(input ,-5);
            if(number >0){
                return  true;
            }
            else{
                return  false;
            }
        };

        System.out.println(checkPositive.checkPositiveOfNumber(6));
    }
}

