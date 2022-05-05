package com.example.me_garamssi.n3_apiDefaultMethodAndStaticMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class App {
        public static void main(String[] args) {
                List<String> name = new ArrayList<>();
                name.add("1");
                name.add("2");
                name.add("3");
                name.add("4");
                name.add("5");

                //순차 정렬
//                name.sort(String::compareToIgnoreCase);

                // 반대 정렬
//                name.sort(compareToIgnoreCase.reversed().thenComparing());

//                name.forEach( (s) -> {
//                        System.out.println(s);
//                });

                // iterator란 배열, 순회 할 수 있는 자료구조
//                name.forEach(System.out::println);

                // 순회하면서 하나씩 넘기면서 출력한다 더이상 순회할 것이 없으면 false를 반환하여 while을 종료한다.
                Spliterator<String> spliterator = name.spliterator();

                // trySplit()를 사용하면 반으로 나누어 저장한다.
                Spliterator<String> spliterator1 = spliterator.trySplit();

                while (spliterator.tryAdvance(System.out::println));
                System.out.println("==========================");
                while (spliterator1.tryAdvance(System.out::println));


                /**
                 * 더이상 미리 만들어 놓은 추상 클래스를 사용하지 않는 추세!
                 * why? 인터페이스에서 default 메소드를 대체 할 수 있기 때문에..
                 * */






        }
}
