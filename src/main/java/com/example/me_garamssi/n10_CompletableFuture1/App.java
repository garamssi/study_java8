package com.example.me_garamssi.n10_CompletableFuture1;

import java.util.concurrent.*;

public class App {
        public static void main(String[] args) throws ExecutionException, InterruptedException {

                CompletableFuture<String> future = new CompletableFuture<>();
                future.complete("rami");
                System.out.println(future.get());

                CompletableFuture<String> future1 = CompletableFuture.completedFuture("rami");
                System.out.println(future1.get());

                /**
                 * 리턴이 있는 작업, 없는 작업
                 * */
                // 리턴이 없는 경우 -> runAsync
                CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
                        System.out.println("Hello" + Thread.currentThread().getName());
                });

                voidCompletableFuture.get();

                // 리턴이 있는 경우 -> supplyAsync
                CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
                        System.out.println("Hello" + Thread.currentThread().getName());
                        return "hello";
                })
                // thenApply 사용할 경우, callback 함수와 동일하게 실행이 된다.
                 .thenApply( s -> {
                        System.out.println(Thread.currentThread().getName());
                        return s.toUpperCase();
                });

                future2.get();

                // thenAccept 사용할 경우 콜백에 리턴이 없다. 받는 값은 컨슈머
                CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
                                System.out.println("Hello" + Thread.currentThread().getName());
                                return "hello";
                        })
                        // thenApply 사용할 경우, callback 함수와 동일하게 실행이 된다.
                        .thenAccept(s -> {
                                System.out.println(Thread.currentThread().getName());
                        });

                voidCompletableFuture1.get();

                // thenRun -> Runnable이 와서 그냥 실행시키고 싶을 때 사용한다.

                // d-Q는 last in first out


        }
}
