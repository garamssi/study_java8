package com.example.me_garamssi.basicInterfaceAndStaticMethod;

public class DefaultFoo implements Foo, Bar {

        String name;

        public DefaultFoo(String name) {
                this.name = name;
        }

        @Override
        public void printName() {
                System.out.println(this.name);
        }

        @Override
        public String getName() {
                return this.name;
        }

//        @Override
//        public void printNameUpperCase() {
//                System.out.println("test");
//        }
}