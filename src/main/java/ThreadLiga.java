public class ThreadLiga extends Thread{

    public static int TIMER = 10000;

    private LigaInformation ligot;

    public ThreadLiga(LigaInformation ligot){
        this.ligot = ligot;
    }

    public void run(){
        System.out.println("thread started");
        try {
            Thread.sleep(TIMER);
            this.ligot.returnToMenu();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
