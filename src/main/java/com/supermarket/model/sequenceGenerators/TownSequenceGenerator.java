package com.supermarket.model.sequenceGenerators;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TownSequenceGenerator implements IdentifierGenerator {
    // IdentifierGenerator interface is responsible for generating unique identifiers for objects
    private static final String PREFIX = "Town_";
    private static final String SEQUENCE_TABLE_NAME = "town_sequence_table";
    private static final String SEQUENCE_COLUMN_NAME = "town_sequence";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        // session - Represents the current Hibernate session
        // object - Represents the object for which an identifier is being generated
        try {
            // Retrieves a JDBC connection from the Hibernate session, then create a statement object using that connection. This is done to interact with the underlying database.

            Connection connection = DatabaseConnectionManager.getConnection();
            Statement statement = connection.createStatement();

            // Create the sequence table if it doesn't exist.
            // Ensure that a sequence table exists in the database. This table is used to manage the sequence of identifiers.
            createSequenceTableIfNotExists(statement);

            // Retrieve the next value from the sequence table
            // This line executes a SQL query to fetch the current value of the sequence from the database. It checks the information_schema.TABLES table to find the AUTO_INCREMENT value of the SEQUENCE_TABLE_NAME.
            // ResultSet rs = statement.executeQuery("SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = '" + SEQUENCE_TABLE_NAME + "'");
            // If the query returns a result, it means the sequence table exists.
            // In that case, it retrieves the next value of the sequence.

            // Retrieve the next value from the sequence table
            long nextValue = getNextSequenceValue(statement);
            // Ensure the generated key doesn't conflict with existing data
            long maxId = getMaxIdFromTownsTable(connection);
            if (maxId >= nextValue) {
                nextValue = maxId + 1;
                // Update the sequence table to the next value
                statement.executeUpdate("ALTER TABLE " + SEQUENCE_TABLE_NAME + " AUTO_INCREMENT = " + (nextValue + 1));
            }

            statement.close(); // Close the statement after use

            return PREFIX + nextValue;
        } catch (SQLException e) {
            throw new HibernateException("Unable to generate sequence", e);
        }
    }

    private long getNextSequenceValue(Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = '" + SEQUENCE_TABLE_NAME + "'");
        if (rs.next()) {
            long nextValue = rs.getLong(1);
            rs.close(); // Close the ResultSet after use
            return nextValue;
        } else {
            throw new SQLException("Failed to retrieve next sequence value");
        }
    }

    private void createSequenceTableIfNotExists(Statement statement) throws SQLException {
        String createTableQuery = String.format(
                "CREATE TABLE IF NOT EXISTS %s (%s BIGINT AUTO_INCREMENT PRIMARY KEY)",
                SEQUENCE_TABLE_NAME, SEQUENCE_COLUMN_NAME);
        statement.executeUpdate(createTableQuery); // This line executes the SQL query to create the sequence table.
    }

    private long getMaxIdFromTownsTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery("SELECT MAX(CAST(SUBSTRING(town_id, LENGTH('" + PREFIX + "') + 1) AS UNSIGNED)) FROM towns")) {
                // Executes SQL query to fetch the maximum identifier value from the towns table.
                // It uses the MAX() function along with SUBSTRING_INDEX() to extract the numeric part of the identifier.
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
        }
        return 0; // If the query doesn't return any result, it means the towns table is empty, and it returns 0 as the maximum identifier value.
    }
}
