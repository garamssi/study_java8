package com.example.me_garamssi.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {

        public static void main(String[] args) {
                /**
                 * ExecutorService는 Executor 인터페이스를 상속받은 인터페이스
                 * */

                ExecutorService executorService = Executors.newSingleThreadExecutor();
                executorService.submit(() -> {
                                System.out.println("Thread" + Thread.currentThread().getName());
                });

                // executorService는 명시적으로 shutdown을 해줘야 자원이 돌아온다.
                // graceful shotdown은 진행중인 작업을 마친 후에 자원을 회수한다.
                executorService.shutdown();

                // 바로 자원 회수
//                executorService.shutdownNow();

                /**
                 * Thread 여러개로 작업 처리하기
                 * */

                ExecutorService executorService1 = Executors.newFixedThreadPool(2);
                executorService1.submit(getRunnable("Hello"));
                executorService1.submit(getRunnable("my"));
                executorService1.submit(getRunnable("name"));
                executorService1.submit(getRunnable("is"));
                executorService1.submit(getRunnable("rami"));

                executorService1.shutdown();

                /**
                 * Scheduled Thread
                 * */
                ScheduledExecutorService executorService2 = Executors.newSingleThreadScheduledExecutor();

                // 3초 정도 기다렸다가 메세지 출력..
                executorService2.schedule(getRunnable("Hello"), 3, TimeUnit.SECONDS);

                // 반복적으로 실행
                executorService2.scheduleAtFixedRate(getRunnable("repeat"), 1, 2, TimeUnit.SECONDS);
                // scheduleAtFixedRate 사용할려면 shutdown을 시키면 안된다. interruptException을 시키면 동작을 하지 않음,

                executorService2.shutdown();

                /**
                 * fork / join Framework -> 멀티 프로세싱
                 * */



        }

        private static Runnable getRunnable(String message) {
                return () -> System.out.println( message + Thread.currentThread().getName());
        }
}
