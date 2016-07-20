package as.tomatoapp.model;

import as.tomatoapp.helper.DataTimeToTimestampSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.joda.time.DateTime;

import java.util.UUID;

public class Sale {
    private UUID id;
    private Integer tomatoes;
    private String provider;

    @JsonSerialize(using = DataTimeToTimestampSerializer.class)
    private DateTime timestamp;

    public Sale(UUID id, Integer tomatoes, String provider, DateTime timestamp) {
        this.id = id;
        this.tomatoes = tomatoes;
        this.provider = provider;
        this.timestamp = timestamp;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getTomatoes() {
        return tomatoes;
    }

    public void setTomatoes(Integer tomatoes) {
        this.tomatoes = tomatoes;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public DateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(DateTime timestamp) {
        this.timestamp = timestamp;
    }
}
