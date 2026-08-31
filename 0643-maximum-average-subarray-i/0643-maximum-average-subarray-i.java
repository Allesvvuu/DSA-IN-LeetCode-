class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0 ;
        for(int i =0;i<k; i ++){
            sum += nums[i];
        }
        double Max = sum;
        for(int j=k;j<nums.length;j++){
            sum+= nums[j];
            sum-= nums[j-k];
            Max =Math.max(Max,sum);
        }
        return Max/k;
        
    }
}