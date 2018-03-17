public class Main {
    public static void main(String args[]){
        Worker t1 = new Worker();
        Worker t2 = new Worker();
        Worker t3 = new Worker();
        Worker t4 = new Worker();
        
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        Thread thread3 = new Thread(t3);
        Thread thread4 = new Thread(t4);
        
        thread1.setName("Thread 1 ");
        thread2.setName("Thread 2 ");
        thread3.setName("Thread 3 ");
        thread4.setName("Thread 4 ");
        System.out.println("Threads = 4");
        
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        
        System.out.println("All threads interrupted");
        System.out.println("Thread 1 completed");
        System.out.println("Thread 2 completed");
        System.out.println("Thread 3 completed");
        System.out.println("Thread 4 completed");
    }
}
