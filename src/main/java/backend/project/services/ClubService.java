package backend.project.services;

import backend.project.entities.Club;
import backend.project.repositories.ClubRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {
    @Autowired
    private ClubRepository clubRepository;

    public List<Club> listarTodo(){
        return clubRepository.findAll();
    }

    public Club listarPorId(Long id){
        return clubRepository.findById(id).get();
    }

    public Club registrar(Club club){
        return clubRepository.save(club);
    }

    public void eliminar (Long id){
        clubRepository.deleteById(id);
    }

    public Club actualizar (Club club){
        return clubRepository.save(club);
    }

}
