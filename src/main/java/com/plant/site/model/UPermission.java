package com.plant.site.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UPermission {
    private Long id;

    private String url;

    private String name;

}