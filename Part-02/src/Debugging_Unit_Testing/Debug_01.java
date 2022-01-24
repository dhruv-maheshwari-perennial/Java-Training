package Debugging_Unit_Testing;

public class Debug_01 {
    public static void main(String[] args) {
        StringUtilities utils = new StringUtilities();
        StringBuilder sb = new StringBuilder();

        while (sb.length() < 10) {
            utils.addChar(sb, 'a');
        }
        System.out.println(sb);

        String str = "abcdefgh";
        String result = utils.upperAndPrefix(utils.addSuffix(str));
    }
}

class StringUtilities {
    private StringBuilder sBuilder = new StringBuilder();
    private int charAdded = 0;

    public void addChar(StringBuilder sBuilder, char c) {
        sBuilder.append(c);
        charAdded++;
    }

    public String upperAndPrefix(String str) {
        String upper = str.toUpperCase();
        return "Prefix: " + upper;
    }

    public String addSuffix(String str) {
        return str + "___Suffix";
    }
}