package ase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Agnes on 10/10/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    private String message;
    private String linkToNextTask;

    public Result() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLinkToNextTask() {
        return linkToNextTask;
    }

    public void setLinkToNextTask(String linkToNextTask) {
        this.linkToNextTask = linkToNextTask;
    }

    @Override
    public String toString() {
        return "Result{" +
                "message='" + message + '\'' +
                ", linkToNextTask='" + linkToNextTask + '\'' +
                '}';
    }
}
