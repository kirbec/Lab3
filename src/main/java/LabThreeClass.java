import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author adrewno2
 *
 */
public class LabThreeClass {

    /**
     *
     * @param args main method
     *
     */
    public static void main(final String[] args) {

        System.out.println("Text : http://erdani.com/tdpl/hamlet.txt");
        System.out.println("Number of words in text: "
                + numberOfWordsInText(urlToString("http://erdani.com/tdpl/hamlet.txt")));
        System.out.println("Number of recurrances of Prince : "
                + numberOfRecurrences("prince", urlToString("http://erdani.com/tdpl/hamlet.txt")));
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /**
     *
     * @param word word that repeats within the certain string
     * @param text text sends in the text to get the word from
     * @return number of recurrences of specific word
     */
    public static int numberOfRecurrences(final String word, final String text) {

        String[] splitBySpaces = text.split(" ");
        int count = 0;
        for (int i = 0; i < splitBySpaces.length; i++) {
            splitBySpaces[i] = splitBySpaces[i].replaceAll("//W", "");
            if (word.toLowerCase().equals(splitBySpaces[i].toLowerCase())) {
                count += 1;
            }
        }
        return count;
    }

    /**
     *
     * @param text text to count words from
     * @return length of split method
     */
    public static int numberOfWordsInText(final String text) {

        String[] textArray = text.split(" ");
        return textArray.length;

    }


}
