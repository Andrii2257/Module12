package hw2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzz {
    private int n;
    private BlockingQueue<String> queue;

    public FizzBuzz(int n) {
        this.n = n;
        this.queue = new LinkedBlockingQueue<>();
    }

    public static void main(String[] args) {
        int n = 15;
        FizzBuzz fizzBuzz = new FizzBuzz(n);

        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    fizzBuzz.addString("fizz");
                }
            }
        });

        Thread threadB = new Thread(() -> {
            for (int i = 1; i <= n; i++) {
                if (i % 5 == 0) {
                    fizzBuzz.addString("buzz");
                }
            }
        });

        Thread threadC = new Thread(() -> {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    fizzBuzz.addString("fizzbuzz");
                }
            }
        });

        Thread threadD = new Thread(() -> {
            for (int i = 1; i <= n; i++) {
                fizzBuzz.printNext();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }

    public synchronized void addString(String str) {
        queue.add(str);
    }

    public synchronized void printNext() {
        if (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
