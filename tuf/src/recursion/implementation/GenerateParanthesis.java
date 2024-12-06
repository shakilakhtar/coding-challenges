package recursion.implementation;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> results =  new ArrayList<>();
        generate(0,0,n, "", results);

        return results;
    }

    private void generate(int openBracket, int closeBracket, int n , String current, List<String> results){

        if(openBracket ==  closeBracket && openBracket + closeBracket == 2 * n){
            results.add(current);
            return;
        }
        if (openBracket < n){
            generate(openBracket + 1, closeBracket, n, current + "(",results);
        }
        if (closeBracket < openBracket){
            generate(openBracket, closeBracket + 1, n, current + ")", results);
        }
    }
    public static void main(String[] args) {

    }
}
