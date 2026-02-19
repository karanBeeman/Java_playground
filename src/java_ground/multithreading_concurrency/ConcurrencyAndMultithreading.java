package java_ground.multithreading_concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ConcurrencyAndMultithreading {

    public static void main(String[] args) {
        RunnableExample task = new RunnableExample();
        Thread thread1 = new Thread(task); //Create a new thread with the task - the run method will be executed when the thread starts
        Thread thread2 = new Thread(task);

        thread1.start();
       // thread1.start();   // ❌ IllegalThreadStateException
        thread2.start();

        CallableExample task1 = new CallableExample();
        FutureTask<String> futureTask = new FutureTask<>(task1);
        //FutureTask is a wrapper that allows us to execute a Callable in a thread and retrieve the result later
        Thread thread = new Thread(futureTask); thread.start();
        // Wait for the result and print it String result = futureTask.get(); System.out.println(result);

        ExecutorServiceExample executorServiceExample = new ExecutorServiceExample();
        executorServiceExample.exec();
        FutureTaskExample futureTaskExample = new FutureTaskExample();
        futureTaskExample.futureTaskMethod();

        Thread t1 = new Thread(new MyTask());
        t1.start();
    }
}

class MyTask extends Thread {

    public void run() {
        System.out.println("threads ");
    }
}

class RunnableExample implements Runnable {
    // Runnable is a functional interface with a single method run() that does not return a result and cannot throw checked exceptions
    // The run method contains the code that will be executed when the thread starts

    @Override public void run() {
        System.out.println("Runnable result from thread: " + Thread.currentThread().getName());
    }
    // Same code using lambda expression
    // Runnable task = () -> System.out.println("Thread is running: " + Thread.currentThread().getName());
}

class CallableExample implements Callable<String> {
    // Callable is a functional interface with a single method call() that returns a result and can throw checked exceptions
    // The call method contains the code that will be executed when the thread starts and returns a result

    @Override public String call() throws Exception {
        return "Callable result from thread: " + Thread.currentThread().getName();
    }
    // Same code using lambda expression
    // Callable<String> task1 = () -> "Callable result from thread: " + Thread.currentThread().getName();
}

class ExecutorServiceExample {
    // It is Thread pool Manager
    // Executor is an interface that provides a way to manage and control the execution of threads
    // It provides methods to submit tasks for execution and manage thread pools
    // Executes Runnable and Callable tasks
    //Controls task lifecycle
    //Manages shutdown
    //Supports asynchronous result handling via Future
    // reuses threads from a pool, improving performance and resource management

 void exec() {
     ExecutorService executor = Executors.newFixedThreadPool(2); // Creates a thread pool with a fixed number of threads (2 in this case)
     CallableExample task = new CallableExample();
     Future<String> future = executor.submit(task); // Submits a Callable task for execution and returns a Future representing the pending result of the task
     Future<String> future1 = executor.submit(task); // Submits another Callable task for execution and returns a Future representing the pending result of the task
     Future<String> future3 = executor.submit(task); // reuses one of the threads from the pool to execute the task, demonstrating thread reuse
     try {
         System.out.println(future.get());
         System.out.println(future1.get());
         System.out.println(future3.get());
     } catch (InterruptedException e) {
         throw new RuntimeException(e);
     } catch (ExecutionException e) {
         throw new RuntimeException(e);
     }
     executor.shutdown();
 }

}

class FutureTaskExample {
    // FutureTask is a concrete implementation of the Future interface that can be used to wrap a Callable or Runnable task and execute it in a thread
    // It provides methods to check if the task is complete, retrieve the result, and cancel the task if needed
    // It can be used with an ExecutorService to manage the execution of tasks and retrieve results asynchronously

    ExecutorService executor = Executors.newSingleThreadExecutor(); // Creates a thread pool with a single thread
    FutureTask<String> futureTask = new FutureTask<>(new CallableExample()); // Wraps a Callable task in a FutureTask

     void futureTaskMethod() {
         executor.submit(futureTask); // Executes the FutureTask in the thread pool
         try {
             System.out.println(futureTask.get()); // Waits for the result and prints it
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         } catch (ExecutionException e) {
             throw new RuntimeException(e);
         }
         executor.shutdown();
     }

   //  FutureTask <String> futureTask1 = new FutureTask<>(() -> "FutureTask result from thread: " + Thread.currentThread().getName()); // Same code using lambda expression
   //   executor.submit(futureTask1); // Executes the FutureTask in the thread pool
   //  this internally call futureTask1.run() method which will execute the call method of the Callable and set the result in the FutureTask, allowing us to retrieve it later using futureTask1.get()
}