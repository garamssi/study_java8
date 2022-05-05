package com.example.me_garamssi.n1_methodRef;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

        public static void main(String[] args) {
//                Function<Integer, String> intToString = (i) -> "number";

                // UnaryOperator : 입력 값과 리턴 타입이 같을 경우 사용
                /**
                 * 메소드 레퍼런스란, :: 두개를 사용해서 클래스 :: 메소드 를 사용하겠다.
                 *
                 * 타입::스태틱메소드
                 * 갹체 레퍼런스::인스턴스 메소드
                 * 타입::인스턴스 메소드
                 * 타입::new
                 * */
//                UnaryOperator<String> hi = (s) -> "hi" + s;
                UnaryOperator<String> hi = Greeting::hi;



                // 이렇게도 참조 할 수 있다.
                Greeting greeting = new Greeting();
                UnaryOperator<String> hello = greeting::hello;
                // apply를 해야 실제 hello 메소드를 사용할 수 있다.
                hello.apply("something else");



                // 입력값은 없는데 리턴 타입은 있는 것... -> 생성자
                Supplier<Greeting> newGreeting = Greeting::new;
                // new로 끝나서 만들어지는 것이 아니라 get까지 사용해야 만들어진다
                newGreeting.get();


                // 아래 2개의 객체를 생성해 내고 있지만 서로 다른 레퍼런스를 가지고 있다.
                Function<String, Greeting> garamGreeting
                        = Greeting::new;

                Greeting garam = garamGreeting.apply("garam"); // 그리팅이 만들어지면서 garam을 넣은 채로 그리팅을 반환한다.
                System.out.println(garam.getName());

                Supplier<Greeting> garamGreeting2 = Greeting::new;
                garamGreeting2.get(); // 서플라이는 반환 값이 없음

                String[] names = { "garam", "arams", "toby" };


                // 임의의 객체 레퍼런스 참조
//                Arrays.sort(names, new Comparator<String>() {
//                        @Override
//                        public int compare(String o1, String o2) {
//                                return 0;
//                        }
//
//                        @Override
//                        public boolean equals(Object obj) {
//                                return false;
//                        }
//                });

                // new Comparator<String>이 함수형 인터페이스이기 때문에 위의 문법을 아래와 같이 변경 가능하다.
                Arrays.sort(names, String::compareToIgnoreCase);
                System.out.println(Arrays.toString(names));


        }
}
