package com.example.me_garamssi;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

public class Lambda {
        public static void main(String[] args) {
                Supplier<Integer> get10 = () -> 10;

                BinaryOperator<Integer> sum = (a, b) -> a + b;

                /**
                 * 람다 변수 캡처
                 * */
                Lambda lambda = new Lambda();
                lambda.run();

        }

        private void run() {
                // final 변수를 생략 할 수 있는 경우는 해당 변수가 사실상 final인 경우
                // fianl -> 변경 불가 ( effective final )
                final int baseNumber = 10;

                // 내부 로컬 클래스
                class LocalClass {
                        void printBaseNumber() {
                                int baseNumber = 11;
                                System.out.println(baseNumber); // 11
                        }
                }

                // 익명 클래스에서 로컬 variable 참조
                Consumer<Integer> integerConsumer = new Consumer<Integer>() {
                        @Override
                        public void accept(Integer baseNumber) {
                                System.out.println(baseNumber);
                        }
                };

                /**
                 * 람다와 (로컬 클래스, 익명 클래스) 다른 점은 쉐도윙의 차이다.
                 * 쉐도윙이란 스코프의 차이다. 로컬, 익명 클래스는 해당 클래스의 안에 baseNumber 선언이 가능하고 해당 baseNumber를 사용 했을 때
                 * 내부 baseNumber 사용하지만 람다는 스코프가 상위 클래스와 동일하여 상위 클래스에 baseNumber가 선언되어 있다면 baseNumber를 내부에서
                 * 선언 할 수 없다 ( 자바는 동일한 스코프에서 동일한 변수 이름을 선언 할 수 없다 라는 특징 )
                 * */

                // 람다에서 로컬 variable 참조
//                IntConsumer printInt = (baseNumber) -> {  : 같은 스코프로 에러가 난다.
                IntConsumer printInt = (i) -> {
                        System.out.println(i + baseNumber);
                };

                printInt.accept(10);
        }

}
