package Balance;

import B.A;

class B extends A {
    public static void main(String args[]) { 
        A obj = new A();
        obj.m1(); // ✅ Accessible (public)

        // obj.m3(); //  Not accessible (default access)
        // obj.m4(); //  Not accessible (private access)

        B obj2 = new B();
        obj2.m2(); // ✅ Accessible (protected, accessed through subclass)
    }
}

