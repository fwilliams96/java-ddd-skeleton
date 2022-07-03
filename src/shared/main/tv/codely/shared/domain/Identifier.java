package tv.codely.shared.domain;

import java.util.Objects;
import java.util.UUID;

public abstract class Identifier {

    private final UUID value;

    public Identifier(String value) {
        this.value = UUID.fromString(value);;
    }

    public String value() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
