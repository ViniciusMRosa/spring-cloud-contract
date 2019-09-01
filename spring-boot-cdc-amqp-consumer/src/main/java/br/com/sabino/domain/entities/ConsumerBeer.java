package br.com.sabino.domain.entities;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerBeer {
    @NotNull
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String ibu;
    @NotNull
    private String style;
    @NotNull
    private String description;
    @NotNull
    private String alcoholTenor;
}