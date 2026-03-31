class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        char[] word = new char[n + m - 1];

        for (int i = 0; i < word.length; i++) word[i] = '?';

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] == '?' || word[i + j] == str2.charAt(j)) {
                        word[i + j] = str2.charAt(j);
                    } else {
                        return "";
                    }
                }
            }
        }

        for (int i = 0; i < word.length; i++) {
            if (word[i] == '?') word[i] = 'a';
        }

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    boolean fixed = false;

                    for (int j = m - 1; j >= 0 && !fixed; j--) {
                        int pos = i + j;
                        char original = word[pos];

                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == original) continue;

                            word[pos] = c;

                            if (validT(word, str1, str2)) {
                                fixed = true;
                                break;
                            }
                        }

                        if (!fixed) word[pos] = original;
                    }

                    if (!fixed) return "";
                }
            }
        }

        return new String(word);
    }

    private boolean validT(char[] word, String str1, String str2) {
        int n = str1.length(), m = str2.length();

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) return false;
                }
            }
        }
        return true;
    }
}