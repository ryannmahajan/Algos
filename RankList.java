// Problem link: https://www.codechef.com/ICOP1802/problems/ISTA2006
package com.ryannm;

import java.util.*;

class RankList {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] scores = new int[]{}; // Array because binary search can be called without coding it from scratch
       
        List<String> usernames = new ArrayList<>(); 

        int cases = s.nextInt();
        while (cases > 0) {

            int submissionsLeft = s.nextInt();
           // int problemCodes =
                    s.nextInt();

            s.nextLine(); s.nextLine();// don't need problem codes 

            while (submissionsLeft>0) {

                String username = s.next();
                s.next();
                int currentScore = 0;
                int currentScoreIndex = usernames.indexOf(username);

                if (currentScoreIndex!=-1) {
                    currentScore = scores[currentScoreIndex];
                }

                int newScore = currentScore + s.nextInt();

                int index = 0;
                if (scores.length!=0) index = Arrays.binarySearch(scores, newScore);

                if (scores.length-index > 1) {
                    if (currentScoreIndex == -1)
                        System.arraycopy(scores, index, scores, index + 1, scores.length - index);
                    else System.arraycopy(scores, currentScoreIndex, scores, index, index + 1 - currentScoreIndex);
                }

                scores[index] = newScore; 
                /* todo: java.lang.ArrayIndexOutOfBoundsException: 0 on line 44.
                Arrays have fixed size. But if I don't use array, then the binary search on line 36 will have to be coded fresh. What can be done ?
                */

                if (currentScoreIndex!=-1) usernames.remove(currentScoreIndex);
                usernames.add(index, username);

                submissionsLeft--;
            }

            int m = usernames.size();
            System.out.println(m);
            for(m = usernames.size()-1; m >=0; m--) System.out.println(usernames.get(m) + " " + scores[m]);
            
            cases--;
        }
    }
}
