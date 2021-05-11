package MyThreading.dal;

import MyThreading.be.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase {

    private DatabaseConnector databaseConnector;

    public DataBase() {
        databaseConnector = new DatabaseConnector();
    }

    public Person getPerson(int rowId){
        try (Connection connection = databaseConnector.getConneciton()){
            String sql = "SELECT first_name, last_name FROM Threading WHERE id=(" + rowId + ")";

            Statement statement = connection.createStatement();
            if (statement.execute(sql)){
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()){
                    String fname = resultSet.getString(1);
                    String lname = resultSet.getString(2);

                    Person person = new Person(fname, lname);

                    return person;
            }

            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
