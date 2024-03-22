package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aless
 */
public class Claim {

    private int claim_id;
    private LocalDate date;
    private int user_id;
    private List<Item> claimedItems;

    public Claim() {
    }

    public int getClaim_id() {
        return claim_id;
    }

    public void setClaim_id(int claim_id) {
        this.claim_id = claim_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<Item> getClaimedItems() {
        return claimedItems;
    }

    public void addClaimedItem(Item item) {
         if (claimedItems == null) {
            claimedItems = new ArrayList<>();
        }
        claimedItems.add(item);
    }

}
