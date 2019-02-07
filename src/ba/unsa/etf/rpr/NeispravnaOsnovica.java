package ba.unsa.etf.rpr;

public class NeispravnaOsnovica extends Error {
    private String message;
    public NeispravnaOsnovica(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
