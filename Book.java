public class Book extends Thread {
    private int writers = 0;
    private int writersRequesting = 0;
    private boolean inWrite;
    
    public void getReadLock(){
        if(writers>0 || writersRequesting>0){
                ((Worker)Thread.currentThread()).waitingMessage();
        }
        else{
            inWrite=true;
            this.getWriteLock();
        }
    }

    public synchronized void getWriteLock(){
        while(writers > 0){
            try {
                writersRequesting++;
                wait();
            } catch (InterruptedException e) {
                this.releaseWriteLock();
            }
        }
        writersRequesting--;
        writers++;
        ((Worker)Thread.currentThread()).waitingMessage();
    }
    
    public void releaseReadLock(){
        if(inWrite=true){
            this.releaseWriteLock();
        }
    }

    public synchronized void releaseWriteLock(){
        writers--;
        notifyAll();
    }
}