package as.tomatoapp.helper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.DateTime;

import java.io.IOException;
import java.sql.Timestamp;

public class DataTimeToTimestampSerializer extends JsonSerializer<DateTime> {

    @Override
    public void serialize(
            DateTime dateTime,
            JsonGenerator jsonGenerator,
            SerializerProvider serializerProvider
    ) throws IOException, JsonProcessingException {
        Timestamp timestamp = new Timestamp(dateTime.getMillis()/1000L);

        jsonGenerator.writeObject(timestamp.getTime());
    }
}
