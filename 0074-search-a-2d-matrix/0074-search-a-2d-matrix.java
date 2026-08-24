class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int rows = matrix.length;
        int col = matrix[0].length;
        int end = (rows * col) - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int row = mid / col;
            int cols = mid % col;
            if (matrix[row][cols] == target)
                return true;
            else if (matrix[row][cols] < target)
                start = mid + 1;
            else
                end = mid - 1;

        }
        return false;

    }
}