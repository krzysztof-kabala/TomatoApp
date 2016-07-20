package as.tomatoapp.controller;

import as.tomatoapp.model.Sale;
import as.tomatoapp.service.SaleProvider;
import as.tomatoapp.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
@ResponseBody
public class DataController {

    @Autowired
    private JsonUtil jsonUtil;

    @Autowired
    private SaleProvider saleProvider;

    @RequestMapping()
    public String indexAction() throws JsonProcessingException {
        return "";
    }

    @RequestMapping(value = "data", method = {RequestMethod.GET, RequestMethod.POST})
    public String dataAction(
            @RequestParam(required = false, defaultValue = "3") Integer size
    ) throws JsonProcessingException {
        List<Sale> sales = this.saleProvider.createSales(size);

        return this.jsonUtil.toJson(sales);
    }
}
