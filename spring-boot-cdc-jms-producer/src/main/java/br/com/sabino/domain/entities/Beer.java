package br.com.sabino.domain.entities;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Beer implements Serializable {

    private UUID id;
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

    public void randomUUID() {
        setId(UUID.randomUUID());
    }
}