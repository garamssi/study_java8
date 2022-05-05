package com.example.me_garamssi.n2_basicInterfaceAndStaticMethod;

public class App {

        public static void main(String[] args) {
                Foo foo = new DefaultFoo("garam");
                foo.printName();
                foo.printNameUpperCase();

                Foo.printAnything();
        }
}
