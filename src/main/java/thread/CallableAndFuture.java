package thread;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableAndFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> hello = () -> {
            Thread.sleep(5000L);
            return "Hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(2000L);
            return "Java";
        };

        Callable<String> test = () -> {
            Thread.sleep(1000L);
            return "Test";
        };

        String s = executorService.invokeAny(Arrays.asList(hello, java, test));
        System.out.println(s);
        executorService.shutdown();

    }
}
