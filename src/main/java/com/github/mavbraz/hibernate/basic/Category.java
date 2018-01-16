package com.github.mavbraz.hibernate.basic;

public enum Category {
    NONE("Nenhum"), REGRAS_CIRCULACAO("Regras de Circulação"),
    LEGISLACAO_TRANSITO("Legislação de Trânsito"), NOT_IDENTIFIED("Não Identificado"),
    DIRECAO_DEFENSIVA("Direção Defensiva"), SINALIZACAO("Sinalização"),
    MECANICA_BASICA("Mecânica Básica"), PRIMEIROS_SOCORROS("Noções de Primeiros Socorros"),
    CIDADANIA_MEIO_AMBIENTE("Cidadania e Meio Ambiente");

    private final String description;

    private Category(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
