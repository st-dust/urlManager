package com.stdust.urlManager.dto;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class TileDTO {
    @NotEmpty
    @Size(min = 2, max = 50, message = "Title should have from 2 to 50 characters")
    private String title;

    @Size(max = 100, message = "Description can contain only up to 100 characters")
    private String description;

    @URL
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
