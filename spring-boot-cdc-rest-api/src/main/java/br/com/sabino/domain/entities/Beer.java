package br.com.sabino.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "beer")
public class Beer {

    @Id
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