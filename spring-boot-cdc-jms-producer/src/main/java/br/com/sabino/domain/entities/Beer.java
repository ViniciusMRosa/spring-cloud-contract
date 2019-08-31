package br.com.sabino.domain.entities;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Beer implements Serializable {

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