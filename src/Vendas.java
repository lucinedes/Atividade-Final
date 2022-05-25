public class Vendas {

private String dataVendida;
private String proVendido;
private int quantVendida;
private double preco;


public Vendas() {
}

public String getDataVendida() {
    return dataVendida;
}

public void setDataVendida(String dataVendida) {
    this.dataVendida = dataVendida;
}

public String getProVendido() {
    return proVendido;
}

public void setProVendido(String proVendido) {
    this.proVendido = proVendido;
}

public int getQuantVendida() {
    return quantVendida;
}

public void setQuantVendida(int quantVendida) {
    this.quantVendida = quantVendida;
}

public double getPreco() {
    return preco;
}

public void setPreco(double preco) {
    this.preco = preco;
}

@Override
public String toString() {
    return "Vendas [Data Vendida =" + dataVendida + ", Produto Vendido =" + proVendido + ", Quantidade Vendida =" + quantVendida + ", Valor de Venda ="
            + preco + "]";
}
}