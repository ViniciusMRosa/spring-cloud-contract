package br.com.sabino.domain.entities;

import lombok.*;
import net.bytebuddy.asm.Advice;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Beer {

    @NotNull
    @Builder.Default
    private int id = 1;
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