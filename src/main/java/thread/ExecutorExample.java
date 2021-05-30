package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main (String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2); // ���� ������ Ǯ ���
        executorService.submit(getRunnbale("hi"));
        executorService.submit(getRunnbale("hello"));
        executorService.submit(getRunnbale("executor"));
        executorService.submit(getRunnbale("thread"));

        executorService.shutdown(); // ����
    }

    public static Runnable getRunnbale(String message) {
        return () -> System.out.println(message + ": " + Thread.currentThread().getName());
    }
}
