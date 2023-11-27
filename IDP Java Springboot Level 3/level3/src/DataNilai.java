import java.util.*;

public class DataNilai {

        public static List<String> toListString(List<List<String>> list2D) {

            return new ArrayList<>(list2D
                    .stream()
                    .flatMap(Collection::stream)
                    .filter(str -> {
                        try {
                            Integer.parseInt(str);
                        } catch (NumberFormatException nfe) {
                            return false;
                        }
                        return true;
                    }).toList());
        }

        public static List<Integer> toListInteger(List<String> listDataString) {
            List<Integer> listDataInteger = new ArrayList<>();

            listDataString.forEach(str -> listDataInteger.add(Integer.valueOf(str)));

            return listDataInteger;
        }

        public static Map<Integer, Integer> groupingData(List<Integer> listData) {
         Map<Integer, Integer> dataGroupMap = new LinkedHashMap<>();

            listData.forEach(data -> {
                Integer currCount = dataGroupMap.get(data) == null ? 1 : dataGroupMap.get(data) + 1;
                dataGroupMap.put(data, currCount);
            });

            return dataGroupMap;
        }

        public static List<String> formatLineFromMap(Map<Integer, Integer> mapData) {
            List<String> linesData = new ArrayList<>();

            for (Map.Entry<Integer, Integer> entry : mapData.entrySet()) {
                linesData.add(String.format("%d     |    %d", entry.getKey(), entry.getValue()));
            }

            return linesData;
        }
        public static Integer findModusFromMap(Map<Integer, Integer> mapData) {
            Integer modus = 0;
            Integer maxCount = 0;

            for (Map.Entry<Integer, Integer> entry : mapData.entrySet()) {
                if (entry.getValue().compareTo(maxCount) > 0) {
                    maxCount = entry.getValue();
                    modus = entry.getKey();
                }
            }

            return modus;
        }

        public static Integer findMedianFromList(List<Integer> listData) {
            Integer median = 0;
            int lenght = listData.size();
            boolean even = lenght % 2 == 0;

            Collections.sort(listData);
            if (even) {
                median = ( listData.get(lenght/2) + listData.get((lenght/2) + 1) ) / 2;
            } else {
                median = listData.get((lenght-1)/2);
            }

            return median;
        }

        public static Double findMeanFromList(Map<Integer, Integer> listData) {
            double sum = 0;
            int count = 0;

            for (Map.Entry<Integer, Integer> entry : listData.entrySet()) {
                sum += entry.getKey() * entry.getValue();
                count += entry.getValue();
            }

            if (sum == 0 || count == 0) throw new IllegalArgumentException("List Data is Empty!");

            return sum/count;
        }
    }
