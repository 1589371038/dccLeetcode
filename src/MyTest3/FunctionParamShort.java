package MyTest3;



public class FunctionParamShort {
    private String field;
    private int required;

    public FunctionParamShort() {
    }

    public FunctionParamShort(String field, int required) {
        this.field = field;
        this.required = required;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getRequired() {
        return required;
    }

    public void setRequired(int required) {
        this.required = required;
    }
}
