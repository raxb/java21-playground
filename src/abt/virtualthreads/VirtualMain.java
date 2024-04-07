package abt.virtualthreads;


import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VirtualMain {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");

        while (input.hasNext()) {
            switch (input.next()) {
                case "1" -> createVirtualThread();
                case "2" -> multipleVirtualThreads();
                case "3" -> executorServiceVirtualThread();
                default -> {
                    System.out.println("Try again!!!");
                }
            }
        }
    }

    private static void createVirtualThread() throws InterruptedException {
        Thread thread = Thread.ofVirtual().name("MVT-1").start(() -> System.out.println("Hello"));
        System.out.println("Name of the thread is - " + thread.getName() + " threadID: " + Thread.currentThread().threadId());
        thread.join();
    }

    private static void multipleVirtualThreads() throws InterruptedException {
        Thread.Builder builder = Thread.ofVirtual().name("worker-", 0);
        Runnable task = () -> System.out.println("Thread ID: " + Thread.currentThread().threadId());

        Thread t1 = builder.start(task);
        t1.join();
        System.out.println(t1.getName() + " terminated");

        Thread t2 = builder.start(task);
        t2.join();
        System.out.println(t2.getName() + " terminated");
    }

    private static void executorServiceVirtualThread() {
        try (ExecutorService myExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<?> future = myExecutor.submit(() -> System.out.println("Running thread"));
            Future<?> future1 = myExecutor.submit(() -> System.out.println("Thread ID: " + Thread.currentThread().threadId()));
            future.get();
            future1.get();
            System.out.println("Task completed");
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
