package hackerrank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Solution {
  private static class Order{
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
      builder.append("[Id=").append(Id).append(", areaToDeliver=").append(areaToDeliver)
          .append(", productName=").append(productName).append(", Quantity=").append(Quantity)
          .append(", brand=").append(brand).append("]");
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
    String Id = null;
    String areaToDeliver = null;
    String productName = null;
    int Quantity = 0;
    String brand = null;
  }
  private Map<String,List<Order>> orderMap = null;
  private Map<String,String> averageMap = null;
  private Map<String,String> productBrandMap= null;
  
  public Solution() {
    super();
    this.orderMap = new HashMap<>();
    this.averageMap = new HashMap<>();
    this.productBrandMap = new HashMap<>();
  }

  public static void generateFiles(String input_file_name) throws IOException {
      Solution solution = new Solution();
      solution.populateOrderMapFrom(input_file_name);
      solution.findAverage();
      solution.findPopularBrand();
      writeToAFile(solution.averageMap,"0_"+input_file_name);
      writeToAFile(solution.productBrandMap,"1_"+input_file_name);
    
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
  static <K,V> void writeToFile(Map<K,V> map,String outputFileName) throws IOException {
    String csv =  map.entrySet().stream()
            .map(entry -> entry.getKey()+","+entry.getValue()+",")
            .collect(Collectors.joining("\r\n"));
    try (PrintWriter writer = new PrintWriter(outputFileName)){
      writer.write(csv);
    }
  }
  static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
    SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
        new Comparator<Map.Entry<K,V>>() {
            @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                int res = e1.getValue().compareTo(e2.getValue());
                if (e1.getKey().equals(e2.getKey())) {
                    return res; // Code will now handle equality properly
                } else {
                    return res != 0 ? res : 1; // While still adding all entries
                }
            }
        }
    );
    sortedEntries.addAll(map.entrySet());
    return sortedEntries;
}
  private void populateOrderMapFrom(String inputFileName) throws IOException {
    Path path = Paths.get(inputFileName);
    try(BufferedReader reader = Files.newBufferedReader(path)){
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
    TreeMap<String,Long> brandMap = new TreeMap<String,Long>();
    for(Entry<String,List<Order>> entry : orderMap.entrySet()) {
      for(Order order:entry.getValue()) {
        Long n = brandMap.get(order.getBrand());
        if(Objects.isNull(n)) {
          n = 0L;
        }
        brandMap.put(order.getBrand(), n+1);
      }
      SortedSet<Map.Entry<String,Long>> sortedEntries = entriesSortedByValues(brandMap);
      Map.Entry<String,Long> popularEntry =  sortedEntries.last();
      this.productBrandMap .put(entry.getKey(),popularEntry.getKey());
      brandMap.clear();
    }
    System.out.println(productBrandMap);
  }
  private void findAverage() {
    double totalOrders = 0;
    for(List<Order> orderList:orderMap.values()) {
      totalOrders+=orderList.size();
    }
    for(Entry<String,List<Order>> entry : orderMap.entrySet()) {
       long totalProductOrder =0;
       for(Order order:entry.getValue()) {
         totalProductOrder+= order.getQuantity();
       }
       double avg = totalProductOrder/totalOrders;
       averageMap.put(entry.getKey(), String.valueOf(avg));
    }
    System.out.println(averageMap);
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
  public static void main(String[] args) {
    try {
      generateFiles("input_example.csv");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
