package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map.Entry;

class Result {

    /*
     * Complete the 'generateFiles' function below.
     *
     * The function accepts STRING input_file_name as parameter.
     */
    private Map<String,List<Order>> orderMap = new HashMap<>();
    private Map<String,String> averageMap = new HashMap<>();
    private Map<String,String> productBrandMap= new HashMap<>();

    private void populateOrderMapFrom(String inputFileName) throws IOException {
        Path path = Paths.get(inputFileName);
        try(var reader = Files.newBufferedReader(path)){
            String line = reader.readLine();
            while(Objects.nonNull(line) ) {
                Order o = csvToOrder(line);
                List<Order> orderList = getOrderListForProduct(o.getProductName());
                orderList.add(o);
                orderMap.put(o.getProductName(), orderList);
                line = reader.readLine();
            }
        }
    }
    private void findPopularBrand() {
        var brandMap = new TreeMap<String,Long>();
        for(var entry : orderMap.entrySet()) {
            for(Order order:entry.getValue()) {
                Long n = brandMap.get(order.getBrand());
                if(Objects.isNull(n)) {
                    n = 0L;
                }
                brandMap.put(order.getBrand(), n+1);
            }
            var sortedEntries = entriesSortedByValues(brandMap);
            var popularEntry =  sortedEntries.last();
            this.productBrandMap.put(entry.getKey(),popularEntry.getKey());
            brandMap.clear();
        }
    }
    private void findAverage() {
        double totalOrders = 0;
        for(var orderList:orderMap.values()) {
            totalOrders+=orderList.size();
        }
        for(var entry : orderMap.entrySet()) {
            long totalProductOrder =0;
            for(Order order:entry.getValue()) {
                totalProductOrder+= order.getQuantity();
            }
            double avg = totalProductOrder/totalOrders;
            averageMap.put(entry.getKey(), String.valueOf(avg));
        }
    }

    private List<Order> getOrderListForProduct(String productName){
        orderMap.putIfAbsent(productName,new ArrayList<Order>());
        return orderMap.get(productName);
    }
    private Order csvToOrder(String line) {
        String[] order = line.split(",");
        Order o = new Order();
        o.setId(order[0]);
        o.setAreaToDeliver(order[1]);
        o.setProductName(order[2]);
        o.setQuantity(Integer.parseInt(order[3]));
        o.setBrand(order[4]);
        return o;
    }
    static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        var sortedEntries = new TreeSet<Map.Entry<K,V>>(
                new Comparator<Map.Entry<K,V>>() {
                    @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        int res = e1.getValue().compareTo(e2.getValue());
                        if (e1.getKey().equals(e2.getKey())) {
                            return res;
                        } else {
                            return res != 0 ? res : 1;
                        }
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
    static <K,V> void writeToAFile(Map<K,V> map,String outputFileName) throws IOException {
        StringBuilder builder = new StringBuilder();
        for(Entry<K,V> entry: map.entrySet()) {
            builder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append("\r\n");
        }
        try (Writer writer = new FileWriter(outputFileName)){
            writer.write(builder.toString());
        } catch (IOException e) {
            throw e;
        }
    }
    public static void generateFiles(String input_file_name) {
        try {
            var result = new Result();
            result.populateOrderMapFrom(input_file_name);
            result.findAverage();
            result.findPopularBrand();
            writeToAFile(result.averageMap,"0_"+input_file_name);
            writeToAFile(result.productBrandMap,"1_"+input_file_name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void findAverageUsingStreams() {
        double totalOrders = orderMap.values().stream()
                .mapToDouble(x-> x.size())
                .sum();
        Map<String,Double> avgMap = orderMap.entrySet()
                .stream()
                .collect(
                    Collectors.toMap(e-> e.getKey(), e->e.getValue().stream().mapToDouble(Order::getQuantity).sum()/ totalOrders)
                );
        System.out.println("Average Map = "+avgMap);
    }
    private void findPopularBrandUsingStreams() {
         Map<String,String> brndMap = orderMap.values().stream()
                 .flatMap(List::stream)
                 .toList()
                 .stream()
                 .collect(Collectors.groupingBy(x->x.getProductName(),Collectors.groupingBy(
                         x->x.getBrand(),Collectors.summingInt(x->x.getQuantity())
                 )))
                 .entrySet().stream()
                 .collect(Collectors.toMap(x->x.getKey(),x ->{
                     return x.getValue().entrySet().stream()
                             .max(Map.Entry.comparingByValue())
                             .map(Entry::getKey)
                             .orElse("");
                 }));

        System.out.println("Brand Map = " +brndMap);
    }
    public static void generateFilesUsingStreams(String input_file_name) {
        try {
            var result = new Result();
            result.populateOrderMapFrom(input_file_name);
            result.findAverageUsingStreams();
            result.findPopularBrandUsingStreams();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
class Order{
    private String Id = null;
    private String areaToDeliver = null;
    private String productName = null;
    private int Quantity = 0;
    private String brand = null;

    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public String getAreaToDeliver() {
        return areaToDeliver;
    }
    public void setAreaToDeliver(String areaToDeliver) {
        this.areaToDeliver = areaToDeliver;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{Id=").append(Id).append(", areaToDeliver=").append(areaToDeliver)
                .append(", productName=").append(productName).append(", Quantity=").append(Quantity)
                .append(", brand=").append(brand).append("}\n");
        return builder.toString();
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getQuantity() {
        return Quantity;
    }
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
}
public class BenifyOrderProblem {
    public static void main(String[] args) throws IOException {
        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input_file_name = "input_example.csv";//bufferedReader.readLine();
        Result.generateFilesUsingStreams(input_file_name);
        // bufferedReader.close();
    }
}