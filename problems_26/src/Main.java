import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

   public static void main(String[] args) {
      System.out.println(new Solution().solution(2, 10 ,new int[]{7,4,5,6}));
      System.out.println(new Solution().solution(100, 100 ,new int[]{10}));
      System.out.println(new Solution().solution(100, 100 ,new int[]{10,10,10,10,10,10,10,10,10,10}));
   }
}

class Solution {
   public int solution(int bridge_length, int weight, int[] truck_weights) {
      int answer = 0;

      int index =0;
      Bridge bridge = new Bridge(bridge_length, weight);

      while (true){
         if(index < truck_weights.length && bridge.isPossible(truck_weights[index])){
            Truck truck = new Truck(truck_weights[index++]);
            bridge.on(truck);
         }
         bridge.move_truck();
         answer++;

         if(bridge.getCompleted_trucks().size() == truck_weights.length){
            answer++;
            break;
         }
      }

      return answer;
   }
}

class Bridge{
   List<Truck> trucks = new ArrayList<>();
   private int bridge_length;
   private int weight;
   private List<Truck> completed_trucks = new ArrayList<>();

   public Bridge(int bridge_length , int weight){
      this.bridge_length = bridge_length;
      this.weight = weight;
   }

   public void on(Truck truck){
      trucks.add(truck);
   }

   public void move_truck(){
      Iterator<Truck> iterator = trucks.iterator();
      while (iterator.hasNext()) {
         Truck truck = iterator.next();
         truck.move();
         if(!truck.onBridge(bridge_length)){
            completed_trucks.add(truck);
            iterator.remove();
         }

      }
   }

   public List<Truck> getCompleted_trucks() {
      return completed_trucks;
   }

   public boolean isPossible(int weight) {
      if(trucks.isEmpty() || trucks.stream().mapToInt(Truck::getWeight).sum()+weight <= this.weight){
         return true;
      }
      return false;
   }
}

class Truck {
   private int move_length = 0;
   private int weight;
   public Truck(int weight){
      this.weight = weight;
   }

   public void move() {
      this.move_length++;
   }

   public boolean onBridge(int bridge_length){
      return this.move_length < bridge_length;
   }

   public int getWeight() {
      return this.weight;
   }
}


