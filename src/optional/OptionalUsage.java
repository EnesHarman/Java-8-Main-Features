package optional;

import java.util.Optional;

public class OptionalUsage {
    //Optional uses to avoid NullPointException
    public static void main(String[] args) {
        //Creating Optional Objects
        String name= "Emir";
        Optional<String> personOfVar = Optional.of(name); //name variable can not be null here.
        Optional<String> personOfString = Optional.of("Enes");
        Optional<String> personOfNullableVar = Optional.ofNullable(name); //name variable can be null
        Optional<String> personEmpty = Optional.empty(); //Null Object

        //.orElse()
        String personOrElse = Optional.of(name).orElse("Enes"); //If name is null, personOrElse will be Enes

        //Checking Values with .isPresent() , .isEmpty()
        if(personOfNullableVar.isPresent()){
            System.out.println("Hello "+personOfNullableVar.get()); //.get() returns value of Optional object.
        }
        else{
            System.out.println("There is a null value but I can't see any NullPointException.");
        }

        //.ifPresent() : If you don't want to write long if else statements, you can use .ifPresent()
        personOfNullableVar.ifPresent(opValue->System.out.println("Hello" +opValue));

        //.orElseThrow() : You can throw your own errors with this function
        personOfNullableVar.orElseThrow(IllegalArgumentException ::new);

        //.filter() : It's used for conditional returns.
        personOfNullableVar.filter(personName-> personName=="Enes"); //If personOfNullableVar' s value is not Enes, it will return empty Optional object.

        /*
        Usage Tips
            Assume you have a Rest API that does basic CRUD operations. If you use Optional objects in the controller layer,
        you can get many variables for filtering in one endpoint. Then you can check these optional variables in the service
        layer and create your queries for filtering, etc.
            You can use Optional objects in the service layer to check data that comes from the Repository layer.
        In this way, you can avoid NullPointException and your app will not crash.
*/
    }

}
