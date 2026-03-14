class Solution {

    List<String> list = new ArrayList<>();

    public String getHappyString(int n, int k) {

        backtrack("", n);

        if(k > list.size())
            return "";

        return list.get(k-1);
    }

    private void backtrack(String curr, int n){

        if(curr.length() == n){
            list.add(curr);
            return;
        }

        char[] letters = {'a','b','c'};

        for(char ch : letters){

            if(curr.length() > 0 && curr.charAt(curr.length()-1) == ch)
                continue;

            backtrack(curr + ch, n);
        }
    }
}