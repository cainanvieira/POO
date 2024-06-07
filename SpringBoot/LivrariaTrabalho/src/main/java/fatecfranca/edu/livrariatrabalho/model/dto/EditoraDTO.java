package fatecfranca.edu.livrariatrabalho.model.dto;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class EditoraDTO {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private String cnpj;

    private List<LivroDTO> livros = new ArrayList<>();
}
