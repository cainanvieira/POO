package fatecfranca.edu.livrariatrabalho.model.dto;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class LivrariaDTO {
    private String telefone;
    private String nome;
    private String cnpj;
    private String endereco;

    private List<LivroDTO> livros = new ArrayList<>();
}