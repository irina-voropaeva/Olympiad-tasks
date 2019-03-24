import java.util.*;

public class Numbers {

    private HashMap<String, Integer> numbersToLettersMapping;
    private ArrayList<HashMap<Integer, Integer>> duplicatesResults;
    private int datasetNumber;
    private ArrayList<ArrayList<StringBuilder>> numbers;

    public Numbers() {
        this.numbersToLettersMapping = new HashMap<>();
        this.numbersToLettersMapping.put("A", 2);
        this.numbersToLettersMapping.put("B", 2);
        this.numbersToLettersMapping.put("C", 2);
        this.numbersToLettersMapping.put("D", 3);
        this.numbersToLettersMapping.put("E", 3);
        this.numbersToLettersMapping.put("F", 3);
        this.numbersToLettersMapping.put("G", 4);
        this.numbersToLettersMapping.put("H", 4);
        this.numbersToLettersMapping.put("I", 4);
        this.numbersToLettersMapping.put("J", 5);
        this.numbersToLettersMapping.put("K", 5);
        this.numbersToLettersMapping.put("L", 5);
        this.numbersToLettersMapping.put("M", 6);
        this.numbersToLettersMapping.put("N", 6);
        this.numbersToLettersMapping.put("O", 6);
        this.numbersToLettersMapping.put("P", 7);
        this.numbersToLettersMapping.put("R", 7);
        this.numbersToLettersMapping.put("S", 7);
        this.numbersToLettersMapping.put("T", 8);
        this.numbersToLettersMapping.put("U", 8);
        this.numbersToLettersMapping.put("V", 8);
        this.numbersToLettersMapping.put("W", 9);
        this.numbersToLettersMapping.put("X", 9);
        this.numbersToLettersMapping.put("Y", 9);

        this.duplicatesResults = new ArrayList<>();
        this.numbers = new ArrayList<>();
    }

    public void start() {
        this.enter();
        this.compare();
        this.printResult();
    }

    private void enter() {
        int linesNumber;
            System.out.println("Enter dataset number:");
            datasetNumber = new Scanner(System.in).nextInt();
            for (int i = 0; i < datasetNumber; i++) {
                System.out.println(" ");
                System.out.println("Enter number of lines: ");
                linesNumber = new Scanner(System.in).nextInt();

                if (linesNumber < 0 || linesNumber > 100000) {
                    return;
                }
                numbers.add(new ArrayList<>());
                for (int j = 0; j < linesNumber; j++) {
                    System.out.println("Enter number " + j);
                    numbers.get(i).add(new StringBuilder(new Scanner(System.in).nextLine()));
                }

            System.out.println(" ");
        }
    }

    private void compare() {
        ArrayList<ArrayList<StringBuilder>> parsedNumbers = this.parseAllToNumbers();

        for (int i = 0; i < datasetNumber; i++) {
            duplicatesResults.add(new HashMap<>());

            for (int j = 0; j < parsedNumbers.get(i).size(); j++) {

                StringBuilder number = parsedNumbers.get(i).get(j);

                if (duplicatesResults.get(i).containsKey(Integer.parseInt(String.valueOf(number)))) {

                    int inc = duplicatesResults.get(i).get(Integer.parseInt(String.valueOf(number))) + 1;

                    duplicatesResults.get(i).put(Integer.parseInt(String.valueOf(number)), inc);

                } else {
                    duplicatesResults.get(i).put(Integer.parseInt(String.valueOf(number)), 1);
                }
            }

        }
    }

    private ArrayList<ArrayList<StringBuilder>> parseAllToNumbers() {

        ArrayList<ArrayList<StringBuilder>> parsedNumbers = new ArrayList<>();

        for (int i = 0; i < datasetNumber; i++) {

            parsedNumbers.add(new ArrayList<>());

            int numbersInDatasetSize = this.numbers.get(i).size();

            for (int j = 0; j < numbersInDatasetSize; j++) {

                StringBuilder readString = this.numbers.get(i).get(j);

                StringBuilder tempNumber = new StringBuilder();
                int numbersInStringSize = this.numbers.get(i).get(j).length();

                for (int k = 0; k < numbersInStringSize; k++) {

                    if (this.isNumeric(String.valueOf(readString.charAt(k)))) {
                    tempNumber.append(readString.charAt(k));

                    } else if (readString.charAt(k) != '-') {
                        tempNumber.append(this.numbersToLettersMapping.get(String.valueOf(readString.charAt(k))));
                        }
                    }

                parsedNumbers.get(i).add(tempNumber);
            }
        }
        return parsedNumbers;
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
        }
        catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private void printResult() {

        for (int i = 0; i < datasetNumber; i++) {

            if (duplicatesResults.get(i).size() == 0) {

                System.out.println("No duplicates.");
                continue;

            }

            ArrayList<ArrayList<String>> resultDatasetString = new ArrayList<>();

            resultDatasetString.add(this.makeArrayList(i));

            Collections.sort(resultDatasetString.get(0));

            for (int j = 0; j < resultDatasetString.get(0).size(); j++) {
                System.out.println(resultDatasetString.get(0).get(j));

            }

            System.out.println(" ");
        }
    }

    private ArrayList<String> makeArrayList(int i) {
        ArrayList<String> resultList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : duplicatesResults.get(i).entrySet()) {
            if (entry.getValue() != 1) {
                String result = this.addHyphen(String.valueOf(entry.getKey())) + " " + entry.getValue();
                resultList.add(result);
            }

        }
        return resultList;
    }

    private String addHyphen(String key) {

        return key.substring(0, 3) + "-" + key.substring(3);

    }

}
