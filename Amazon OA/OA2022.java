/*
*
Clint and his love for numbers
Clint loves numbers so much, that he tries to find some quirky math tricks whenever he can One day,
he decides to take up a number and tries to find out in how many minimum numbers of steps, can he
reduce that number to 0. The steps he performs were

Either decrease the number by 1, or
Replace the number by its largest prime divisor (note that divisor cannot be 1 and number itself).
Help Clint find the minimum number of steps to reduce the given norber to 0
Input Specification
input1: The number N
Output Specification
Return the minimum number of steps to reduce the number to 0.
Example 1
input1:9
Output: 4
Explanation:
Here, 9 can be reduced to 0 as
1 Replace it by its largest prime divisorie 3
2 Reduce 3 to 2



-----------
Purposing a similar idea except that we can use sieve to precompute all the largest prime for [2, N]. It should(?) have a better time complexity on paper, but in practice it is about 15 times slower than the simple prime factorization according to the benchmark I ran. To make the sieve version run faster, we can move the sieve function out and make sieve static so that it only runs once for all the test cases, but even then, it still loses to the simple prime factorization with no memo at all.

In conclusion, a simple prime factorization solution is probably your best bet. It finishes the testcases specified below within 65 ms while the sieve with static variable takes about 75 ms.

The benchmark I tested: 0 <= N <= 1e6 and T (num of testcases) = 1000.
--------
 */

 /**

 solution 1
  */

private static int brute(int N){
        if (N <= 2){
            return 2;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        boolean[] seen = new boolean[N+1];
        seen[N]=true;
        int ans = 2;
        while(true){
            for (int sz = queue.size(); sz > 0; --sz){
                int cur = queue.poll();
                if (cur == 2){
                    return ans;
                }
                if (!seen[cur-1]){
                    queue.offer(cur-1);
                    seen[cur-1]=true;
                }
                int prime = 0;
                for (int i = 2; i*i <= cur; i++){
                    while(cur % i == 0){
                        prime = i;
                        cur /= i;
                    }
                }
                prime = Math.max(prime, cur);
                if (!seen[prime]){
                    seen[prime]=true;
                    queue.offer(prime);
                }
            }
            ans++;
        }
    }


/*
*
solution 2
 */

    static int[] sieve = new int[1000001];
    private static int solve(int N){
        if (N <= 2){
            return N;
        }
        if (sieve[2]==0){
            for (int i = 2; i <= 1000000; i++){
                if (sieve[i] == 0){
                    for (int j = i; j <= 1000000; j += i){ // start looping from i, not i*i...
                        sieve[j]=i;
                    }
                }
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        boolean[] seen = new boolean[N+1];
        seen[N]=true;
        int ans = 2;
        while(true){
            for (int sz = queue.size(); sz > 0; --sz){
                int cur = queue.poll();
                if (cur == 2){
                    return ans;
                }
                if (!seen[cur-1]){
                    queue.offer(cur-1);
                    seen[cur-1]=true;
                }
                if (!seen[sieve[cur]]){
                    queue.offer(sieve[cur]);
                    seen[sieve[cur]]=true;
                }
            }
            ans++;
        }
    }