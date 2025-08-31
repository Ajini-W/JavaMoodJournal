package util;

import java.util.Set;

public class SentimentAnalyzer {

    private static final Set<String> positiveWords = Set.of("happy", "joy", "excited", "love", "great", "fun", "good");
    private static final Set<String> negativeWords = Set.of("sad", "angry", "depressed", "bad", "tired", "hate", "anxious");

    public static String analyze(String text) {
        int score = 0;
        for (String word : text.toLowerCase().split("\\s+")) {
            if (positiveWords.contains(word)) score++;
            if (negativeWords.contains(word)) score--;
        }

        if (score > 0) return "Positive";
        else if (score < 0) return "Negative";
        else return "Neutral";
    }
}
