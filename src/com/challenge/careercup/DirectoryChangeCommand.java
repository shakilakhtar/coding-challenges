package com.challenge.careercup;

import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class DirectoryChangeCommand {

    private Map<String, Integer> visitCount(String path) {
        final Map<String, Integer> count = new LinkedHashMap<>();
        String[] parts = path.split("\\/");
        Deque<String> st = new LinkedList<>();
        for (String part : parts) {
            if (st.isEmpty() || !part.equals("..")) {
                count.put(part, count.getOrDefault(part, 1));
                st.push(part);
            } else {
                st.pop();
                count.put(st.peek(), count.get(st.peek()) + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
