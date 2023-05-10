package com.rotten.carrots.Marketplace;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "marketplaces")
@Getter
@Setter
@AllArgsConstructor
public class Marketplace {

    @Id
    private String marketplaceID;

    private String gameID;

    private String description;

    private float price;

    private String userID;

    private LocalDate date;

}
