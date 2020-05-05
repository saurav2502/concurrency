package com.udemy.currencyexchangeservice.controller;

import com.udemy.currencyexchangeservice.custom.AccessControl;
import com.udemy.currencyexchangeservice.custom.ApiResource;
import com.udemy.currencyexchangeservice.service.Role;
import com.udemy.currencyexchangeservice.vo.Exchangevalue;
import com.udemy.currencyexchangeservice.vo.Items;
import java.io.File;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8005", maxAge = 3600)
@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    private static Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private Environment env;

    @Autowired
    private Role role;

    @GetMapping("/up")
    public String serviceIsUp() {
        return new String("Currency Service Is Up.");
    }

    @GetMapping("/from/{from}/to/{to}")
    public Exchangevalue getExchangeRate(@PathVariable("from") String from,
            @PathVariable("to") String to) {
        Exchangevalue av = new Exchangevalue();
        logger.info("Running on port: " + env.getProperty("local.server.port"));
        logger.error("Running on port: " + env.getProperty("local.server.port"));
        int port = Integer.parseInt(env.getProperty("local.server.port"));
        av.setPort(port);
        return new Exchangevalue(1000L, from, to, new BigDecimal(72), port);
    }

    @GetMapping("/file/operation")
    public String getFileInfo() {
        File folder = new File("src/main/resources/sql");
        File[] files = folder.listFiles();
        Arrays.stream(files).parallel().forEach(data -> System.out.println(data.getName()));
        return new String();
    }

    @GetMapping("/getItems")
    public List<Items> getItems() {
        List<Items> items = new ArrayList<>();
        items.add(new Items("Huawei", "IkYA", "Quess", "Bangalore", "Bangalore", "Indian"));
        items.add(new Items("SAP", "SAP", "QuessCorp", "Bangalore", "Bangalore", "Indian"));
        return items;
    }

    @GetMapping("/getCounntry")
    public List<String> getCounntry() {
        List<String> list = Arrays
                .asList("Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antarctica",
                        "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria",
                        "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus",
                        "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia",
                        "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria",
                        "Burkina Faso", "Burma", "Burundi", "Cambodia", "Cameroon", "Canada",
                        "Cape Verde", "Central African Republic", "Chad", "Chile", "China",
                        "Colombia", "Comoros", "Congo, Democratic Republic",
                        "Congo, Republic of the", "Costa Rica", "Cote d`Ivoire", "Croatia", "Cuba",
                        "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica",
                        "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador",
                        "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland",
                        "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece",
                        "Greenland", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana",
                        "Haiti", "Honduras", "Hong Kong", "Hungary", "Iceland", "India",
                        "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica",
                        "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, North",
                        "Korea, South", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon",
                        "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg",
                        "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali",
                        "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico",
                        "Micronesia", "Moldova", "Mongolia", "Morocco", "Monaco", "Mozambique",
                        "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua",
                        "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Panama",
                        "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal",
                        "Qatar", "Romania", "Russia", "Rwanda", "Samoa", "San Marino", " Sao Tome",
                        "Saudi Arabia", "Senegal", "Serbia and Montenegro", "Seychelles",
                        "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands",
                        "Somalia", "South Africa", "Spain", "Sri Lanka", "Sudan", "Suriname",
                        "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan",
                        "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia",
                        "Turkey", "Turkmenistan", "Uganda", "Ukraine", "United Arab Emirates",
                        "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu",
                        "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe");
        return list;
    }

    @DeleteMapping("/deleteRecord")
    public ResponseEntity<String> deleteRecord(@RequestParam("id") String id) {
        List<String> list = new ArrayList<>();
        list.add("Saurav");
        list.add("Amit");
        list.add("Mahesh");
        if (list.contains(id)) {
            Iterator itr = list.iterator();
            try {
                while (itr.hasNext()) {
                    if (id.equals(itr.next())) {
                        itr.remove();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return new ResponseEntity<String>(id, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>(id, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteData")
    @AccessControl(name = "deleteData", value = "deleteData", required = true, token = "")
    public Object deleteData(@RequestBody Exchangevalue exchangevalue) {
        Object obj = exchangevalue;
        if (!StringUtils.isEmpty(exchangevalue)) {
            return exchangevalue;
        }
        return new Object();
    }
    @GetMapping("/getLog")
    public Boolean getLogRecord(){
        boolean bool = role.checkRole();
        return bool;
    }
}
