package com.challenge.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * @author Shakil Akhtar on 17/12/19
 */
public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle=new ArrayList<>();
        if(numRows==0){
            return triangle;
        }
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        triangle.add(row1);
        if(numRows==1){
            return triangle;
        }
        List<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(1);
        triangle.add(row2);
        if(numRows==2){
            return triangle;
        }
        for (int i=2;i<numRows;i++){
            List<Integer> r =  triangle.get(i-1);
            //create new row
            List<Integer> newRow = new ArrayList<>();
            for(int j=0;j<r.size();j++){
                if(j==0) {
                    newRow.add(r.get(j));
                }
                else {
                    newRow.add(r.get(j - 1) + r.get(j));
                }
            }
            newRow.add(r.get(r.size()-1));
            triangle.add(newRow);
        }
        return triangle;
    }
    public static void main(String[] args) {
        int n=5;
        List<List<Integer>> triangle = generate(n);
        for(List<Integer> l:triangle ){
            System.out.println();
            System.out.print("[");

            for (Integer i:l){
                System.out.print(i+" ");
            }
            System.out.print("]");
        }

    }
}
