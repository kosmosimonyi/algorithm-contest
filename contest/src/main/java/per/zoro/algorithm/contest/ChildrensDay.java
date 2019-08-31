package per.zoro.algorithm.contest;

public abstract class ChildrensDay {

    private ChildrensDay() {

    }


    public static void main(String[] args) {
        char nextChar = 'a';
        for (int i = 3; i < 11; i++) {
            nextChar = printN(i, nextChar);
        }
    }


    public static char printN(final int rowCount, final char firstChar) {
        char nextChar = firstChar;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < rowCount; j++) {
                // 1. print next char
                if (isSpace(rowCount, i, j)) {
                    // print space
                    System.out.print(" ");
                } else {
                    // print next char
                    nextChar = toNextChar(firstChar, rowCount, i, j);
                    System.out.print(nextChar);
                }
            }
            // new line
            System.out.println();
        }
        return toNextChar(nextChar);
    }


    private static boolean isSpace(final int rowCount, final int row, final int column) {
        return column != 0
                && column != rowCount - 1
                && (row + column) != (rowCount - 1)
                ;
    }

    private static char toNextChar(final int firstChar, final int rowCount, final int row, final int column) {
        int offset;

        if (column == 0) {
            offset = row;
        } else if (column > 0 && column < rowCount - 1) {
            offset = (rowCount - 1) + column;
        } else {
            offset = (rowCount - 1) + column + row;
        }
        int charIndex = firstChar + offset;
        if (charIndex > 'z') {
            charIndex = ('a' - 1) + (charIndex - 'z');
        }
        return (char) charIndex;
    }

    private static char toNextChar(final char currentChar) {
        int charIndex = currentChar;
        charIndex++;
        if (charIndex > 'z') {
            charIndex = 'a';
        }
        return (char) charIndex;

    }
}
