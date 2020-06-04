package com.challenge.hackerrank.interviewprepkit.sorting;

import java.util.*;

/**
 * Comparators are used to compare two objects. In this challenge, you'll create a comparator and use it to sort an array. The Player class is provided in the editor below. It has two fields:
 * <p>
 * : a string.
 * : an integer.
 * Given an array of  Player objects, write a comparator that sorts them in order of decreasing score. If  or more players have the same score, sort those players alphabetically ascending by name. To do this, you must create a Checker class that implements the Comparator interface, then write an int compare(Player a, Player b) method implementing the Comparator.compare(T o1, T o2) method. In short, when sorting in ascending order, a comparator function returns  if ,  if , and  if .
 * <p>
 * For example, given  Player objects with  values of , we want to sort the list as .
 * <p>
 * Function Description
 * <p>
 * Declare a Checker class that implements the comparator method as described. It should sort first descending by score, then ascending by name. The code stub reads the input, creates a list of Player objects, uses your method to sort the data, and prints it out properly.
 * <p>
 * Input Format
 * <p>
 * Locked stub code in the Solution class handles the following input from stdin:
 * <p>
 * The first line contains an integer, , the number of players.
 * Each of the next  lines contains a player's respective  and , a string and an integer.
 * <p>
 * Constraints
 * <p>
 * Two or more players can have the same name.
 * Player names consist of lowercase English alphabetic letters.
 * Output Format
 * <p>
 * You are not responsible for printing any output to stdout. Locked stub code in Solution will create a Checker object, use it to sort the Player array, and print each sorted element.
 * <p>
 * Sample Input
 * <p>
 * 5
 * amy 100
 * david 100
 * heraldo 50
 * aakansha 75
 * aleksa 150
 * Sample Output
 * <p>
 * aleksa 150
 * amy 100
 * david 100
 * aakansha 75
 * heraldo 50
 * Explanation
 * <p>
 * As you can see, the players are first sorted by decreasing score and then sorted alphabetically by name.
 *
 * @author shakil akhtar
 */
public class SortingComparator {

    public static void main(String[] args) {

    }


}

class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {

        if(a.score != b.score) {
            return b.score - a.score;
        }
        return a.name.compareTo(b.name);
    }
}

class Player {

    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}


