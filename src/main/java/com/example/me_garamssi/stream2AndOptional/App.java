package com.example.me_garamssi.stream2AndOptional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

        public static void main(String[] args) {
                List<OnlineClass> springClasses = new ArrayList<>();
                springClasses.add(new OnlineClass(1, "spring boot", true));
                springClasses.add(new OnlineClass(2, "spring data jpa", true));
                springClasses.add(new OnlineClass(3, "spring mvc", false));
                springClasses.add(new OnlineClass(4, "spring core", false));
                springClasses.add(new OnlineClass(5, "rest api development", false));

                List<OnlineClass> javaClasses = new ArrayList<>();
                springClasses.add(new OnlineClass(6, "The Java Test", true));
                springClasses.add(new OnlineClass(7, "The Java Code manipulation", false));
                springClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));
                springClasses.add(new OnlineClass(9, "rest api development", false));

                List<List<OnlineClass>> ramEvents = new ArrayList<>();
                ramEvents.add(springClasses);
                ramEvents.add(javaClasses);


                /**
                 * map()의 경우에는 객체를 받고나서 추가 메소드에 값을 넘겨줄 때 string으로 넘겨주니 주의..
                 * */

                System.out.println("spring 으로 시작하는 수업");
                // TODO
                springClasses.stream()
                        .filter((oc) -> oc.getTitle().startsWith("spring"))
                        .forEach( oc -> System.out.println(oc.getTitle()));

                System.out.println("close 되지 않은 수업");
                // TODO
                springClasses.stream()
                        .filter( oc -> !oc.isClosed() )
                        .forEach( oc -> System.out.println(oc.getTitle()));

                // 단축
//                springClasses.stream()
//                        .filter(Predicate.not(OnlineClass::isClosed))
//                        .forEach( oc -> System.out.println( oc.getTitle()));


                System.out.println("수업 이름만 모아서 스트림 만들기");
                // TODO
                springClasses.stream().map( oc -> oc.getTitle()).forEach( System.out::println );

                System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
                // TODO
                ramEvents.stream().flatMap(Collection::stream).forEach( oc -> System.out.println( oc.getId() ));

                System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
                // TODO
                Stream.iterate(10, i -> i + 1)
                        .skip(10)
                        .limit(10)
                        .forEach(System.out::println);

                System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
                // TODO
                boolean test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
                System.out.println(test);

                System.out.println("스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List로 만들기");
                // TODO

                // map 사용
                List<String> spring2 = springClasses.stream()
                        .map( oc -> oc.getTitle() )
                        .filter( t -> t.contains("spring"))
                        .collect(Collectors.toList());

                // map을 사용하지 않음
                List<OnlineClass> spring = springClasses.stream()
                        .filter(oc -> oc.getTitle().contains("spring"))
                        .collect(Collectors.toList());
                spring.forEach(System.out::println);





                /**
                 * Optional
                 * */
                // spring으로 시작하는 첫번째 값을 가져와라,
                Optional<OnlineClass> spring1 = springClasses.stream()
                        .filter(oc -> oc.getTitle().startsWith("spring"))
                        .findFirst();

                boolean present = spring1.isPresent();
                System.out.println(present);

                // optional에 비어있는 값을 가져올 때
                // NoSuchElementException ( RunTimeException ) 발생
//                OnlineClass onlineClass = spring1.get();
//                System.out.println(onlineClass.getTitle());

                // 값이 있으면 동작하는 문법
                spring1.ifPresent( s -> System.out.println(s.getTitle()));


                // 값이 없으면 createNewClass() 새로운 클래스를 만들어서 주입
                // orElse()의 인자값은 인터페이스가 아닌 인스턴스가 들어가야한다.
                // 상수로 만들어져 있는 것
                OnlineClass onlineClass = spring1.orElse(createNewClass());


                // Lazy한 접근 방법
                // 동적인 방법
                OnlineClass onlineClass2 = spring1.orElseGet(App::createNewClass);

                // 값이 없을 때 Throw 던지는 법
                OnlineClass onlineClass3 = spring1.orElseThrow(IllegalStateException::new);

                // 값이 있다는 가정하에 close가 안된 값을 찾으려 할 때 값이 비어진 empty로 반환한다.
                Optional<OnlineClass> onlineClass1 = spring1.filter(oc -> !oc.isClosed());
                System.out.println(onlineClass1.isPresent());


                // 맵으로 사용 할 때
                Optional<Integer> integer = spring1.map(OnlineClass::getId);
                System.out.println(integer.isPresent());


                /**
                 * flatMap은 뎁스를 원뎁스로 펼쳐서 사용할 수 있게 해준다.
                 *
                 * if getProgress메소드가 optional.empty()를 반환 해줄 때,
                 *
                 * Optional<Optional<Progress>> progress = optional.flatMap(OnlineClass::getProgress);
                 *
                 * 아래의 코드를 위와 같이 줄여서 사용 가능,
                 *
                 * Optional<Optional<Progress>> progress1 = optional.map(OnlineClass::getProgress);
                 * Optional<Progress> progress2 = progress1.orElse(Optional.empty());
                 * */

                /**
                 * 경우에 따라 map, filter 등등 사용 가능
                 * */

        }

        private static OnlineClass createNewClass() {
                System.out.println("creating new online class");
                return new OnlineClass(10, "New Class", false);
        }
}
