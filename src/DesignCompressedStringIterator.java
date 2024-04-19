public class DesignCompressedStringIterator {
    class StringIterator {
        String compressedString;
        int pos;
        int currCount;
        char currChar;

        public StringIterator(String compressedString) {
            this.compressedString = compressedString;
            this.pos = 0;
            this.currCount = 0;
            this.currChar = ' ';
        }

        public char next() {
            if (!hasNext()) {
                return ' ';
            }

            if (currCount == 0) {
                currChar = compressedString.charAt(pos);
                pos++;
                StringBuilder nextCount = new StringBuilder();
                while (pos < compressedString.length() &&
                        compressedString.charAt(pos) >= '0' && compressedString.charAt(pos) <= '9') {
                    nextCount.append(compressedString.charAt(pos));
                    pos++;
                }
                currCount = Integer.parseInt(nextCount.toString());
            }

            currCount--;
            return currChar;
        }

        public boolean hasNext() {
            return pos < compressedString.length() || currCount > 0;
        }
    }
}
