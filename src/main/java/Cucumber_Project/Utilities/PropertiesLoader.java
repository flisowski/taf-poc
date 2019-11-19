package Cucumber_Project.Utilities;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by flisowski on 20/05/2019.
 */
public class PropertiesLoader {

    Properties properties;

    public PropertiesLoader() {
            properties = new Properties();
            try {
                InputStream input = this.getClass().getClassLoader().getResourceAsStream("application.properties");
                properties.load(input);
            }
            catch (Exception ex) {
                System.out.println(ex);
            }
    }

    public Properties getProperties() {
        return properties;
    }

    public boolean isScopeReuse(){
        boolean scope = this.getProperties().get("scope").toString().equals("reuse") ? true : false;
        return scope;
    }

    public String getGridUrl(){
        return this.getProperties().get("grid").toString();
    }
}
