import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BasicTest {

    @Test
    void test() {
        assertThat(renderName("David", "Voelkel"))
                .isEqualTo("Firstname: David\nLastname: Voelkel");

        assertThat(renderName(null, null))
                .isEqualTo("Firstname: -\nLastname: -");
    }

    private String renderName(String firstName, String lastName) {
        if (firstName == null && lastName == null) {
            return "Firstname: -\nLastname: -";
        }

        return String.format("Firstname: %s\nLastname: %s", firstName, lastName);
    }
}
