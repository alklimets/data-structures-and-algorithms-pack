package com.aklimets.challenges.leetcode.excel_sheet_column_title;

public class ExcelSheetColumnTitle {

    /*
        Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
        For example:

        A -> 1
        B -> 2
        C -> 3
        ...
        Z -> 26
        AA -> 27
        AB -> 28
        ...

        Example 1:
        Input: columnNumber = 1
        Output: "A"

        Example 2:
        Input: columnNumber = 28
        Output: "AB"

        Example 3:
        Input: columnNumber = 701
        Output: "ZY"

        Constraints:

        1 <= columnNumber <= 2^31 - 1
    */

    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            char ch = (char) ('A' + columnNumber % 26);
            res.insert(0, ch);
            columnNumber /= 26;
        }
        return res.toString();
    }
}
