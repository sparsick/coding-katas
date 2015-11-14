package com.company;

public class Diamond {

    public static String CRLF = System.lineSeparator();


    public static void main(String[] args) {
	// write your code here
    }

    private String nSpaces(int n) {
        String result ="";
        for (int j = 0; j < n; j++) {
            result+=" ";
        }
        return result;
    }


    public String createDiamondFor(char letter) {
        int offset = letter - 'A';
        String result = nSpaces(offset) + "A" + nSpaces(offset) + CRLF;

        for(int i = 1; i< offset; i++){
            String line = buildLine(offset, i);
            result += line;
        }

        for(int i = offset; i > 0; i--){
            String line = buildLine(offset, i);
            result += line;
        }

        if (letter != 'A') {
            result += nSpaces(offset) + "A" + nSpaces(offset) + CRLF;
        }
        return result.substring(0,result.length()-1);
    }

    private String buildLine(int offset, int i) {
        String line = "";
        line += nSpaces(offset -i);
        line += (char)('A' + i);
        line += nSpaces(2 * i -1);
        line += (char)('A' + i);
        line += nSpaces(offset -i);
        line += CRLF;
        return line;
    }
}
