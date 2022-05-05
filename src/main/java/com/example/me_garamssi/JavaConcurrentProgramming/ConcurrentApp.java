package com.example.me_garamssi.JavaConcurrentProgramming;

public class ConcurrentApp {
        public static void main(String[] args) throws InterruptedException {
                /**
                 * 기초 Thread
                 * */

                // 쓰레드 생성 후 프린트를 1초마다 출력한다.
                // () -> new Runnable() -> void run()
                Thread thread = new Thread( () -> {
                        while(true) {
                                System.out.println("Thread" + Thread.currentThread().getName());
                                try {
                                        Thread.sleep(1000L);
                                } catch (InterruptedException e) {
                                        System.out.println("exit");
                                        return; // 종료
                                }
                        }

                });
                thread.start(); // 쓰레드 시작
                Thread.sleep(3000L);
                thread.interrupt(); // thread의 InterruptedException 을 발생시킨다.

                /**
                 * Join
                 * */
                // thread.join()을 하게되면 해당 쓰레드가 끝날 때 까지 기다린다.

        }
}
