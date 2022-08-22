package taras;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Inventory {
    int sold;
    String string;
    int unavailable;
    int pending;
    int available;
    int status;
}
