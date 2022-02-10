package interfaceMethods;

public class InterfaceMethodsExample {
    public static void main(String[] args) {
        ClassOne classOne = new ClassOne();
        ClassTwo classTwo = new ClassTwo();

        System.out.println("--ClassOne Methods--");
        classOne.existingMethod();
        classOne.newDefaultMethod();

        System.out.println("--ClassTwo Methods--");
        classTwo.existingMethod();
        classTwo.newDefaultMethod();
        
        ExistingInterface.newStaticMethod();
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

class ClassOne implements ExistingInterface{

    @Override
    public void existingMethod() {
        System.out.println("Overridden abstract method from ClassOne.");
    }

    @Override
    public void newDefaultMethod() {
        System.out.println("This method comes from super class and it has overridden in ClassOne");
    }
}

class ClassTwo implements  ExistingInterface{
    @Override
    public void existingMethod() {
        System.out.println("Overridden abstract method from ClassTwo.");
    }
    //newDefaultMethod() can use with this class.
}

/*
Usage Tips
    If you have an interface that many classes implement and you want to add methods to that interface without changing all classes, you can use these methods.
 */
