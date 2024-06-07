package fatecfranca.edu.livrariatrabalho.model.entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="autor")
    private String autor;

    @Column(name="qtde")
    private int qtde;

    @Column(name="preco")
    private float preco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cnpj_livraria")
    private Livraria livraria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cnpj_editora")
    private Editora editora;

    public Livro(Long id, String nome, String autor, int qtde, float preco, Livraria livraria) {
    }
}