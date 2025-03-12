import java.util.ArrayList;
import java.util.List;

/**
 * There are n kids with candies
 * You are given an integer array candies,
 * where each candies[i] represents the number of candies the ith kid has,
 * and an integer extraCandies,
 * denoting the number of extra candies that you have
 * Return a boolean array result of length n,
 * where result[i] is true if,
 * after giving the i kid all the extraCandies,
 * they will have the greatest number of candies among all the kids,
 * or false otherwise
 * Note that multiple kids can have the greatest number of candies
 */

public class Solution {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    List<Boolean> result = new ArrayList<>();

    // Find the greatest number of candies current
    int maxCandies = 0;
    for (int candy : candies) {
      maxCandies = Math.max(maxCandies, candy);
    }

    // Loop through n kid and check the condition
    for (int candy : candies) {
      if (maxCandies <= candy + extraCandies) {
        result.add(true);
      } else {
        result.add(false);
      }
    }

    return result;
  }
}
