package com.controller.design.requestentity;


import java.io.Serializable;

public class Event implements Serializable {

    private String subscription_id;
    private String subscription_name;
    private String subscription_description;

    public Event() {
    }

    public Event(String subscription_id, String subscription_name, String subscription_description) {
        this.subscription_id = subscription_id;
        this.subscription_name = subscription_name;
        this.subscription_description = subscription_description;
    }

    public String getSubscription_id() {
        return subscription_id;
    }

    public void setSubscription_id(String subscription_id) {
        this.subscription_id = subscription_id;
    }

    public String getSubscription_name() {
        return subscription_name;
    }

    public void setSubscription_name(String subscription_name) {
        this.subscription_name = subscription_name;
    }

    public String getSubscription_description() {
        return subscription_description;
    }

    public void setSubscription_description(String subscription_description) {
        this.subscription_description = subscription_description;
    }
}
