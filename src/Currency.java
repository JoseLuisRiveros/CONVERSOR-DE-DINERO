public class Currency {
    private String code;
    private String name;

    public Currency(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Getters
    public String getCode() { return code; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return code + " - " + name;
    }
}