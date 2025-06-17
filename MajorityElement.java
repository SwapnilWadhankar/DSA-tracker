import java.util.Hashtable;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] array = {2,2,1,1,1,2,2,1,1,1,1,2,2,2,2,2,2,2,3,3,3,3,3,3,33,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3};
        System.out.println(majorityElement(array));
    }
    public static int majorityElement(int[] nums){
        Hashtable<Integer,Integer> elements = new Hashtable<>();
        for(int num:nums){
            elements.put(num,elements.getOrDefault(num,0)+1);
        }
        int max = 0;
        for(int i:elements.values()){
            if(i>max){
                max=i;
            }
        }
        int keyfound =0;
        for (Map.Entry<Integer, Integer> entry : elements.entrySet()) {
            if (entry.getValue().equals(max)) {
                keyfound = entry.getKey();
                break; // Stop when the value is found
            }
        }
        return keyfound;

    }
}
