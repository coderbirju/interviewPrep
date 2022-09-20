def collectingPebbles(self, numberOfPebbles, bucketSize):
    def f(index, remaining, dp):
        if remaining < 0:
            return math.inf
        if index == 0:
            if remaining < bucketSize[0]:
                return math.inf
            if remaining % bucketSize[0] == 0:
                return remaining // bucketSize[0]
            return math.inf

        if remaining == 0:
            return 0;

        if dp[index][remaining] != -1:
            return dp[index][remaining]

        pick = 1 + f(index, remaining - bucketSize[index], dp)
        nopick = f(index - 1, remaining, dp)

        dp[index][remaining] = min(pick, nopick)
        return min(pick, nopick)

    n = len(bucketSize)
    dp = [[0 for i in range(numberOfPebbles + 1)] for j in range(n)]

    

    answer = f(n - 1, numberOfPebbles, dp)

    if answer == math.inf:
        return -1
    return answer



# print(dp)
# for i in range(n):
#     dp[i][0] = math.inf

# for i in range(numberOfPebbles + 1):
#     if i < bucketSize[0]:
#         dp[0][i] = math.inf
#     elif i % bucketSize[0] == 0:
#         dp[0][i] = i // bucketSize[0]
#     else:
#         dp[0][i] = math.inf

# print(dp)

# for i in range(1, n):
#     for j in range(numberOfPebbles + 1):

#         index = max(0, j - bucketSize[i])

#         pick = 1 + dp[i][index]

#         nopick = dp[i - 1][j]

#         dp[i][j] = min(pick, nopick)

# if dp[-1][-1] == math.inf:
#     return -1

# return dp[-1][-1]