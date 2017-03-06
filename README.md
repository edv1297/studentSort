Yoon Hong and Eddy Varela: Lab 4 

5.5) The running time of the matrix multiplication: O(n^3)

———————————————————————————————————————————————————————————————

5.23) Base case: n = 0 
Given 5^n - 4n - 1 —> 5^(0) - 4(0) - 1 = 1 - 0 - 1 = 0
0 is divisible by 16, so n is divisible by 16 for n = 0: TRUE

Inductive step: k = n-1
Inductive hypothesis: ‘5^n - 4n - 1 is divisible by 16’ is true for n = 0. 
Let k = n-1, and if ‘5^k - 4k - 1 is divisible by 16’ is also true for k = n-1,
then we can say that it also holds true for all values less than n.

5^k - 4k - 1 = 
5^(n-1) - 4(n-1) - 1 = 
5^n - 20(n-1) - 5
Since 16(n-1) is divisible by 16, adding that to ‘5^n - 20(n-1) - 5’ should not
affect the divisibility of it by 16, if it is already divisible by 16.

5^n - 20(n-1) - 5 + 16(n-1) = 
5^n - 4(n-1) - 5 = 
5^n - 4n - 1, which we have already proven true in our base case.
Therefore, 5^n -4n - 1 is divisible by 16 for all n>= 0.

———————————————————————————————————————————————————————————————

5.26) Base case: n=1
Given the sum of 2i from i to n = n(n+1) for i=1 and n=1:
2(1) = 1(1+1) = 2 = 2: TRUE

Inductive step: k = n+1 
Inductive hypothesis: ‘the sum of 2i from i to n = n(n+1)’ is true for i=1 and n=1:
Let k = n+1, and if ‘the sum of 2i from i to n = k(k+1)’ is also true for i=1 and k = n+1, then we can say that it also holds true for all values following n.

We know that ‘the sum of 2i from i to n = n(n+1)’ is true for n=1.

And if you notice, ‘the sum of 2i from i to n = n(n+1)’ 
= 2(1) + 2(2) + 2(3) + … 2(n) (Let’s call it ‘**’)

And the sum of 2i from i to k = k(k+1) = (n+1)(n+2) 
= 2(1) + 2(2) + 2(3) + … 2(k)
= 2(1) + 2(2) + 2(3) + … 2(n+1) 
also equals : ‘**’ + 2(n+1) because

[2(1) + 2(2) + 2(3) + … 2(n+1)] - 2(n+1) equals
 2(1) + 2(2) + 2(3) + … 2(n)

Since we have proven the base case to be true, and ‘the sum of 2i from i to n+1’ is simply ‘the sum of 2i from i to n’ plus 2(n+1),
(n+1)(n+2) = n(n+1) + 2(n+1)
n^2 + 3n + 2 = n^2 +n + 2(n+1)
n^2 + 3n + 2 = n^2 + 3n + 2 << TRUE
Therefore, the sum of 2i from i to n = n(n+1) for all n >= 1.

———————————————————————————————————————————————————————————————

6.3) Best and average times are the same: O(n^2)

———————————————————————————————————————————————————————————————

6.4) Best: O(n)
Average: O(n^2)
Worst: O(n^2)