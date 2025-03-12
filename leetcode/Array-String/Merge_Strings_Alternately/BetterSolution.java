public class BetterSolution {
  public static String mergeAlternately(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();

    StringBuilder rs = new StringBuilder();

    for (int i = 0; i < Math.min(n, m); ++i) {
      rs.append(word1.charAt(i)).append(word2.charAt(i));
    }
    if (n > m) {
      rs.append(word1.substring(m));
    }

    if (m > n) {
      rs.append(word2.substring(n));
    }

    return rs.toString();
  }

  public static void main(String[] args) {
    String str1 = "abcd";
    String str2 = "def";

    System.out.println(mergeAlternately(str1, str2));
  }
}
