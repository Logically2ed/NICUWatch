package nicuwatch.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public  class PropertiesLoader extends Properties{

    private final Logger logger = LogManager.getLogger(this.getClass());

    public PropertiesLoader() {
    }


    public  Properties loadProperties(String propertiesFilePath){
        Properties properties = new Properties();

        //logger.debug(propertiesFilePath);
        try {
            properties.load(this.getClass().getResourceAsStream
                    (propertiesFilePath));
        } catch (IOException ioException) {
            logger.error("IO exception (file not found) in"
                    + "loadProperties");
            ioException.printStackTrace();
        } catch (Exception exception) {
            logger.error("Other exception in loadProperties");
            exception.printStackTrace();
        }
        return properties;
    }
}