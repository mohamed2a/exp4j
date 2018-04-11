package net.objecthunter.exp4j.tokenizer;

public class InvalidVariableException extends IllegalArgumentException {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    private final String message;
    private final String expression;
    private final String token;
    private final int position;

    public InvalidVariableException(String expression, int position, int length) {
        this.expression = expression;
        this.token = token(expression, position, length);
        this.position = position;
        this.message = "Invalid function or variable name '" + token + "' at pos " + position + " in expression '" + expression + "'";
    }

    private static String token(String expression, int position, int length) {

        int len = expression.length();
        int end = position + length;

        if (len < end) {
            end = len;
        }

        return expression.substring(position, end);
    }

    @Override
    public String getMessage() {
        return message;
    }

    /**
     * @return Expression which contains unknown function or variable
     */
    public String getExpression() {
        return expression;
    }

    /**
     * @return The name of unknown function or variable
     */
    public String getToken() {
        return token;
    }

    /**
     * @return The position of unknown function or variable
     */
    public int getPosition() {
        return position;
    }
}
