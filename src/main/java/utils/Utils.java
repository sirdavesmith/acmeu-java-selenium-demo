package utils;

import model.JdbcConnection;
import org.testng.annotations.Test;

public class Utils {
    private final String sql = "SELECT * FROM acmeuacmeu.vw_student WHERE ROWNUM = 1";

    @Test
    public void testDBConnection () throws Exception {
        JdbcConnection con = new JdbcConnection();
        con.connectToDb();

        con.runQuery(sql);
    }
}
