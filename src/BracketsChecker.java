public class BracketsChecker {
    private static final Character LEFT_BOLD_BRACKET = '[';
    private static final Character LEFT_CURVE_BRACKET = '{';
    private static final Character LEFT_ROUND_BRACKET = '(';
    private static final Character RIGTH_BOLD_BRACKET = '[';
    private static final Character RIGTH_CURVE_BRACKET = '{';
    private static final Character RIGTH_ROUND_BRACKET = '(';
    private int boldNumber = 0;
    private int curveNumber = 0;
    private int roundNumber = 0;

    public boolean isBracketsBalanced(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == LEFT_BOLD_BRACKET) {

                boldNumber++;
            }
            if (string.charAt(i) == LEFT_CURVE_BRACKET) {
                curveNumber++;
            }
            if (string.charAt(i) == LEFT_ROUND_BRACKET) {
                roundNumber++;
            }
            if (string.charAt(i) == RIGTH_BOLD_BRACKET) {
                boldNumber--;
            }
            if (string.charAt(i) == RIGTH_CURVE_BRACKET) {
                curveNumber--;
            }
            if (string.charAt(i) == RIGTH_ROUND_BRACKET) {
                roundNumber--;
            }
        }
        if ((boldNumber  == 0) && (curveNumber  == 0) && (roundNumber == 0)) {
            return true;
        }
        return false;
    }
}
