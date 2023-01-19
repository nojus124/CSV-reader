package com.CSVconverter.demo.dao;

import com.CSVconverter.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;


@Repository("fakeDao")
public class PersonDataAccessService implements PersonDao{
    @Override
    public int insertPerson(UUID id, Person person) {
        String url = "jdbc:h2:~/test";
        String user = "sa";
        String password = "";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO PERSON (ID, NAME, EMAIL, PHONE) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setObject(1, id);
            pstmt.setString(2, person.getName());
            pstmt.setString(3, person.getEmail());
            pstmt.setString(4, person.getPhoneNumber());

            pstmt.executeUpdate();

            System.out.println("Data inserted.");
            /*rs = stmt.executeQuery("SELECT * FROM PERSON"); // if you want to watch in console every entry.
            while (rs.next()) {
                System.out.println(rs.getString("ID") + " " + rs.getString("NAME")+ " " + rs.getString("EMAIL")+ " " + rs.getString("PHONE"));
            }*/
            conn.close();
        } catch (SQLException e) {
            System.out.println("error");
            e.printStackTrace();
        }
        //DB.add(new Person(id, person.getName(), person.getEmail(), person.getPhoneNumber()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        List<Person> DB = new ArrayList <>();
        String url = "jdbc:h2:~/test";
        String user = "sa";
        String password = "";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PERSON");
            while (rs.next()) {
                UUID idas = UUID.fromString(rs.getString("ID"));
                DB.add(new Person(idas, rs.getString("NAME"), rs.getString("EMAIL"), rs.getString("PHONE")));
            }
            System.out.println("Someone requested a get request.");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DB;
    }
}
