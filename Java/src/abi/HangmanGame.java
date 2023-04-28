package abi;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private static final String FILE_PATH = "C:\\Users\\khari\\eclipse-workspace\\Java\\src\\movies_and_books.txt"; // File path for the text file
    private static final int TIME_LIMIT = 90; // Time limit in seconds

    private ArrayList<String> movies;
    private ArrayList<String> books;
    private String word;
    private StringBuilder maskedWord;
    private int guesses;
    private int correctGuesses;
    private ArrayList<Character> guessedLetters;
    private long startTime;

    public HangmanGame() {
        movies = new ArrayList<>();
        books = new ArrayList<>();
        word = "";
        maskedWord = new StringBuilder();
        guesses = 0;
        correctGuesses = 0;
        guessedLetters = new ArrayList<>();
        startTime = 0;
    }

    // Read words from the text file and populate the movies and books lists
    private void readWordsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(",");
                if (words.length == 2) {
                    movies.add(words[0].trim());
                    books.add(words[1].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to read words from file: " + e.getMessage());
        }
    }

    // Select a word based on the category chosen by the user
    private void selectWord(String category) {
        ArrayList<String> wordList;
        if (category.equalsIgnoreCase("movies")) {
            wordList = movies;
        } else if (category.equalsIgnoreCase("books")) {
            wordList = books;
        } else {
            System.out.println("Invalid category. Exiting...");
            return;
        }

        Random random = new Random();
        int index = random.nextInt(wordList.size());
        word = wordList.get(index).toUpperCase();
        maskedWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            maskedWord.append("_");
        }
    }

    // Main game loop
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;
        startTime = System.currentTimeMillis();
        System.out.println("Welcome to Hangman Game!");
        System.out.println("Choose a category (movies/books): ");
        String category = scanner.nextLine();
        readWordsFromFile();
        selectWord(category);

        while (!gameOver) {
            System.out.println("\n" + maskedWord);
            System.out.println("Guesses: " + guesses);
            System.out.println("Guessed letters: " + guessedLetters.toString());
            System.out.print("Enter a letter or the full word: ");
            System.out.println(maskedWord.toString());
           
if(!maskedWord.toString().contains("_")) {
	System.out.println("Congratulations! You guessed the word: " + word);
	
	break;
}
else { String input = scanner.nextLine().toUpperCase();
            if (input.length() == 1) {
            	
                char guess = input.charAt(0);
                if (guessedLetters.contains(guess)) {
                    System.out.println("You have already guessed that letter. Try again.");
                    continue;
                }
                guessedLetters.add(guess);
                boolean found = false;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        maskedWord.setCharAt(i, guess);
                        found = true;
                        correctGuesses++;
                    }
                }
                if (!found) {
                    guesses++;
                }
            } else         // Check if game over conditions are met
                if (maskedWord.toString().equals(word)|| guesses >= word.length() || correctGuesses == word.length()) {
                    gameOver = true;
                    long endTime = System.currentTimeMillis();
                    double timeElapsed = (endTime - startTime) / 1000.0; // Calculate time elapsed in seconds
                    System.out.println("\n" + maskedWord);
                    System.out.println("Guesses: " + guesses);
                    System.out.println("Guessed letters: " + guessedLetters.toString());
                    System.out.println("Time elapsed: " + timeElapsed + " seconds");

                    // Check if user won or lost
                    if (maskedWord.toString().equals(word)) {
                        System.out.println("Congratulations! You guessed the word: " + word);
                    } else {
                        System.out.println("Game over! You ran out of guesses. The word was: " + word);
                    }
                }
                
            }
        }
            scanner.close();
        }

        public static void main(String[] args) {
            HangmanGame hangmanGame = new HangmanGame();
            hangmanGame.playGame();
        }}
