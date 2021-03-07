import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Test {

    static PriorityQueue<User> queueTest = new PriorityQueue<>();
    public static void main(String[] args) {
        int j = 0;
        while (!isFull()){
            int order = ThreadLocalRandom.current().nextInt(10);
            User user = new User(order, j+"-user");
            System.out.println(String.format("Set User "+ user));
            queueTest.offer(user);
            j++;
        }

        // write thread 1
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 300;
                while (true){
                    if (i > 600)
                        break;

                    int order = ThreadLocalRandom.current().nextInt(10);
                    User user = new User(order, i+"-user");
                    System.out.println(String.format("Set1 User "+ user));
                    if (isFull()) {
                        queueTest.poll();
                        queueTest.offer(user);
                    }
                    i++;
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true){
                    if (i > 300)
                        break;

                    int order = ThreadLocalRandom.current().nextInt(20);
                    User user = new User(order, i+"-user");
                    System.out.println(String.format("Set2 User "+ user));
                    if (isFull()) {
                        queueTest.poll();
                        queueTest.offer(user);
                    }
                    i++;
                }
            }
        }).start();

        // write thread 2
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!isFull()){
                    int order = ThreadLocalRandom.current().nextInt(20);
                    User user = new User(order, i+"-user");
                    System.out.println(String.format("Set2 User "+ user));
                    queueTest.offer(user);
                    i++;
                }
            }
        }).start();
        // read thread1
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
////                try {
//                int i = 0;
//                while (true) {
//                    if ( i > 100)
//                        break;
//                    User user = queueTest.poll();
//                    System.out.println(String.format("Read1 User "+ user));
//                    i++;
//                }
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
//            }
//        }).start();

        // read thread2
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
////                try {
//                int i = 0;
//                while (true) {
//                    if ( i > 100)
//                        break;
//                    User user = queueTest.poll();
//                    System.out.println(String.format("Read2 User "+ user));
//                    i++;
//                }
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
//            }
//        }).start();








    }
    private static boolean isFull() {
        return queueTest.size()>= 200;
    }

    private static class User implements Comparable<User> {
        private final int order;
        private final String name;
        private User(int order, String name) {
            this.order = order;
            this.name = name;
        }
        @Override
        public int compareTo(User o) {
            return this.order - o.order;
        }
        @Override
        public String toString() {
            return "User{" +
                    "order=" + order +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}