package Balance;

class Account2 {
    void Method_2() {
        System.out.println("Method of Second class");
    }

    public static void main(String args[]) {
        Account obj = new Account(500.75); // Providing initial balance
        obj.Display_Balance();

        Account2 obj2 = new Account2(); // Creating an instance of Account2
        obj2.Method_2();
    }
}
