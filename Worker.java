public class Worker extends Book implements Runnable{
    private Thread t;
    private int read;
    private int write;
    private boolean checkForWriteLock;
    private boolean checkForReadLock;
    private boolean forWriting;
    private boolean hasReadLock;
    private boolean hasWriteLock;
    
    public void run(){
        try{
            
        }catch(InterruptedException e){
            if(hasWriteLock=true){
                super.releaseWriteLock();
                Thread.currentThread().stop();
            }
            else{
                Thread.currentThread().stop();
            }
            return;
        }
    }
    
    public void getLock(){
        if(forWriting=true){
           super.getWriteLock();
        }
        else{
            super.getReadLock();
        }
    }
    
    public void releaseLock(){
        if(forWriting=true){
            super.releaseWriteLock();
        }
        else{
            super.releaseReadLock();
        }
    }
    
    public void startMessage(){
        if(hasWriteLock=true){
            System.out.println(Thread.currentThread().getName() + "has write lock");
            this.finishedMessage();
        }
        else{
            System.out.println(Thread.currentThread().getName() + "has reading lock");
            this.finishedMessage();
        }
    }
    
    public void waitingMessage(){
        if(checkForWriteLock=true){
            System.out.println(Thread.currentThread().getName() + "is requesting to write");
            this.startMessage();
        }
        else if(checkForReadLock=true){
            System.out.println(Thread.currentThread().getName() + "is requesting to read");
            this.startMessage();
        }
    }
    
    public void finishedMessage(){
        if(hasWriteLock=true){
            super.releaseWriteLock();
            System.out.println(Thread.currentThread().getName() + "is finished writing");
        }
        else{
            super.releaseReadLock();
            System.out.println(Thread.currentThread().getName() + "is finished reading");
        }
    }
}
