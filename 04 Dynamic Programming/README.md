## Task
**We consider the so-called partition problem:** Given are natural numbers $a_1, . . . ,a_n$. We want to decide whether there is an index set $I ⊆ \{1, . . . , n\}$ so that $\sum_{i\in I}a_i = \sum_{i\in \{1,...,n\}\backslash I}a_i$ exists.

I am using dynamic programming to solve the partition problem in $O(nS).$

Consider that $S=\sum_{i=1}^{n}a_n$.

My solution indicates if there is such a set.

**NOTE**:
My tutor said that line 26 is always 0, I have a different opinion. I haven't had time to print the table into the terminal to be able to determine it reliably.