import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class Persoon {

    private static final Pattern PATTERN = Pattern.compile(".?\\S+.?");
    private final List<String> voornamen = new ArrayList<>();
    void add(String voornaam) {
        if (!PATTERN.matcher(voornaam).matches()) {
            throw new IllegalArgumentException("Voornaam moet minstens één niet-blanco teken bevatten.");
        }
        if (voornamen.stream().anyMatch(v -> v.equalsIgnoreCase(voornaam))) {
            throw new IllegalArgumentException("Voornaam bestaat al.");
        }
        voornamen.add(voornaam);
    }

    @Override
    public String toString() {
        return String.join(" ", voornamen);
    }
}
