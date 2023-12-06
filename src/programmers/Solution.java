package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution S = new Solution();
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> wordList = new ArrayList<>();
        StringTokenizer s = new StringTokenizer(br.readLine());
        while (s.hasMoreTokens()) {
            wordList.add(s.nextToken());
        }
        String[] words = new String[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            words[i] = wordList.get(i);
        }
        int[] answer = S.solution(n, words);
        System.out.println(answer[0] + "," +answer[1]);
    }

    public int[] solution(int n, String[] words) {
        int[] answer;
        int wordsIndex = 0;
        int peopleCheck = 0;
        int countCheck = 1;
        ArrayList<String> wordList = new ArrayList<>();
        char lastWord = ' ';

        while (wordsIndex < words.length) {
            for (int i = 1; i <= n; i++) {
                String word = words[wordsIndex];
                if (wordsIndex == 0) {
                    wordList.add(word);
                    lastWord = word.charAt(word.length() - 1);
                    wordsIndex++;
                    continue;
                }

                if (lastWord != word.charAt(0) || wordList.contains(word)) {
                    peopleCheck = i;
                    break;
                }
                wordList.add(word);
                lastWord = word.charAt(word.length() - 1);
                wordsIndex++;
            }
            if (peopleCheck > 0) {
                break;
            }
            countCheck++;
        }

        if (peopleCheck == 0) {
            countCheck = 0;
        }

        answer = new int[]{peopleCheck, countCheck};

        return answer;
    }
}
