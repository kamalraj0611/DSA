/*
https://leetcode.com/problems/binary-watch/description/
401. Binary Watch
Solved
Easy
Topics
premium lock icon
Companies
Hint
A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the bottom to represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.

For example, the below binary watch reads "4:51".


Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring the PM), return all possible times the watch could represent. You may return the answer in any order.

The hour must not contain a leading zero.

For example, "01:00" is not valid. It should be "1:00".
The minute must consist of two digits and may contain a leading zero.

For example, "10:2" is not valid. It should be "10:02".
 

Example 1:

Input: turnedOn = 1
Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
Example 2:

Input: turnedOn = 9
Output: []
 

Constraints:

0 <= turnedOn <= 10
  */

class Solution {

    public List<String> readBinaryWatch(int turnedOn) {
         List<String> result = new ArrayList<>();
         backTrack(turnedOn, result, 0, 0 ,0);
         return result;
    }

    public void backTrack(int turnedOn, List<String> result, int start, int hour ,int min)
    {   
        if(hour > 11 || min > 59) return;
        if(turnedOn == 0)
        {
            result.add(hour + ":"+ (min < 10 ? "0" + min : min));
            return;
        }
        
        for(int i = start; i < 10; i++)
        {
            if(i < 4)
            {
                backTrack(turnedOn - 1, result, i + 1, hour + (1 << i), min);
                
            }
            else
            {
                backTrack(turnedOn - 1, result, i + 1, hour , min + (1 << (i-4)));
            }
        }
    }

    

}
