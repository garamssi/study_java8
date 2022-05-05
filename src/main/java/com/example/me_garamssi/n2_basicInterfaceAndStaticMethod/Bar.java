package com.example.me_garamssi.n2_basicInterfaceAndStaticMethod;

public interface Bar extends Foo{

        /**
         * 1. 만약에 Foo에서 제공하는 printNameUpperCase 를 제공하지 않다면 추상메소드로서 정의하면 Bar를 상속 받은 인스턴스는
         * printNameUpperCase 오버라이딩 하지 않아도 된다. 하지만 만약 사용한다면 모든 인스턴스에 재정의를 해줘야한다.
         * */
//        void printNameUpperCase();

//        default void printNameUpperCase() {
//                System.out.println("test");
//        };
}
