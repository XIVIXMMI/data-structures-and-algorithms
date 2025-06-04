import java.util.*;

class Solution {

  // this function return value of roman symbol
  static int value(char r) {
    if (r == 'I')
      return 1;
    if (r == 'V')
      return 5;
    if (r == 'X')
      return 10;
    if (r == 'L')
      return 50;
    if (r == 'C')
      return 100;
    if (r == 'D')
      return 500;
    if (r == 'M')
      return 1000;

    return -1;
  }

  static int romanToInt(String s) {
    int sum = 0;

    for (int i = 0; i < s.length(); i++) {

      int s1 = value(s.charAt(i));

      if (i + 1 < s.length()) {
        int s2 = value(s.charAt(i + 1));

        // if current value is greater than or equal, then add it
        if (s1 >= s2) {
          sum += s1;
        } else {
          // else subtract it
          sum += (s2 - s1);
          i++;
        }

      } else {
        // add the last value
        sum += s1;
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    String s = "XIV";
    int res = romanToInt(s);
    System.out.println(res);
  }

}
