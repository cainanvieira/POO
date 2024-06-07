package fatecfranca.edu.livrariatrabalho.model.repository;

import fatecfranca.edu.livrariatrabalho.model.entity.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditoraRepository extends JpaRepository<Editora, Long> {
}