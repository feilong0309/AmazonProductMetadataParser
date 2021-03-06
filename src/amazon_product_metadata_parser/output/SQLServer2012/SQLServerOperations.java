package amazon_product_metadata_parser.output.SQLServer2012;

import java.sql.Connection;
import java.sql.SQLException;

import amazon_product_metadata_parser.dto.ProductDTO;

abstract public class SQLServerOperations {

  private Connection conn;
  private int        numStatementsExecuted;

  public SQLServerOperations() {
    this.numStatementsExecuted = 0;
  }

  public Connection getConn() {
    return conn;
  }

  public void setConn(Connection conn) throws SQLException {
    this.conn = conn;
    if (hasInvalidConn()) {
      throw new SQLException("Attempted to execute SQL Queries with invalid connection");
    }
  }

  public boolean hasInvalidConn() {
    try {
      return (null == conn) || !conn.isValid(5);
    } catch (SQLException e) {
      String reason = "Called isValid() on connection using an integer less than 0";
      throw new RuntimeException(reason, e);
    }
  }

  public abstract void executeBeforeStatements();

  public abstract void executeProductStatements(ProductDTO productDTO);

  public abstract void executeAfterStatements();

  public void incrementNumStatementsExecuted() {
    incrementNumStatementsExecuted(1);
  }

  public void incrementNumStatementsExecuted(int increment) {
    numStatementsExecuted += increment;
  }

  public int getNumStatementsExecuted() {
    return numStatementsExecuted;
  }
}
