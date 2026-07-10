class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        //  strs = ["flower","flow","flight"]
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length());
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}

/*
    count = 0;
    for i in 0..strs[0].length() 
        if strs[0].charAt(i) == strs[1].charAt[i]
            count++;
        else
            break;

    so sánh các phần tử còn lại từ 0 cho đến vị trí count
    ...


    prefix = strs[0]
    for i from 1 to strs.length - 1:
        while !strs[i].startsWith(prefix):
        // cắt bớt 1 ký tự cuối của prefix
        ...
    // nếu prefix rỗng thì có thể dừng sớm luôn


*/