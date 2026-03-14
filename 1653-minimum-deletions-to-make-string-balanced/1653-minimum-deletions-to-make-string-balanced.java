class Solution {
    public int minimumDeletions(String s) {

        int bCount = 0;
        int deletions = 0;

        for(char c : s.toCharArray()) {

            if(c == 'b') {
                bCount++;
            } 
            else { // 'a'
                deletions = Math.min(deletions + 1, bCount);
            }
        }

        return deletions;
    }
}