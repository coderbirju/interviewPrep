class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String ex : tokens){
            switch(ex){
                case "+":{
                    int first = st.pop();
                    int sec = st.pop();
                    st.push(first + sec);
                    break;
                }
                case "-":{
                    int first = st.pop();
                    int sec = st.pop();
                    st.push(sec - first);
                    break;
                }
                case "*":{
                    int first = st.pop();
                    int sec = st.pop();
                    st.push(first * sec);
                    break;
                }
                case "/":{
                    int first = st.pop();
                    int sec = st.pop();
                    st.push(sec / first);
                    break;
                }
                default:{
                    st.push(Integer.parseInt(ex));
                    break;
                }
            }
        }
        return st.pop();
    }
}