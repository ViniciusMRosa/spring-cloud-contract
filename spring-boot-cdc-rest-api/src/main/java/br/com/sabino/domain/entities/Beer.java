package br.com.sabino.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private String name;
    private String ibu;
    private String style;
    private String description;
    private String alcoholTenor;

    public void randomUUID() {
        setId(UUID.randomUUID());
    }
}