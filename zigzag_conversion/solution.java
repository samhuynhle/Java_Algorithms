
/*
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
        {
            return s;
        }
        char[][] zigZagGrid = buildZigZagGrid(s, numRows);
        StringBuilder result = new StringBuilder(s.length());

        for(int i = 0; i < zigZagGrid.length; i++){
            for(int j = 0; j < s.length(); j++){
                if(zigZagGrid[i][j] != '\u0000'){
                    result.append(zigZagGrid[i][j]);
                }
            }
        }

        return result.toString();
    }
    public char[][] buildZigZagGrid(String s, int numRows)
    {
        char[][] zigZagGrid= new char[numRows][s.length()];

        int row = -100;
        int rowIndex = -100;
        boolean traversing = false;

        for(char character : s.toCharArray()){
            if(row == -100){
                row = 0;
                rowIndex = 0;
            } else {
                if(traversing == false){
                    row +=1;
                    if(row == numRows - 1)
                    {
                        traversing = true;
                    }
                } else {
                    row -= 1;
                    rowIndex += 1;
                    if(row == 0){
                        traversing = false;
                    }
                }
            }
            zigZagGrid[row][rowIndex] = character;
        }
        return zigZagGrid;
    }
}