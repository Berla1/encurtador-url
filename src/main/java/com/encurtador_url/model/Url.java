package com.encurtador_url.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collation = "urls")
public class Url {
    @Id
    private String id;
    private String fullUrl;
    private Date expiresAt;
}
