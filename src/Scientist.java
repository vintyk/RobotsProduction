import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/**
 * Created by Vinty on 25.03.2017.
 */
public class Scientist implements HasWorker {

    public Map<RobotDetails, Integer> map;
    public RobotDetails masRobot[];
    private int countRobot;
    Random ran;

    public Scientist() {
        ran = new Random();
        map = new HashMap<RobotDetails, Integer>();
        masRobot = new RobotDetails[9];
        for (int i = 0; i < masRobot.length; i++) {
            masRobot[i] = RobotDetails.getDetails(i);
            map.put(masRobot[i], 0);
        }

    }

    public void putDetails(List<RobotDetails> details) {
        while (0 != details.size()) {
            RobotDetails det = details.remove(0);
            map.put(det, map.get(det) + 1);

        }
        addRobots();
    }

    public void addRobots() {
        int rez = 0;
        for (int i = 0; i < masRobot.length; i++) {
            if (map.get(masRobot[i]) == 0 || map.get(masRobot[i]) == null) {
                rez++;
            }

        }
        if (rez == 0) {
            for (int i = 0; i < masRobot.length; i++) {
                map.put((masRobot[i]), map.get(masRobot[i]) - 1);
            }
            countRobot++;
        }

    }

    @Override
    public void whatToDo() {

        putDetails(Factory.getFactory().getDumpDetails(ran.nextInt(4) + 1));
        System.out.println(map);
    }

    public int getCountRobot() {
        return countRobot;
    }

}
