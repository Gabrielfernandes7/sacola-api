package me.dio.sacola.resource.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@Embeddable
@NoArgsConstructor
public class ItemDto {
    private Long itemId;
    private Long sacolaId;
    private int quantidade;
    public Long getProdutoId() {
        return null;
    }
    public Long getIdSacola() {
        return null;
    }
}
