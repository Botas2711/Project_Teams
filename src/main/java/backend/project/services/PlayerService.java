package backend.project.services;

import backend.project.entities.Club;
import backend.project.entities.Player;
import backend.project.repositories.ClubRepository;
import backend.project.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ClubService clubService;

    public List<Player> listarTodo(){
        return playerRepository.findAll();
    }

    public List<Player> listarPorClub(Long idClub){
        return playerRepository.findByClub_Id(idClub);
    }

    public List<Player> listarPorPosicion(String position){
        return playerRepository.findByPosition(position);
    }

    public Player registrar (Player player){
        return playerRepository.save(player);
    }

    public void eliminar (Long id){
        playerRepository.deleteById(id);
    }

    public Player actualizar (Player player){
        return playerRepository.save(player);
    }

    public Club ObtenerClubPorId(Long id){
        return playerRepository.obtenerClub(id);
    }
}
