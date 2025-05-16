import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConversionHistory {
    private List<String> history = new ArrayList<>();

    public void addConversion(String from, String to, double amount, double result, LocalDateTime date) {
        String entry = String.format("%s - De %s a %s: %.2f → %.2f",
                date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                from, to, amount, result);
        history.add(entry);
    }

    public List<String> getHistory() {
        return new ArrayList<>(history);
    }
}
