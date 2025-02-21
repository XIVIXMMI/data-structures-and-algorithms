class BetterSolution {
  public static String gcdOfStrings(String str1, String str2) {
    if (!(str1 + str2).equals(str2 + str1))
      return "";
    int l = gcd(str1.length(), str2.length());
    return str1.substring(0, l);
  }

  private static int gcd(int i, int j) {
    while (j != 0) {
      int temp = i % j;
      i = j;
      j = temp;
    }
    return i;
  }

  public static void main(String[] args) {
    String str1 = "ABABAB";
    String str2 = "AB";

    System.out.println(gcdOfStrings(str1, str2));
  }
}
