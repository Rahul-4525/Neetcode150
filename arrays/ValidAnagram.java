package arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] s_ar = new int[26];
        int[] t_ar = new int[26];
        for (int i = 0; i < s.length(); i++) {
            s_ar[s.charAt(i) - 'a']++;
            t_ar[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s_ar.length; i++) {
            if (s_ar[i] != t_ar[i])
                return false;
        }
        return true;
    }
}
