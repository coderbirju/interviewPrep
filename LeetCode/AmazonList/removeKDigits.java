class Solution {
    public String removeKdigits(String num, int k) {
        String[] chars = num.split("");
        if(chars.length == 0 || chars.length <= k)
            return "0";
        int remain = k;
        Stack<Integer> st = new Stack();
        st.push(Integer.parseInt(chars[0]));
        for(int i=1; i<chars.length;i++){
            while(!st.isEmpty() && remain > 0 && Integer.parseInt(chars[i]) < st.peek()){
                st.pop();
                remain--;
            }
            if(st.isEmpty() &&  Integer.parseInt(chars[i]) == 0)
                continue;
            st.push(Integer.parseInt(chars[i]));
        }
        
        while(remain != 0 && !st.isEmpty()){
            st.pop();
            remain--;
        }
        
        String ans = "";
        
        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }
        if(ans.length() == 0)
            return "0";
        // if(ans.charAt(0) == '0')
        //     ans = trimmed(ans);
        
        return ans;
    }
    
//     private String trimmed(String ans){
//         int i =0;
//         while(i<ans.length() && ans.charAt(i) == '0')
//             i++;
//         if(i == ans.length())
//             return "0";
        
//         return ans.substring(i, ans.length());
//     }
}