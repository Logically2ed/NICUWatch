package nicuwatch.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.testng.annotations.Test;

import nicuwatch.API.MWMedical;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceCLient {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void testswapiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
            client.target("https://dictionaryapi.com/api/v3/references/medical/json/test?key=813e5752-3262-4f86-86d3-71b08c49ce9a");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        logger.info(response);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MWMedical[] medical = mapper.readValue(response, MWMedical[].class);
        logger.info(medical[0].getMWMedical());
        String expectedString = "???";

        assertEquals(expectedString, medical[1].getMWMedical().get(1).getFl());
    }
}