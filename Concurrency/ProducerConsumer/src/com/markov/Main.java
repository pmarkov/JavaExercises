package com.markov;

import java.util.Random;
import java.util.concurrent.*;

import static com.markov.Main.EOF;
import static com.markov.ThreadColor.ANSI_CYAN;
import static com.markov.ThreadColor.ANSI_GREEN;
import static com.markov.ThreadColor.ANSI_PURPLE;

public class Main {

    static String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        MyProducer producer = new MyProducer(buffer, ANSI_PURPLE);
        MyConsumer consumer1 = new MyConsumer(buffer, ANSI_GREEN);
        MyConsumer consumer2 = new MyConsumer(buffer, ANSI_CYAN);

//        new Thread(producer).start();
//        new Thread(consumer1).start();
//        new Thread(consumer2).start();
        executor.execute(producer);
        executor.execute(consumer1);
        executor.execute(consumer2);

        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() {
                System.out.println(ThreadColor.ANSI_RED + "I'm being printed from the Callable class");
                return "This is the callable result";
            }
        });

        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Something went wrong");
        } catch (InterruptedException e) {
            System.out.println("Thread running the task was interrupted");
        }

        executor.shutdown();
    }
}

class MyProducer implements Runnable {

    private ArrayBlockingQueue<String> buffer;
    private String color;

    MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1" , "2", "3", "4", "5"};

        for(String num : nums) {
            try {
                System.out.println(color + "Adding... " + num);
                buffer.put(num);

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        try {
            buffer.put("EOF");
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyConsumer implements Runnable {
    private final ArrayBlockingQueue<String> buffer;
    private String color;

    MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {

        while(true) {
            synchronized (buffer) {
                try {
                    if(buffer.isEmpty()) {
                        continue;
                    }
                    if(buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting...");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
























