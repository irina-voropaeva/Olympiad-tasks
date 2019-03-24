import java.util.ArrayList;
import java.util.Scanner;

public class Clock {

    private ArrayList<Integer> hours;
    private ArrayList<Integer> minutes;
    private ArrayList<Double> angles;

    public Clock() {
        hours = new ArrayList<>();
        minutes = new ArrayList<>();
        angles = new ArrayList<>();
    }

    public void start() {
        this.enter();
        this.solveAngle();
        this.printResult();
    }

    public void enter() {
        System.out.println("Enter H:M. When you want to end, enter 00:00");
        while (true) {
            String time = new Scanner(System.in).nextLine();
            if (time.equals("00:00")) {
                break;
            }
            this.addTime(time);
        }
    }

    private void addTime(String time) {
       String[] resultTime = time.split(":");
        hours.add(Integer.parseInt(resultTime[0]));
        minutes.add(Integer.parseInt(resultTime[1]));
    }

    private void solveAngle() {
        for (int i = 0; i < hours.size(); i++) {
            double tempResult = (60*hours.get(i) - 11*minutes.get(i)) / 2.0;
            if (tempResult > 180) {
                tempResult = 360 - tempResult;
            }
            angles.add(tempResult);
        }
    }

    private void printResult() {
        for (int i = 0; i < angles.size(); i++) {
            System.out.println(String.format("%.3f", angles.get(i)));
        }
    }

}
