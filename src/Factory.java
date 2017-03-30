import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Vinty on 22.03.2017.
 */
public class Factory implements HasWorker {
    private static final Factory factory = new Factory();
    List<RobotDetails> dump = Collections.synchronizedList(new ArrayList<RobotDetails>());

    private Factory() {
        for (int i = 0; i < 20; i++) {
            dump.add(RobotDetails.getDetails(basicRnd(8)));
        }
    }

    public List<RobotDetails> getDumpDetails(int count) {
        List<RobotDetails> list = new ArrayList<RobotDetails>();
        for (int i = 0; i < count; i++) {
            try {
                list.add(dump.remove(0));
            } catch (Exception e) {
            }
        }
        return list;
    }

    public int basicRnd(int maxCount) {
        Random ran = new Random();
        return ran.nextInt(maxCount + 1);
    }

    public void add() {
        for (int i = 0; i < basicRnd(4) + 1; i++) {
            dump.add(RobotDetails.getDetails(basicRnd(8)));
        }
    }

    @Override
    public void whatToDo() {
        add();
        System.out.println("На свалке сейчас: " + dump);
    }

    public static Factory getFactory() {
        return factory;
    }
}
