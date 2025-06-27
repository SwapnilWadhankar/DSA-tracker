import java.util.HashMap;

public class FruitInBaskets {
    public static void main(String[] args) {
        int[] fruits = {0,1,2,2};
        System.out.println(totalFruit(fruits));
    }
    public static int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> basket = new HashMap<>();
        int left=0;
        int max=0;
        for(int right=0;right<fruits.length;right++){
            basket.put(fruits[right],basket.getOrDefault(fruits[right],0)+1);
            while(basket.size()>2){
                basket.put(fruits[left], basket.get(fruits[left])-1);
                if(basket.get(fruits[left])==0){
                    basket.remove(fruits[left]);
                }
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}
