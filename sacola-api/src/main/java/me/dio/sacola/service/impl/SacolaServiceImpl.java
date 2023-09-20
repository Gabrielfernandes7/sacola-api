package me.dio.sacola.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.dio.sacola.enumeration.FormaPagamento;
import me.dio.sacola.model.Item;
import me.dio.sacola.model.Sacola;
import me.dio.sacola.repository.ProdutoRepository;
import me.dio.sacola.repository.SacolaRepository;
import me.dio.sacola.resource.dto.ItemDto;
import me.dio.sacola.service.SacolaService;

@Service
@RequiredArgsConstructor
public class SacolaServiceImpl implements SacolaService {

    private final SacolaRepository sacolaRepository;
    private final ProdutoRepository produtoRepository;

    @Override
    public Item incluirItemNaSacola(ItemDto itemDto) {
        Sacola sacola = verSacola(itemDto.getIdSacola());

        if (sacola.isFechado()) {
            throw new RuntimeException("Esta sacola está fechada.");
        }

        Item.builder()
            .quantidade(itemDto.getQuantidade())
            .sacola(sacola)
            .produto(produtoRepository.findById(itemDto))
            .build();

        return null;
    }

    @Override
    public Sacola verSacola(Long id) {
        return sacolaRepository.findById(id).orElseThrow(
            () -> {
                throw new RuntimeException("Essa sacola não existe !");
            }
        );
    }

    @Override
    public Sacola fecharSacola(Long id, int numeroFormaPagamento) {

        Sacola sacola = verSacola(id);

        if (sacola.getItens().isEmpty()) {
            throw new RuntimeException("Inclua itens na sacola !");
        }

        FormaPagamento formaPagamento = 
            numeroFormaPagamento == 0 ? 
                FormaPagamento.DINHEIRO : FormaPagamento.MAQUINETA;

        
        sacola.setFormaPagamento(formaPagamento);
        sacola.setFechado(true);

        return sacolaRepository.save(sacola);
    }
    
}
