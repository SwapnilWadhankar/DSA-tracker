import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        List<Integer> ans = spiralOrder(mat);

        for(int i = 0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }

        System.out.println();

    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int top=0;
        int left=0;
        int right=matrix[0].length-1;
        int bottom=matrix.length-1;

        while(top<=bottom && left<=right){

            for(int i=left;i<=right;i++){
                ans.add(matrix[top][i]);
            }
            top++;

            for(int i=top;i<=bottom;i++){
                ans.add(matrix[i][right]);
            }
            right--;


            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}
