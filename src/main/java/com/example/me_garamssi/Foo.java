package com.example.me_garamssi;

import java.util.function.*;

public class Foo {

        // psvm
        public static void main(String[] args) {
//                 익명 내부 클래스
//               RunSomething runSomething = new RunSomething() {
//                       @Override
//                       public void doIt() {
//                               System.out.println("Hello");
//                       }
//               };

//                 람다 표현식
//                RunSomething runSomething = () -> System.out.println("Hello");
//                RunSomething runSomething = () -> {
//                        System.out.println("Hello");
//                        System.out.println("가람");
//                };

//                runSomething.doIt();

                /**
                 *
                 * 클래스를 만들어 Function을 implements(plus10)를 하여서 만든 메소드와 람다 8을 사용해 바로 만드는 메소드 예시
                 * */
                plus10 plusTen1 = new plus10();
                System.out.println(plusTen1.apply(1));

                Function<Integer, Integer> plusTen2 = (i) -> i + 10;
                plusTen2.apply(11);

                Function<Integer, Integer> multiply2 = (i) -> i * 2;

                /**
                 * compose 인자 값(함수)을 먼저 실행한 뒤, 해당 리턴 값으로 앞의 함수를 실행한다.
                 * */
                // 값을 먼저 i*2를 하고난 리턴 값에 + 10을 한다.
                Function<Integer, Integer> multiply2AndPlus10 = plusTen2.compose( multiply2 );

                //14
                System.out.println(multiply2AndPlus10.apply(2));

                /**
                 * andTen 앞의 함수를 먼저 실행하고 리턴 값으로 뒤의 함수를 실행한다.
                 * */
                System.out.println(plusTen2.andThen(multiply2).apply(2));


                /**
                 * Consumer 매개변수를 받아서 리턴값이 없고 실행만 해준다.
                 * */
                Consumer<Integer> printT = (i) -> System.out.println(i);
                printT.accept(10);

                /**
                 * Supplier 어떤 값을 받아 올 것이냐 -> 인자가 없이 무조건 반환 값으로 사용 됨
                 * */
                Supplier<Integer> get10 = () -> 10;

                // 무조건 10을 반환하는 함수
                System.out.println(get10);

                /**
                 * Predicate 어떠한 인자 값을 하나 받아서 true, false를 반환해주는 메소드
                 * */
                Predicate<String> startWithRam = (s) ->s.startsWith("ram");
                // or, and, negate ( not )을 조합해서 사용할 수 있다.


                /**
                 * UnaryOperator 입력받는 매개변수와 리턴 값이 같을 때 사용
                 * */
                UnaryOperator<Integer> plusTen = (i) -> i + 10;




        }

}
