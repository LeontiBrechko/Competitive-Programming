package net.liavontsibrechka.model.response.user;

import net.liavontsibrechka.model.Submission;

import java.util.List;

public class UserStatusResponse {
    private String status;
    private List<Submission> result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Submission> getResult() {
        return result;
    }

    public void setResult(List<Submission> result) {
        this.result = result;
    }
}
