import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllocateMinimumPagesBinarySearch {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(12);
        arr.add(34);
        arr.add(67);
        arr.add(90);

        System.out.println(findPages(arr,arr.size(),2));
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m){
        if(m>n){
            return -1;
        }
        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();
        while(low<=high){
            int mid = high + (low-high)/2;
            int students = countStudents(arr,mid);
            if(students>m){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    public static int countStudents(ArrayList<Integer> arr,int pages){
        int students = 1;
        int studentPages = 0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)+studentPages <= pages){
                studentPages += arr.get(i);
            }else{
                students++;
                studentPages = arr.get(i);
            }
        }
        return students;
    }
}
