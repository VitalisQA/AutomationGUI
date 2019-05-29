package libs;


import org.apache.log4j.Logger;
import org.junit.Assert;

import java.io.IOException;
import java.sql.SQLException;

public class UtilsForDB {
    Logger log = Logger.getLogger(getClass());
    Database dBAUI;


    public String getPassForLogin(String login) throws SQLException, IOException, ClassNotFoundException {
        log.info("--- Conect AUI_DB DB --------");
        dBAUI = new Database("AUI_DB", "Postgres");
        log.info("--- Conected to AUI_DB --------");
        String tempPass = dBAUI.selectValue("select passWord from seleniumTable where login = '" + login + "'");
        dBAUI.quit();
        return tempPass;

    }

    public void clearEverythingFromAuiByPhone(String phone) throws SQLException, IOException, ClassNotFoundException {
        dBAUI = new Database("AUI_DB", "Postgres");
        log.info("--- Conected to AUI_DB --------");
        if (dBAUI.isRowPresent("select id from userscredentials where phone='" + phone + "';"))
//                && (dBAUI.selectValue("select p.pesel from plainusers p " +
//                        "inner join userscredentials u on p.id=u.plain_user_id " +
//                        "where u.phone='" + phone + "';")) != null)
        {

            String pesel = dBAUI.selectValue("select p.pesel from plainusers p " +
                    "inner join userscredentials u on p.id=u.plain_user_id " +
                    "where u.phone='" + phone + "';");

            dBAUI.changeTable(
                    "delete from userscredentials where phone = '" + phone + "';");

        }

        Assert.assertFalse("User with phone " + phone + " was not deleted from AUI_DB",
                dBAUI.isRowPresent("select id from userscredentials where phone='" + phone + "';"));
        dBAUI.quit();
        log.info("--- Disconected from AUI_DB --------");

    }

    public boolean isUserRegistered(String phone) throws SQLException, IOException, ClassNotFoundException {
        dBAUI = new Database("AUI_DB", "Postgres");
        log.info("--- Conected to AUI_DB --------");
        try {
            boolean rowPresent = dBAUI.isRowPresent("select id from userscredentials where phone='" + phone + "';");
            dBAUI.quit();
            log.info("--- Disconected from AUI_DB --------");
            return rowPresent;
        } catch (Exception e) {
            dBAUI.quit();
            log.info("---Can not create connection with AUI_DB --------");
            return false;
        }
    }


}
