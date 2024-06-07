package fatecfranca.edu.livrariatrabalho.model.entity;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "editora")
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cnpj;

    @Column(name="nome")
    private String nome;

    @Column(name="telefone")
    private String telefone;

    @Column(name="endereco")
    private String endereco;

    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "editora", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Livro> livros = new ArrayList<>();
}

