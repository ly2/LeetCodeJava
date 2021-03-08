import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {

    private int n, counter;
    private Semaphore sem, sem3, sem5, sem15;

    public FizzBuzz(int n) {
        this.n = n;
        sem = new Semaphore(1);
        sem3 = new Semaphore(0);
        sem5 = new Semaphore(0);
        sem15 = new Semaphore(0);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if (i % 5 != 0) { // skip multiples of 15.
                sem3.acquire();
                printFizz.run();
                sem.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if (i % 3 != 0) { // skip multiples of 15.
                sem5.acquire();
                printBuzz.run();
                sem.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            sem15.acquire();
            printFizzBuzz.run();
            sem.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; ++i) {
            sem.acquire();
            if (i % 15 == 0) {
                sem15.release();
            }else if (i % 5 == 0) {
                sem5.release();
            }else if (i % 3 == 0) {
                sem3.release();
            }else {
                printNumber.accept(i);
                sem.release();
            }
        }
    }
}

/*

public class FizzBuzz {

    private int n;
    private volatile boolean fizz;
    private volatile boolean buzz;
    private volatile boolean done;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (!done) {
            while (!fizz || buzz) {
                wait();
                if (done) return;
            }
            fizz = false;
            printFizz.run();
            notifyAll();
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (!done) {
            while (!buzz || fizz) {
                wait();
                if (done) return;
            }
            buzz = false;
            printBuzz.run();
            notifyAll();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (!done) {
            while (!(buzz && fizz)) {
                wait();
                if (done) return;
            }
            fizz = false;
            buzz = false;
            printFizzBuzz.run();
            notifyAll();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) fizz = true;
            if (i % 5 == 0) buzz = true;
            if (!fizz && !buzz) {
                printNumber.accept(i);
            }
            notifyAll();
            while (buzz || fizz) {
                wait();
            }
        }
        done = true;
        notifyAll();
    }
}
*/




/*
class FizzBuzz {
    private int n;

    private Object mutex = new Object();
    int count = 1;
    int last3;
    int last5;
    int last15;
    int last_number;

    public FizzBuzz(int n) {
        this.n = n;
        last3 = 3 * (n / 3);
        if (last3 % 5 == 0) {
            last3 -= 3;
        }
        last5 = 5 * (n / 5);
        if (last5 % 3 == 0) {
            last5 -= 5;
        }
        last15 = 15 * (n / 15);
        last_number = n;
        while (last_number == last3 || last_number == last5 || last_number == last15) {
            last_number--;
        }
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        if (last3 <= 0) {
            return;
        }
        for (; ; ) {
            synchronized (mutex) {
                while ((count % 3 != 0 || count % 5 == 0)) {
                    mutex.wait();
                }
                synchronized (mutex) {
                    printFizz.run();
                    count++;
                    mutex.notifyAll();
                }
            }
            if (count == last3 + 1) break;
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        if (last5 <= 0) {
            return;
        }
        for (; ; ) {
            synchronized (mutex) {
                while (count % 5 != 0 || count % 3 == 0) {
                    mutex.wait();
                }
                synchronized (mutex) {
                    printBuzz.run();
                    count++;
                    mutex.notifyAll();
                    if (count == last5 + 1) break;
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        if (last15 <= 0) {
            return;
        }
        for (; ; ) {
            synchronized (mutex) {
                while (count % 3 != 0 || count % 5 != 0) {
                    mutex.wait();
                }
                synchronized (mutex) {
                    printFizzBuzz.run();
                    count++;
                    mutex.notifyAll();
                    if (count == last15 + 1) break;
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        if (last_number <= 0) {
            return;
        }
        for (; ; ) {
            synchronized (mutex) {
                while (count % 3 == 0 || count % 5 == 0) {
                    mutex.wait();
                }
                synchronized (mutex) {
                    printNumber.accept(count);
                    count++;
                    mutex.notifyAll();
                    if (count == last_number + 1) break;
                }
            }
        }
    }
}*/
