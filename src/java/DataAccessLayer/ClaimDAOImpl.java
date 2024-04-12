package DataAccessLayer;

import Model.Claim;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClaimDAOImpl implements ClaimDAO {
    private Connection connection;

    public ClaimDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addClaim(Claim claim) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO claims (claim_id, date, user_id) VALUES (?, ?, ?)")) {
            statement.setInt(1, claim.getClaim_id());
            statement.setObject(2, claim.getDate());
            statement.setInt(3, claim.getUser_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Claim getClaimById(int claimId) {
        Claim claim = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM claims WHERE claim_id = ?")) {
            statement.setInt(1, claimId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                claim = new Claim();
                claim.setClaim_id(resultSet.getInt("claim_id"));
                claim.setDate(resultSet.getObject("date", LocalDate.class));
                claim.setUser_id(resultSet.getInt("user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return claim;
    }

    @Override
    public List<Claim> getAllClaims() {
        List<Claim> claims = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM claims")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Claim claim = new Claim();
                claim.setClaim_id(resultSet.getInt("claim_id"));
                claim.setDate(resultSet.getObject("date", LocalDate.class));
                claim.setUser_id(resultSet.getInt("user_id"));
                claims.add(claim);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return claims;
    }

    @Override
    public void updateClaim(int claimId) {
        //To implement
    }

    @Override
    public void deleteClaim(int claimId) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM claims WHERE claim_id = ?")) {
            statement.setInt(1, claimId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
