import com.dyx.jdbc.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtilTest {

    @Test
    public void test() throws SQLException {

        Connection conn = JDBCUtils.getConnection();
        Statement stmt = conn.createStatement();
        String sql1 = "select * from user";
        ResultSet resultSet = stmt.executeQuery(sql1);
        while(resultSet.next()){
            System.out.println(" ------ ");

        }
        JDBCUtils.close(conn,stmt);
    }
}
