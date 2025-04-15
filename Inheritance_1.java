class SuperClass {
    private int privatVar = 10;  // Private member

    public int getPrivateVar() {  // Getter method
        return privatVar;
    }
}

class SubClass extends SuperClass {
    public void display() {
        //System.out.println(privatVar); // This will cause an error (private access)
        System.out.println("Private variable accessed via method: " + getPrivateVar());
    }
}

public class Inheritance_1 {
    public static void main(String[] args) {
        SubClass obj = new SubClass();
        obj.display();
    }
}

