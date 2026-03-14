class Solution {
    public int findSmallestInteger(int[] nums, int value) {

        int[] count = new int[value];

        for(int num : nums){
            int r = ((num % value) + value) % value;
            count[r]++;
        }

        int mex = 0;

        while(true){

            int r = mex % value;

            if(count[r] == 0)
                return mex;

            count[r]--;
            mex++;
        }
    }
}