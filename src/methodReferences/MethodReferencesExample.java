package methodReferences;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@FunctionalInterface
interface SumOperation{
    long sumNumbers(long number1, long number2);
}

@FunctionalInterface
interface Messageable{
    Message getMessage(String msg);
}
class Message{
    Message(String msg){
        System.out.print(msg);
    }
}

class Calculator{
     long sumInputsWithExtraOperation(List<Long>inputs, Function<Long,Long> operation){
        long result = 0;
        for (Long input: inputs) {
            result+=operation.apply(input);
        }
        return  result;
    }
}

class Operations{
    static long divideTwo(long number){
        return number/2;
    }

    static  long divideFour(long number){
        return number/4;
    }

    static  long square(long number){
        return number*number;
    }
}

public class MethodReferencesExample {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        SumOperation sumOperation = (num1, num2) -> num1+num2;
        List<Long> numbers = Arrays.asList(1L,2L,3L,4L,5L,6L);
        Long result = 0L;

        result = calculator.sumInputsWithExtraOperation(numbers,new Function<Long,Long>(){ //Using anonymous class
            @Override
            public Long apply(Long number){
                return Operations.divideTwo(number);
            };
        });
        System.out.println("Result with anonymous class : "+result);

        result = calculator.sumInputsWithExtraOperation(numbers, i->Operations.divideTwo(i)); //using lambda expression
        System.out.println("Result with lambda expression class : "+result);

        result = calculator.sumInputsWithExtraOperation(numbers, Operations::divideTwo); //using Static Method reference
        System.out.println("Result with Static Method reference class : "+result);

        result = sumOperation.sumNumbers(2,7);
        System.out.println("Result with functional interface: " +result);

        Messageable messageable = str->new Message(str);
        messageable.getMessage("Message from constructor reference with lambda expression");
        //or
        Messageable messageable1 = Message::new;
        messageable1.getMessage("Message from constructor reference with Method reference");
    }
}
