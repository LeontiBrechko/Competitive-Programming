package net.liavontsibrechka.api;

import net.liavontsibrechka.model.Submission;
import net.liavontsibrechka.model.response.user.UserStatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

@Component
public class UserRequests {
    private RestTemplate restTemplate;
    private ResourceBundle methodsResources;

    @Autowired
    public UserRequests(RestTemplate restTemplate, ResourceBundle methodsResources) {
        this.restTemplate = restTemplate;
        this.methodsResources = methodsResources;
    }

    public List<Submission> status(String handle, Integer from, Integer count) {
        if (handle == null) throw new RuntimeException("User handle must be specified for user.status request");

        StringBuilder url = new StringBuilder(methodsResources.getString("user.status"));
        Map<String, Object> urlVariables = new HashMap<>();
        url.append("?handle={handle}");
        urlVariables.put("handle", handle);

        if (from != null && from >= 1) {
            url.append("&from={from}");
            urlVariables.put("from", from);
        }
        if (count != null && count >= 0) {
            url.append("&count={count}");
            urlVariables.put("count", count);
        }

        return restTemplate.getForObject(url.toString(), UserStatusResponse.class, urlVariables).getResult();
    }
}
