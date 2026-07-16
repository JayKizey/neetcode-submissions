class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char num = board[i][j];
                if (num == '.') continue;
                int box = (i / 3) * 3 + (j / 3);
                if (rows[i].contains(num) || cols[j].contains(num) || boxes[box].contains(num)) return false;
                else {
                    rows[i].add(num);
                    cols[j].add(num);
                    boxes[box].add(num);
                }
            }
        }

        return true;
    }
}
