package com.example.me_garamssi.n9_callableAndFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App {

        public static void main(String[] args) throws ExecutionException, InterruptedException {
                /**
                 * Callable과 executor와의 차이점은 리턴 값을 줄 수 있냐 없냐의 차이이다.
                 * */

                ExecutorService executorService = Executors.newSingleThreadExecutor();

                Callable<String> hello = () -> {
                        Thread.sleep(2000L);
                        return "Hello";
                };

                Future<String> feature = executorService.submit(hello);
                System.out.println("Started!");

                /**
                 * Started!을 print하는 동안 쭉 실행이 되다가 블록킹 콜인 get()을 만나게 되면
                 * 해당 쓰레드가 전부 실행이 될 때까지 기다린다.
                 * 쓰레드가 전부 실행이 되고 나면 End! print를 실행한 뒤 shutdown을 통해 자원을 반환한다.
                 * */

                feature.get(); // 블록킹 콜

                System.out.println("End!");
                executorService.shutdown();

                /**
                 * isDone() return boolean : 작업이 종료됐는지 확인
                 * cancel(false) -> 캔슬을 하고 isDone을 통해 확인 시 true -> get을 통해 반환 값을 확인하려고 하면 에러
                 * cancellationException을 발생시킨다.
                 * */


                /**
                 * invokeAll
                 * 여러개를 실행 할 수 있도록 List 형태로 넘겨주기
                 * */

                ExecutorService executorService1 = Executors.newSingleThreadExecutor();

                Callable<String> helloMan = () -> {
                        Thread.sleep(2000L);
                        return "HelloMan";
                };

                Callable<String> java = () -> {
                        Thread.sleep(3000L);
                        return "java";
                };

                Callable<String> rami = () -> {
                        Thread.sleep(1000L);
                        return "rami";
                };
                System.out.println("delay 6 seconds");
                List<Future<String>> futures = executorService1.invokeAll(Arrays.asList(helloMan, java, rami));
                for (Future<String> f : futures) {
                        System.out.println(f.get());
                }
                // InvokeAll은 3개의 메소드의 slepp을 전부 기다린 후 futures에 반환다.
                // for에서 print할 때는 빠르게 실행된다.

                executorService1.shutdown();

                /**
                 * InvokeAny
                 * All과 다르게 반환된 메소드를 반환한다.
                 * */

                String s = executorService1.invokeAny(Arrays.asList(helloMan, java, rami));
                // 리스트 중에 sleep이 가장 짧은 1초인 rami가 반환되어 print한다. 단 쓰레드가 여러개여야 마지막에 들어간 rami가 제일 먼저나온다
                // 현재는 싱글 쓰레드를 사용하고 있고 helloMan이 제일 먼저 전달되어 작업하기 때문이다.
                System.out.println(s);
        }
}
