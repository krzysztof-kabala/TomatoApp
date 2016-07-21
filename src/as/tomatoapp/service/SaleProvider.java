package as.tomatoapp.service;

import as.tomatoapp.model.Sale;
import as.tomatoapp.util.NumericUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Component
public class SaleProvider {
    @Autowired
    private NumericUtil numericUtil;

    /**
     * generate list of Sale objects, then order by timestamp
     *
     * @param howMany Integer
     * @return List<Sale>
     */
    public List<Sale> createSales(Integer howMany) {
        List<Sale> sales = new ArrayList<>();

        int maxSales = (howMany > 0) ? howMany : 0;

        for (int i = 0; i < maxSales; i++) {
            sales.add(this.createSale());
        }

        sales.sort(
            (left, right) -> left.getTimestamp().compareTo(right.getTimestamp())
        );

        return sales;
    }

    /**
     * generate single Sale object
     *
     * @return Sale
     */
    public Sale createSale() {
        UUID newId = this.generateId();
        Integer tomatoes = this.generateTomatoes();
        String provider = this.generateProvider();
        DateTime timestamp = this.generateTimestamp();

        return new Sale(
                newId,
                tomatoes,
                provider,
                timestamp
        );
    }

    /**
     * generate random UUID
     *
     * @return UUID
     */
    private UUID generateId() {
        return UUID.randomUUID();
    }

    /**
     * generate random tomatoes
     *
     * @return Integer
     */
    private Integer generateTomatoes() {
        return this.numericUtil.randomInt(1, 2000);
    }

    /**
     * generate one of stored provider
     *
     * @return String
     */
    private String generateProvider() {
        String[] providers = {"Heinz", "Hunt's", "Del Monte", "Le Ol' Granma"};

        int randomIndex = this.numericUtil.randomInt(0, providers.length - 1);

        return providers[randomIndex];
    }

    /**
     * generate random date from start of current year to now
     *
     * @return DateTime
     */
    private DateTime generateTimestamp() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        DateTime startDate = new DateTime(year, 1, 1, 0, 0);
        DateTime endDate = new DateTime();

        long dateBetween = this.numericUtil.randomLong(startDate.getMillis(), endDate.getMillis());

        return new DateTime(dateBetween);
    }
}
