package br.com.internato.api.dto.request;


import jakarta.validation.constraints.NotNull;

public record AlocacaoRequest(
        @NotNull Long plantaoId,
        @NotNull Long alunoId
) {}