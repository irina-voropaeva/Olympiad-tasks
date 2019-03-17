import java.util.*;

public class Numbers {

    private HashMap<String, Integer> numbersToLettersMapping;
    private ArrayList<HashMap<Integer, Integer>> duplicatesResults;
    private int datasetNumber;
    private int linesNumber;
    private ArrayList<StringBuilder> numbers;

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
    }

    public void start() {
        this.enter();
        this.compare();
        this.printResult();
    }

    private void enter() {
        System.out.println("Enter dataset number:");
        datasetNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < datasetNumber; i++) {
            System.out.println(" ");
            System.out.println("Enter number of lines: ");
            linesNumber = new Scanner(System.in).nextInt();
            if (linesNumber < 0 || linesNumber > 100000) {
                return;
            }
            numbers = new ArrayList<>();
            for (int j = 0; j < linesNumber; j++) {
                numbers.add(new StringBuilder(new Scanner(System.in).nextLine()));
            }
            System.out.println(" ");
        }
    }

    private void compare() {
        ArrayList<StringBuilder> parsedNumber = this.parseAllToNumbers();

        for (int i = 0; i < datasetNumber; i++) {
            HashMap<Integer, Integer> tempDuplicatesResults = new HashMap<>();

            for (int j = 0; j < parsedNumber.size(); j++) {
                if (tempDuplicatesResults.containsKey(Integer.parseInt(String.valueOf(parsedNumber.get(j))))) {
                    int inc = tempDuplicatesResults.get(Integer.parseInt(String.valueOf(parsedNumber.get(j)))) + 1;
                    tempDuplicatesResults.put(Integer.parseInt(String.valueOf(parsedNumber.get(j))), inc);
                }
                else {
                    tempDuplicatesResults.put(Integer.parseInt(String.valueOf(parsedNumber.get(j))), 1);
                }
            }
            Iterator it = tempDuplicatesResults.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (pair.getValue() != null) {
                    int keyResult = Integer.parseInt(String.valueOf(pair.getValue()));
                    if (keyResult == 1) {
                        tempDuplicatesResults.remove(keyResult);
                        it.remove();
                    }
                }
            }
            duplicatesResults.add(tempDuplicatesResults);
        }
    }

    private ArrayList<StringBuilder> parseAllToNumbers() {
        ArrayList<StringBuilder> parsedNumbers = new ArrayList<>();
        for (int i = 0; i < this.numbers.size(); i++) {
            int numbersLength = this.numbers.get(i).length();
            if (numbersLength != 0) {
                for (int k = 0; k < numbersLength; k++) {
                    if (this.numbers.get(i).charAt(k) == '-') {
                        this.numbers.get(i).deleteCharAt(k);
                        numbersLength--;
                    }
                }
                StringBuilder tempNumber = new StringBuilder();

                for (int j = 0; j < numbers.get(i).length(); j++) {
                    if (this.isNumeric(String.valueOf(this.numbers.get(i).charAt(j)))) {
                        tempNumber.append(this.numbers.get(i).charAt(j));
                    } else {
                        tempNumber.append(this.numbersToLettersMapping.get(String.valueOf(this.numbers.get(i).charAt(j))));
                    }
                }
                parsedNumbers.add(tempNumber);
            }
        }
        return parsedNumbers;
    }

    private boolean isNumeric(String str) {
        try
        {
            Integer.parseInt(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    private void printResult() {
        for(int i = 0; i < datasetNumber; i++) {
            if (duplicatesResults.get(i).size() == 0) {
                System.out.println("No duplicates.");
                break;
            }
            ArrayList<String> resultDatasetString = this.makeArrayList(i);

            Collections.sort(resultDatasetString);
            /*for (int j = 0; j < resultDatasetString.size(); j++) {
                System.out.println(resultDatasetString.get(j));
            }*/
            System.out.println(" ");
        }
    }

    private ArrayList<String> makeArrayList(int i) {
        ArrayList<String> resultList = new ArrayList<>();
        for (int j = 0; j < duplicatesResults.get(i).size(); j++) {

            Iterator it = duplicatesResults.get(i).entrySet().iterator();

            while (it.hasNext()) {
                HashMap.Entry pair = (HashMap.Entry) it.next();
                if (pair.getValue() != null) {
                    int keyResult = Integer.parseInt(String.valueOf(pair.getKey()));
                    String result = this.addHyphen(keyResult) + " " + duplicatesResults.get(i).get(keyResult);
                    resultList.add(result);
                }
            }
        }
        System.out.println("result dataset string size: " + resultList.size());
        for (int j = 0; j < resultList.size(); j++) {
            System.out.println(resultList.get(j));
        }
        return resultList;
    }

    private String addHyphen(int key) {
        String stringKey = Integer.toString(key);
        return stringKey.substring(0,3) + "-" + stringKey.substring(3,7);
    }
}
