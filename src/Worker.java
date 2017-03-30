import java.util.concurrent.BrokenBarrierException;
/**
 * Created by Vinty on 22.03.2017.
 */
public class Worker implements Runnable {
    HasWorker worc;
    public static int count = 0;
    public Worker(HasWorker worc) {
        this.worc = worc;
    }
    @Override
    public void run() {
        try {
            System.out.println("Заход № " + count++);
            MainStarter.BARRIER.await();
            System.out.println("Поток " + worc.getClass());
        } catch (InterruptedException e) {

            e.printStackTrace();
        } catch (BrokenBarrierException e) {
        }
        try {
            worc.whatToDo();

        } catch (NullPointerException e) {
        }
    }
}
