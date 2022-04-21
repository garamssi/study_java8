package com.example.me_garamssi;


/**
 * 1. 메소드가 여러개 있어도 추상 메소드가 1개이면 추상 인터페이스이다.
 * 2. @FunctionalInterface 를 자바가 제공하고 @FunctionalInterface을 선언하고 위반(추상 메서드 2개 이상)을 하면 에러가 난다.
 * */

@FunctionalInterface
public interface RunSomething {

        // 추상 메서드가 하나가 있으면 함수형 인터페이스
        void doIt();
//        void doAgain();

//        public 생략 가능
        static void printName() {
                System.out.println("garam");
        }

        default void printAge() {
                System.out.println("30");
        }


        // 추상 메서드가 2개가 있으면 함수형 인터페이스가 아니다.
//        void doItSomething();
}
