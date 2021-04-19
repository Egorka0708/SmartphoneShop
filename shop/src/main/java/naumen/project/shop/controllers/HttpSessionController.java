package naumen.project.shop.controllers;

import naumen.project.shop.bean.HttpSessionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpSessionController {

    private final HttpSessionBean httpSessionBean;

    @Autowired
    public HttpSessionController(HttpSessionBean httpSessionBean) {
        this.httpSessionBean = httpSessionBean;
    }

    @GetMapping(path = "/controller")
    public String example(Integer userId){
        if(!StringUtils.isEmpty(userId)){
            httpSessionBean.setId(userId);
            return "New name have been received - " + userId;
        }else if (!StringUtils.isEmpty(httpSessionBean.getId())){
            return "Current name: " + httpSessionBean.getId();
        }else {
            return "There is no saved name";
        }
    }
}
