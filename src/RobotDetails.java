/**
 * Created by Vinty on 22.03.2017.
 */
public enum RobotDetails {
    head, body, leftHand, rightHand, leftFoot, rightFoot, CPU, RAM, HDD;
    RobotDetails() {
    }
    public static RobotDetails getDetails(int id) {
        switch (id) {
            case 0:
                return RobotDetails.head;
            case 1:
                return RobotDetails.body;
            case 2:
                return RobotDetails.leftHand;
            case 3:
                return RobotDetails.rightHand;
            case 4:
                return RobotDetails.leftFoot;
            case 5:
                return RobotDetails.rightFoot;
            case 6:
                return RobotDetails.CPU;
            case 7:
                return RobotDetails.RAM;
            case 8:
                return RobotDetails.HDD;
        }
        return null;
    }
}
