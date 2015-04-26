package amazon_product_metadata_parser.output;

import org.junit.Test;

import amazon_product_metadata_parser.output.SQLServer2012.SQLServer2012Output;

public class SQLServer2012OutputTest {

  @Test
  public void testConnection() throws Exception {
    SQLServer2012Output output = new SQLServer2012Output("AdventureWorks2012", null);
    output.open();
    output.close();
  }
}
