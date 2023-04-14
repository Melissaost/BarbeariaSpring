package com.barbearias.domain.barbearia;

import com.barbearias.domain.barbearia.dto.DadosAtualizacaoBarbearia;
import com.barbearias.domain.barbearia.dto.DadosCadastroBarbearia;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "barbearias")
@Entity(name= "Barbearia")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Barbearia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String cep;
    private String telefone;
    private String imagem;
    private Boolean ativo;


    public Barbearia(DadosCadastroBarbearia dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.cidade = dados.cidade();
        this.bairro = dados.bairro();
        this.rua = dados.rua();
        this.numero = dados.numero();
        this.cep = dados.cep();
        this.imagem = dados.imagem();
    }

    public void atualizarInformacoes(DadosAtualizacaoBarbearia dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.imagem() != null) {
            this.imagem = dados.imagem();
        }
    }

    public void excluir() {
        this.ativo = false;
    }

    public void reativar() {
        this.ativo = true;
    }

}
