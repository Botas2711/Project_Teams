package backend.project.repositories;

import backend.project.entities.Club;
import backend.project.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    public List<Player> findByPosition (String position);
    public List<Player> findByClub_Id (Long id);

    @Query(name = "true", value ="" +
            "SELECT P.club FROM players P WHERE P.id = :id")
    public Club obtenerClub (@Param("id") Long id);
}
