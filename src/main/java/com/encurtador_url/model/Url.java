package com.encurtador_url.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Document(collection = "urls")
public class Url {
    @Id
    private String id;
    private String fullUrl;
    private Date expiresAt;

    public Url(String id, String fullUrl, LocalDateTime expiresAt) {
        this.id = id;
        this.fullUrl = fullUrl;
        this.expiresAt = Date.from(expiresAt.atZone(ZoneId.systemDefault()).toInstant());
    }
    public Url() {}

    public LocalDateTime getExpiresAtAsLocalDateTime() {
        return expiresAt.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public String getId() {
        return id;
    }

    public Url setId(String id) {
        this.id = id;
        return this;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public Url setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
        return this;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public Url setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
        return this;
    }
}
