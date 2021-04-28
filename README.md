
## The Problem

The problem is to find all unique configurations of a set of normal chess pieces on a chess board with
dimensions M x N where none of the pieces is in a position to take any of the others. Providing the number
of results is useful, but not enough to complete the assignment. Assume the colour of the piece does not
matter, and that there are no pawns among the pieces.
Write a program which takes as input:

1. The dimensions of the board: M, N.
2. The number of pieces of each type (King, Queen, Bishop, Rook and Knight) to try and place on
   the board.

As output, the program should list all the unique configurations to the console for which all of the pieces
can be placed on the board without threatening each other.
When returning your solution, please provide with your answer the total number of unique configurations
for a 7x7 board with 2 Kings, 2 Queens, 2 Bishops and 1 Knight. Also provide the time it took to
get the final score. Needless to say, the lower the time, the better.


---

## The Solution

The following solution is based on the [N-Queen Problem](http://mathcenter.oxford.emory.edu/site/cs171/nQueensProblemAndBacktracking/), 
which is a well-known optimization problem taught in Computer Science classes. The proposed solution makes use of 
a technique called backtracking to find all the solutions to the problem. Based on experience with old problems, 
I reduced the current problem to an N-Queen problem with an 8x8 card. After getting a basic solution, I 
added more parts, determined how they moved, wrote unit tests and finally worked with a focus on improving 
performance because in some scenarios the algorithm proved to be very slow. Further testing would be needed 
with some profiling tool to check the points in the code and adjust. There are other solutions using Genetic 
Algorithms, among others, but I didn't have time to go deeper to propose other views. Thanks

---

## Dependencies

1. Git
2. JDK 1.8
3. Maven 3

---

## Instructions

1. git clone (https://robinsonvs@bitbucket.org/robinsonvs/chesschallenge.git)
2. cd chesschallenge
3. mvn clean install
4. cd target
5. java -jar chesschallenge-1.0-SNAPSHOT.jar

---

## Result average times

#### Configuration: {"7", "7", "K:2;Q:2;B:2;N:1"}
- Number of configurations: 3063828
- Average time: 75641 ms

#### Configuration: {"8", "8", "Q:8"}
- Number of configurations: 92
- Average time: 4782 ms

#### Configuration: {"3", "3", "K:2;R:1"}
- Number of configurations: 4
- Average time: 24 ms

#### Configuration: {"4", "4", "N:4;R:2"}
- Number of configurations: 8
- Average time: 61 ms
