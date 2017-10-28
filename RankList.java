package com.ryannm;

import java.util.*;

class RankList {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] scores = new int[]{};
        List<String> usernames = new ArrayList<>();

        int cases = s.nextInt();
        for (int i=0; i < cases; i++) {

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
                        System.arraycopy(scores, index, scores, index + 1, scores.length - index);// todo:anki
                    else System.arraycopy(scores, currentScoreIndex, scores, index, index + 1 - currentScoreIndex);
                }

                scores[index] = newScore; // todo: java.lang.ArrayIndexOutOfBoundsException: 0

                if (currentScoreIndex!=-1) usernames.remove(currentScoreIndex);
                usernames.add(index, username);

                submissionsLeft--;
            }

            int m = usernames.size();
            System.out.println(m);
            for(m = usernames.size()-1; m >=0; m--) System.out.println(usernames.get(m) + " " + scores[m]);
        }
    }
}
