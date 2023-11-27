class ProdutoPerecivel extends Produto {
    private String dataValidade;

    public ProdutoPerecivel(String nome, double preco, String tipo, double peso, String codigoBarras, String codigoIdentificacao, String marca, String dataValidade) {
        super(nome, preco, tipo, peso, codigoBarras, codigoIdentificacao, marca);
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {

        return super.toString() + "\nData de Validade: " + dataValidade;
    }
}