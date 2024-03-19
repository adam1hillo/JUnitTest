import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PersoonTest {

    private Persoon persoon;

    @BeforeEach
    void beforeEach() {
        persoon = new Persoon();
        persoon.add("Adam");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Adam", "adam", "", "  ", "\n", "\t"})
    void verkeerdeVoornamen(String voornaam) {
        assertThatIllegalArgumentException().isThrownBy(() -> persoon.add(voornaam));
    }

    @Test
    void voornaamKanGeenNullZijn() {
        assertThatNullPointerException().isThrownBy(() -> persoon.add(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"David", "John", "12556", " ."})
    void juisteVoornamen(String voornaam) {
        persoon.add(voornaam);
    }

    @Test
    void toStringGeeftAlleVoornamenGescheidenDoorEenSpatieVolgordeZoalsToegevoegd() {
        persoon.add("Charlie");
        persoon.add("Jean-Pierre");
        assertThat(persoon).hasToString("Adam Charlie Jean-Pierre");
    }
}