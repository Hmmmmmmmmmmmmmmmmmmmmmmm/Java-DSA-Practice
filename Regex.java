package com.LL;

import java.util.regex.*;
public class Regex {
    public static void main(String[] args) {
            String regex = "\\d";
            String text = "abc 123 mew pew22";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                System.out.println("Match found at index " + matcher.start() + ": " + matcher.group());
            }
    }
}
