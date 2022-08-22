package taras;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Order {
    private Long id;
    private Long petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;
}