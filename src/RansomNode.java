public class RansomNode {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] magazineCount = new char[26];
        for (char letter : magazine.toCharArray()) {
            magazineCount[letter - 'a']++;
        }

        char[] noteCount = new char[26];
        for (char letter : ransomNote.toCharArray()) {
            noteCount[letter - 'a']++;
            if (noteCount[letter - 'a'] > magazineCount[letter - 'a']) {
                return false;
            }
        }

        return true;
    }
}
