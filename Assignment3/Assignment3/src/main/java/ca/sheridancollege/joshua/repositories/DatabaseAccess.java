package ca.sheridancollege.joshua.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.joshua.beans.User;
import ca.sheridancollege.joshua.beans.Player;

@Repository
public class DatabaseAccess {
	
	//Lets us provide values to our queries
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public User findUserAccount(String userName) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "SELECT * FROM sec_user where userName=:userName";
        parameters.addValue("userName", userName);
        ArrayList<User> users = (ArrayList<User>)jdbc.query(query, parameters,
                new BeanPropertyRowMapper<User>(User.class));
        if (users.size()>0)
            return users.get(0);
        else
            return null;
    }
    public List<String> getRolesById(long userId) {
        ArrayList<String> roles = new ArrayList<String>();
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "select user_role.userId, sec_role.roleName "
                + "FROM user_role, sec_role "
                + "WHERE user_role.roleId=sec_role.roleId "
                + "and userId=:userId";
        parameters.addValue("userId", userId);
        List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
        for (Map<String, Object> row : rows) {
            roles.add((String)row.get("roleName"));
        }
        return roles;
    }
    
    public void insertEntry()
    {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "INSERT INTO player(name, xPos, yPos, numTurns, avgMoves, standardDev) VALUES  ('joashua', 2, 2, 10, 16, 7.09)";
         int rowsAffected = jdbc.update(query, namedParameters);
        if(rowsAffected > 0)
        {
            System.out.println("Inserted entry into database");
        }

    }
    public void insertInformation(Player player)
    {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        String query = "INSERT INTO player(name, xPos, yPos, numTurns, avgMoves, standardDev) VALUES (:name, :xPos, :yPos, :numTurns, :avgMoves, :standardDev)";
        namedParameters.addValue("name", player.getName());
        namedParameters.addValue("xPos", player.getxPos());
        namedParameters.addValue("yPos", player.getyPos());
        namedParameters.addValue("numTurns", player.getNumTurns());
        namedParameters.addValue("avgMoves", player.getAvgMoves());
        namedParameters.addValue("standardDev", player.getStanDev());

       int rowsAffected = jdbc.update(query, namedParameters);
        if(rowsAffected > 0)
        {
            System.out.println("Inserted entry into database");
        }
    }

	
}
