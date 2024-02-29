package lk.ijse.HIBERNATE_COURSE_WORK.util;
/* 
    @author Sachi_S_Bandara
    @created 2/29/2024 - 10:07 PM 
*/

import java.io.IOException;
import java.util.Properties;

public class Utility {
    public static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader
                    .getSystemClassLoader()
                    .getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            System.out.println("Property file not found!");
            e.printStackTrace();
        }
        return properties;
    }
}
