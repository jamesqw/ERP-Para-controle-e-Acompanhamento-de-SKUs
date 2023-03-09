import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        listaProdutos.forEach(produto -> listaNaturezas.forEach(natureza -> adicionarProduto(produto, natureza)));
        
        // Exibindo a lista de produtos por natureza de operação
        listaNaturezas.forEach(natureza -> {
            System.out.println("Natureza: " + natureza);
            mapaNaturezas.get(natureza).forEach(produto -> System.out.println("- " + produto.getCodigo() + " - " + produto.getCst()));
        });
        
        // Verificando quais produtos não estão em alguma das naturezas de operação
        List<Produto> produtosSemNatureza = listaProdutos.stream()
                .filter(produto -> listaNaturezas.stream().noneMatch(natureza -> mapaNaturezas.get(natureza).contains(produto)))
                .collect(Collectors.toList());
        produtosSemNatureza.forEach(produto -> System.out.println("Produto " + produto.getCodigo() + " não está em alguma das naturezas."));
        
    }
    
    private static void adicionarProduto(Produto produto, String natureza) {
        mapaNaturezas.computeIfAbsent(natureza, key -> new ArrayList<Produto>()).add(produto);
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
