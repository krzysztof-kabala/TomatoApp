package as.tomatoapp.controller;

import as.tomatoapp.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
@ResponseBody
public class ExceptionHandlingController {

    @Autowired
    private JsonUtil jsonUtil;

    @RequestMapping("error")
    public String handleError(Exception e) {
        return "[]";
    }
}
