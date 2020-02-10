import java.util.*;

class Solution {
    class Truck{
        int time;
        int weight;
        Truck(int time, int weight){
            this.time = time;
            this.weight = weight;
        }
        public void pass(){
            this.time--;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totalWeight = 0;
        int trucksCnt = truck_weights.length;
        Stack<Integer> waiting = new Stack<>();
        LinkedList<Truck> processing = new LinkedList<>();
        for(int i = trucksCnt-1; i >= 0 ; i-- ){
            waiting.push(truck_weights[i]);
        }

        while(true){
            if(waiting.isEmpty()){
                answer += processing.getLast().time;
                break;
            }
            answer++;
            int truck = waiting.pop();
            if(truck + totalWeight > weight){
                waiting.push(truck);
            }else{
                processing.add(new Truck(bridge_length, truck));
                totalWeight += truck;
            }

            for(int i = 0 ; i < processing.size() ; i++){
                processing.get(i).pass();
            }

            if(processing.getFirst().time == 0){
                Truck arrive = processing.poll();
                totalWeight -= arrive.weight;
            }
        }
        return ++answer;
    }
}