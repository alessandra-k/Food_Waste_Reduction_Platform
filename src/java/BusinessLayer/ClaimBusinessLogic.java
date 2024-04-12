package BusinessLayer;

import DataAccessLayer.ClaimDAO;
import Model.Claim;
import java.util.List;

public class ClaimBusinessLogic {
    private ClaimDAO claimDAO;

    public ClaimBusinessLogic(ClaimDAO claimDAO) {
        this.claimDAO = claimDAO;
    }

    public void addClaim(Claim claim) {
        claimDAO.addClaim(claim);
    }

    public Claim getClaimById(int claimId) {
        return claimDAO.getClaimById(claimId);
    }

    public List<Claim> getAllClaims() {
        return claimDAO.getAllClaims();
    }

    public void updateClaim(int claimId) {
        claimDAO.updateClaim(claimId);
    }

    public void deleteClaim(int claimId) {
        claimDAO.deleteClaim(claimId);
    }
}
