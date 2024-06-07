package fatecfranca.edu.produtodb.model.entity;
import fatecfranca.edu.produtodb.model.dto.FornecedorDTO;
import jakarta.persistence.*;
@Entity
@Table(name="produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome;
    @Column(name="descricao")
    private String descricao;
    @Column(name="qtde")
    private int qtde;
    @Column(name="preco")
    private float preco;

    @ManyToOne(fetch = FetchType.LAZY) // preguiçoso
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor = new Fornecedor();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", qtde=" + qtde +
                ", preco=" + preco +
                ", fornecedor=" + fornecedor +
                '}';
    }
}