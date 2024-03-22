package DataAccessLayer;

import Model.Claim;
import java.util.List;

/**
 *
 * @author aless
 */
public interface ClaimDAO {

    void addClaim(Claim claim);

    Claim getClaimById(int claimId);

    List<Claim> getAllClaims();

    void updateClaim(int claimId);

    void deleteClaim(int claimId);
}
