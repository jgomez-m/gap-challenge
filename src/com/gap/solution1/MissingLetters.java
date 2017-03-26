package com.gap.solution1;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Julian G on 3/26/2017.
 */
public class MissingLetters {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String getMissingLetters(String sentence){
        List<Character> answerList = stringToCharList(ALPHABET);

        if(sentence != null && !sentence.isEmpty()){
            List<Character> testList = stringToCharList(sentence);

            for(Character element : testList){
                element = Character.toLowerCase(element);

                if(isAscii(element)){
                    answerList.remove(element);
                }
            }
        }

        return answerList.stream().map(Object::toString)
                .collect(Collectors.joining(""));
    }

    private static boolean isAscii(Character character){
        if((97<= (int)character && (int)character <= 122) || (65<= (int)character && (int)character <= 90)){
            return true;
        }
        return false;
    }

    private static List<Character> stringToCharList(String str){
       return str.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
    }

    public static void main (String args[]){
        String testString = "A quick brown fox jumps over the lazy dog";
        System.out.println("The phrase: "+testString+ " returns: \n "+ getMissingLetters(testString));

        testString = "A slow yellow fox crawls under the proactive dog";
        System.out.println("The phrase: "+testString+ " returns: \n "+ getMissingLetters(testString));

        testString = "Lions, and tigers, and bears, oh my!";
        System.out.println("The phrase: "+testString+ " returns: \n "+ getMissingLetters(testString));

        testString = "";
        System.out.println("The phrase: "+testString+ " returns: \n "+ getMissingLetters(testString));

    }
}
