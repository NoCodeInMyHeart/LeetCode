import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ListNode {

    private int x;

    private ListNode next;

    public ListNode(int x, ListNode next) {
        this.x = x;
        this.next = next;
    }
}
