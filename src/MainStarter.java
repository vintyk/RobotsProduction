import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Vinty on 22.03.2017.
 */
public class MainStarter {
    public static final CyclicBarrier BARRIER = new CyclicBarrier(3);

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        Scientist scint1 = new Scientist();
        Scientist scint2 = new Scientist();
        for (int i = 0; i <= 100; i++) {
            new Thread(new Worker(Factory.getFactory())).start();
            new Thread(new Worker(scint1)).start();
            new Thread(new Worker(scint2)).start();
            Thread.sleep(100);
        }
        Thread.sleep(100);
        System.out.println("Count robot to scient1 =" + scint1.getCountRobot());
        System.out.println("Count robot to scient2 =" + scint2.getCountRobot());
    }
}
