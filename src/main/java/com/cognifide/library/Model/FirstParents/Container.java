package com.cognifide.library.Model.FirstParents;


import java.util.List;

public class Container {

    private String requestedUrl;
    private List<Item> items;


    public String getRequestedUrl() {
        return requestedUrl;
    }

    public void setRequestedUrl(String requestedUrl) {
        this.requestedUrl = requestedUrl;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
