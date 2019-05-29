package testDB;

import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDB {
    static Database dbAUI;
    static Database dbCAMUNDA750;
    static Database dbRISK;
    static Logger logger = Logger.getLogger(TestDB.class);

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbAUI = new Database("AUI_DB", "Postgres");
        logger.info("AUI DB connected");
        dbRISK = new Database("RISK_DB","Postgres");
        logger.info("RISK DB connected");
//        dbCAMUNDA750 = new Database("CAMUNDA750_DB","Postgres");
//        logger.info("COMUNDA750 DB connected");
    }

    @After
    public void tearDown() throws SQLException {
        dbAUI.quit();
        logger.info("AUI DB disconnected");
//        dbCAMUNDA750.quit();
//        logger.info("COMUNDA750 DB connected");
        dbRISK.quit();
        logger.info("RISK DB disconnected");
    }

    @Test
    public void testDB() throws SQLException {
        List<ArrayList> dataFromSeleniumTable = dbAUI.selectTable("select * from userscredentials where phone like '77777%'");
//        dbPostgresSQL.changeTable("INSERT INTO seleniumTable VALUES (4, 'Fedorenko', 'pass')");
//        dataFromSeleniumTable = dbPostgresSQL.selectTable("select * from seleniumTable where login = 'Fedorenko'");
//        dbPostgresSQL.changeTable("delete from seleniumTable where login = 'Fedorenko'");
        for (ArrayList line : dataFromSeleniumTable
        ) {
            logger.info(line);
        }
//        List<ArrayList> dataFromSeleniumTable1 = dbCAMUNDA750.selectTable("select * from action where promo_name='EKASSA30'");
////        dbPostgresSQL.changeTable("INSERT INTO seleniumTable VALUES (4, 'Fedorenko', 'pass')");
////        dataFromSeleniumTable = dbPostgresSQL.selectTable("select * from seleniumTable where login = 'Fedorenko'");
////        dbPostgresSQL.changeTable("delete from seleniumTable where login = 'Fedorenko'");
//        for (ArrayList line : dataFromSeleniumTable1
//                ) {
//            logger.info(line);
//        }
//        List<ArrayList> dataFromSeleniumTable12 = dbRISK.selectTable("select * from bodeals_copy where pesel = '80091903693'");
//        dbPostgresSQL.changeTable("INSERT INTO seleniumTable VALUES (4, 'Fedorenko', 'pass')");
//        dataFromSeleniumTable = dbPostgresSQL.selectTable("select * from seleniumTable where login = 'Fedorenko'");
//        dbPostgresSQL.changeTable("delete from seleniumTable where login = 'Fedorenko'");
//        for (ArrayList line : dataFromSeleniumTable12
//                ) {
//            logger.info(line);
//        }
    }


}
