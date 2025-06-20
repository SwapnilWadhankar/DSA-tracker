public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea1(height));
    }
    public static int maxArea(int[] height) {
        int left=0; int area =0;
        while(left<height.length){
            for(int right=0;right<height.length;right++){
                int lenght = right-left;
                int breadth = Math.min(height[left],height[right]);
                area=Math.max(area,lenght*breadth);
            }
            left++;
        }
        return area;
    }

    public static int maxArea1(int[] height){
        int left=0;
        int right=height.length-1;
        int maxArea=0;
        while(left<right){
            int width = right-left;
            int length = Math.min(height[left],height[right]);
            maxArea=Math.max(maxArea,width*length);

            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;

    }

}
