package professorangoti.com.interaocomousuario.api.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProdutoVrDto implements Serializable {

    @SerializedName("produto")
    private String produto;

    @SerializedName("valor")
    private String valor;

    public ProdutoVrDto() {
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}