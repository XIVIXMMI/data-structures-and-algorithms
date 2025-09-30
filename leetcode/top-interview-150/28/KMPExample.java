public class KMPExample {
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        int[] lps = buildLPS(needle);
        int i = 0; // index cho haystack
        int j = 0; // index cho needle

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return i - j; // tìm thấy, trả về index bắt đầu
                }
            } else {
                if (j > 0) {
                    j = lps[j - 1]; // nhảy theo LPS
                } else {
                    i++;
                }
            }
        }
        return -1; // không tìm thấy
    }

    private static int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0; // độ dài prefix-suffix hiện tại
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1]; // quay lại prefix trước
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip")); // expect 4
        System.out.println(strStr("hello", "ll"));          // expect 2
        System.out.println(strStr("aaaaa", "bba"));         // expect -1
        System.out.println(strStr("a", "a"));               // expect 0
    }
}