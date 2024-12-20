package com.alexnogueira.cursomc.domain.enuns;

//Modelo sofisticado para tratar o ENUM

public enum TipoCliente {

    PESSOAFISICA(1,"Pessoa Física"),
    PESSOAJURIDICA(1,"Pessoa Jurídica");

    private int cod;
    private String descricao;
    
    private TipoCliente(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    //Método static porque não precisa ser instanciado para poder rodar
    public static TipoCliente toEnum(Integer cod) {
        if(cod == null){return null;}
        for(TipoCliente x: TipoCliente.values()) {
            if(cod.equals(x.getCod())){return x;}
        }
        throw new IllegalArgumentException("id inválido" + cod);
    }

}
