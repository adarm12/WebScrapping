public class ThreadLiga extends Thread{
    private LigaInformation ligot;
    public ThreadLiga(LigaInformation ligot){
        this.ligot = ligot;
    }
    public void run(){
        System.out.println("thread started");
        try {
            Thread.sleep(10000);
            this.ligot.returnToMenu();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
