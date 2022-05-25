public class Estoque {

private int codigo;
private String nome;
private int quant;
private double valor;


public Estoque() {
}

public Estoque(int codigo, String nome, int quant, double valor) {
    this.codigo = codigo;
    this.nome = nome;
    this.quant = quant;
    this.valor = valor;
}

public int getCodigo() {
    return codigo;
}
public void setCodigo(int codigo) {
    this.codigo = codigo;
}
public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}
public int getQuant() {
    return quant;
}
public void setQuant(int quant) {
    this.quant = quant;
}
public double getValor() {
    return valor;
}
public void setValor(double valor) {
    this.valor = valor;
}
@Override
public String toString() {
    return " \n [codigo = " + codigo + ", Nome = " + nome + ", Quantidade = " + quant + ", valor = " + valor + "]";
}

}
