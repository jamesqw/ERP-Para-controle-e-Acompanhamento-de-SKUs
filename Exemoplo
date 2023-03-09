import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdicionarProdutos {

    // Simulando a lista de produtos a serem adicionados
    private static List<Produto> listaProdutos = new ArrayList<Produto>();
    
    // Simulando o mapa de naturezas de operação e seus produtos
    private static Map<String, List<Produto>> mapaNaturezas = new HashMap<String, List<Produto>>();
    
    public static void main(String[] args) {
        
        // Adicionando novos produtos à lista
        listaProdutos.add(new Produto("SKU001", "CST001"));
        listaProdutos.add(new Produto("SKU002", "CST002"));
        listaProdutos.add(new Produto("SKU003", "CST003"));
        
        // Simulando a lista de naturezas de operação
        List<String> listaNaturezas = new ArrayList<String>();
        listaNaturezas.add("Natureza001");
        listaNaturezas.add("Natureza002");
        listaNaturezas.add("Natureza003");
        
        // Adicionando cada produto em todas as naturezas de operação
        for (Produto produto : listaProdutos) {
            for (String natureza : listaNaturezas) {
                adicionarProduto(produto, natureza);
            }
        }
        
        // Exibindo a lista de produtos por natureza de operação
        for (String natureza : listaNaturezas) {
            System.out.println("Natureza: " + natureza);
            List<Produto> produtosNatureza = mapaNaturezas.get(natureza);
            for (Produto produto : produtosNatureza) {
                System.out.println("- " + produto.getCodigo() + " - " + produto.getCst());
            }
        }
        
        // Verificando quais produtos não estão em alguma das naturezas de operação
        for (Produto produto : listaProdutos) {
            boolean encontrado = false;
            for (String natureza : listaNaturezas) {
                if (mapaNaturezas.get(natureza).contains(produto)) {
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Produto " + produto.getCodigo() + " não está em alguma das naturezas.");
            }
        }
        
    }
    
    private static void adicionarProduto(Produto produto, String natureza) {
        List<Produto> produtosNatureza = mapaNaturezas.get(natureza);
        if (produtosNatureza == null) {
            produtosNatureza = new ArrayList<Produto>();
        }
        produtosNatureza.add(produto);
        mapaNaturezas.put(natureza, produtosNatureza);
    }
    
}

class Produto {
    
    private String codigo;
    private String cst;
    
    public Produto(String codigo, String cst) {
        this.codigo = codigo;
        this.cst = cst;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public String getCst() {
        return cst;
    }
    
}
