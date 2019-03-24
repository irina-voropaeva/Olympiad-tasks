import java.util.ArrayList;
import java.util.Scanner;

public class Minesweeper {

    private ArrayList<ArrayList<StringBuilder>> fieldsString;

    public Minesweeper() {
        fieldsString = new ArrayList<>();
    }

    public void playGame() {
        System.out.println("Welcome to the minesweeper!");

        for (; ; ) {
            System.out.println("Enter N:");
            int N = new Scanner(System.in).nextInt();
            System.out.println("Enter M:");
            int M = new Scanner(System.in).nextInt();

            if (N < 0 || N > 100 || M < 0 || M > 100 || (N == 0 && M != 0) || (N != 0 && M == 0)) {
                continue;
            }
            if (N == 0 && M == 0) {
                break;
            } else {
                System.out.println("Enter field:");
                fieldsString.add(this.readField(N, M));
            }
        }
        this.makeResult();
        this.printResult();

    }

    private ArrayList<StringBuilder> readField(int N, int M) {
        ArrayList<StringBuilder> tempList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringBuilder stringBuilder = new StringBuilder();

            //Add dots border around entered field to make easier adding mines.
            if (i == 0) {
                this.addEmptyLine(tempList, M);
            }
            stringBuilder.append(new Scanner(System.in).nextLine());
            if(stringBuilder.length() < M) {
                for (int k = stringBuilder.length(); k < M; k++) {
                    stringBuilder.append(".");
                }
            }
            String s = stringBuilder.substring(0, M);
            StringBuilder s_buffer = new StringBuilder("." + s.subSequence(0, s.length()) + ".");
            tempList.add(s_buffer);
            if (i == N - 1) {
                this.addEmptyLine(tempList, M);
            }
        }
        return tempList;
    }

    private void addEmptyLine(ArrayList<StringBuilder> tempList, int M) {
        StringBuilder tempString = new StringBuilder();
        for (int j = 0; j < M; j++) {
            tempString.append(".");
        }
        String s = tempString.substring(0, M);
        StringBuilder s_buffer = new StringBuilder("." + s.subSequence(0, s.length()) + ".");
        tempList.add(s_buffer);
    }

    private void makeResult() {
        this.makeMinesFieldsWithoutHints(fieldsString);
        this.makeHints(fieldsString);
    }


    private void printResult() {
        for (int i = 0; i < this.fieldsString.size(); i++) {
            System.out.println("Field #" + i);

            for (int j = 1; j < this.fieldsString.get(i).size() - 1; j++) {
                for (int k = 1; k < this.fieldsString.get(i).get(j).length() - 1; k++) {
                    System.out.print(this.fieldsString.get(i).get(j).charAt(k));
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }
    }

    private void makeMinesFieldsWithoutHints(ArrayList<ArrayList<StringBuilder>> fieldsList) {
        fieldsList.trimToSize();
        for (int i = 0; i < fieldsList.size(); i++) {
            for (int j = 0; j < fieldsList.get(i).size(); j++) {
                for (int k = 0; k < fieldsList.get(i).get(j).length(); k++) {
                    if (fieldsList.get(i).get(j).charAt(k) != '*') {
                        fieldsList.get(i).get(j).setCharAt(k, '0');
                    }
                }
            }
        }
    }

    private void makeHints(ArrayList<ArrayList<StringBuilder>> fieldsList) {
        for (int i = 0; i < fieldsList.size(); i++) {

            for (int j = 1; j < fieldsList.get(i).size() - 1; j++) {
                for (int k = 1; k < fieldsList.get(i).get(j).length() - 1; k++) {
                    if (String.valueOf(fieldsList.get(i).get(j).charAt(k)).equals("*")) {
                        //Make ++ for left neighborhood
                        if (!String.valueOf(fieldsList.get(i).get(j).charAt(k - 1)).equals("*")) {
                            String resultPoint = Integer.toString(Integer.parseInt(fieldsList.get(i).get(j).substring(k - 1, k))  + 1);
                            fieldsList.get(i).get(j).setCharAt(k - 1, resultPoint.charAt(0));
                        }
                        //Make ++ for right neighborhood
                        if (!String.valueOf(fieldsList.get(i).get(j).charAt(k + 1)).equals("*")) {
                            String resultPoint =  Integer.toString(Integer.parseInt(fieldsList.get(i).get(j).substring(k + 1, k + 2))  + 1);
                            fieldsList.get(i).get(j).setCharAt(k + 1, resultPoint.charAt(0));
                        }
                        //Make ++ for 3 top and 3 bottom neighborhoods
                        //Make ++ for top neighborhood
                        if (!String.valueOf(fieldsList.get(i).get(j - 1).charAt(k)).equals("*")) {
                        String resultPoint =  Integer.toString(Integer.parseInt(fieldsList.get(i).get(j - 1).substring(k, k + 1))  + 1);
                        fieldsList.get(i).get(j - 1).setCharAt(k, resultPoint.charAt(0));
                        }
                        //Make ++ for left top neighborhood
                        if (!String.valueOf(fieldsList.get(i).get(j - 1).charAt(k - 1)).equals("*")) {
                            String resultPoint =  Integer.toString(Integer.parseInt(fieldsList.get(i).get(j - 1).substring(k - 1, k))  + 1);
                            fieldsList.get(i).get(j - 1).setCharAt(k - 1, resultPoint.charAt(0));
                        }
                        //Make ++ for right top neighborhood
                        if (!String.valueOf(fieldsList.get(i).get(j - 1).charAt(k + 1)).equals("*")) {
                            String resultPoint =  Integer.toString(Integer.parseInt(fieldsList.get(i).get(j - 1).substring(k + 1, k + 2))  + 1);
                            fieldsList.get(i).get(j - 1).setCharAt(k + 1, resultPoint.charAt(0));
                        }
                        //Make ++ for bottom neighborhood
                        if  (!String.valueOf(fieldsList.get(i).get(j + 1).charAt(k)).equals("*")) {
                            String resultPoint =  Integer.toString(Integer.parseInt(fieldsList.get(i).get(j + 1).substring(k, k + 1))  + 1);
                            fieldsList.get(i).get(j + 1).setCharAt(k, resultPoint.charAt(0));
                        }
                        //Make ++ for left bottom neighborhood
                        if (!String.valueOf(fieldsList.get(i).get(j + 1).charAt(k - 1)).equals("*")) {
                            String resultPoint =  Integer.toString(Integer.parseInt(fieldsList.get(i).get(j + 1).substring(k - 1, k)) + 1);
                            fieldsList.get(i).get(j + 1).setCharAt(k - 1, resultPoint.charAt(0));
                        }
                        //Make ++ for right bottom neighborhood
                        if (!String.valueOf(fieldsList.get(i).get(j + 1).charAt(k + 1)).equals("*")) {
                            String resultPoint =  Integer.toString(Integer.parseInt(fieldsList.get(i).get(j + 1).substring(k + 1, k + 2))  + 1);
                            fieldsList.get(i).get(j + 1).setCharAt(k + 1,  resultPoint.charAt(0));
                        }
                    }
                }
            }
        }
    }
}
