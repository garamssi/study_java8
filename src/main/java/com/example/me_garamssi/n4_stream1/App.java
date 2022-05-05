package com.example.me_garamssi.n4_stream1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
        public static void main(String[] args) {
                List<String> names = new ArrayList<>();
                names.add("1");
                names.add("2");
                names.add("3");
                names.add("4");
                names.add("5");

                /**
                 * 중개 오퍼레이터(이어지는) - lazy, 터미널 오퍼레이터(종료)
                 *
                 * 1. 기본적으로 중개형 오퍼레이터는 터미널 오퍼레이터가 오기전까지 실행을 하지 않는다.
                 *      - 종료형 오퍼레이터가 반드시 하나가 있어야 유의미한 스트림이 된다.
                 * 2.
                 * * */

                List<String> list = names.stream().map( s -> {
                        System.out.println(s);
                        return s.toUpperCase();
                }).collect(Collectors.toList());

                list.forEach(System.out::println);

                /**
                 * 병렬 처리를 JVM이 자동으로 처리해준다.
                 * parallelStream() 사용
                 *
                 * */

                List<String> collect = names.parallelStream().map(String::toUpperCase).collect(Collectors.toList());
                collect.forEach(System.out::println);
        }
}
