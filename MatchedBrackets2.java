package com.ryannm;

import java.util.Scanner;

class MatchedBrackets2 {

    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int maxSmallChars = 0;
        int currSmallChars = 0;
        int maxBigChars = 0;
        int currBigChars = 0;
        int maxAltDepth = 0;
        int currAltDepth = 0;
        Boolean startedFromSmall = null;

        int nums = s.nextInt();

        while (nums > 0) {
            int num = s.nextInt();

            switch (num) {
                //startedFromSmall is used since the prev. one might not be sufficient info. Nullified at the end of parent chain
                // currSmallChars and currBigChars too
                case 1: // "("
                    if (startedFromSmall==null) startedFromSmall = true;
                    if (currBigChars!=0) currBigChars++;
                    currSmallChars++;
                    if ((!startedFromSmall && currAltDepth%2==0) || (startedFromSmall && currAltDepth%2==1)) {
                        currAltDepth++;
                    }

                    break;

                case 3: // "["
                    if (startedFromSmall==null) startedFromSmall = false;
                    if (currSmallChars!=0) currSmallChars++;
                    currBigChars++;
                    if ((!startedFromSmall && currAltDepth%2==1) || (startedFromSmall && currAltDepth%2==0)) { // todo
                        currAltDepth++;
                    }

                    break;

                case 2: // ")"
                    currAltDepth--;
                  /*  if (smallDepth==0) { // monitors the parent of all small brackets
                        if (currSmallChars > maxSmallChars) maxSmallChars = currSmallChars;
                    } else {
                        if (currAltDepth > maxAltDepth) maxAltDepth = currAltDepth;

                        currAltDepth--;
                    } */

                    currSmallChars = 0;

                    break;

                case 4:
                    if (currBigChars > maxBigChars) maxBigChars = currBigChars;
                    if (currAltDepth > maxAltDepth) maxAltDepth = currAltDepth;
                    currBigChars = 0;
                    currAltDepth--;
                    break;




            }

            nums--;
        }

    }
}
