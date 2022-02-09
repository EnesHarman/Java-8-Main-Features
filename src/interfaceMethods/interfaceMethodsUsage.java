package interfaceMethods;

public class interfaceMethodsUsage {
    public static void main(String[] args) {
        //Static and default interface methods are used when we want to add a method to our interface with don't change existing classes that implement our interface.
    }
}
interface ExistingInterface{
    public void existingMethod();

    default void newDefaultMethod(){
        System.out.println("This is a default method. We don't need to override this method in classes.");
    }

    static  void  newStaticMethod(){
        System.out.println("This is a static method. We can not override this method in classes.");
    }
}

class Class1 implements ExistingInterface{

    @Override
    public void existingMethod() {
        System.out.println("This method is normal. We have overridden it from interface.");
    }

    //newDefaultMethod() can use with this class.
    //newStaticMethod() can use with this class.
}

class Class2 implements  ExistingInterface{
    @Override
    public void existingMethod() {
        System.out.println("This method is normal. We have overridden it from interface.");
    }

    //newDefaultMethod() can use with this class.
    //newStaticMethod() can use with this class.
}

/*
Usage Tips
    If you have an interface that many classes implement and you want to add methods to that interface without changing all classes, you can use these methods.
 */
