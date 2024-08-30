package backend.project.controllers;

import backend.project.entities.Club;
import backend.project.entities.Player;
import backend.project.services.ClubService;
import backend.project.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @Autowired
    private ClubService clubService;

    @GetMapping
    public ResponseEntity<?> listarTodo(){
        List<Player> players = playerService.listarTodo();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/club/{idClub}")
    public ResponseEntity<?> listarPorClub(@PathVariable Long idClub){
        List<Player> players = playerService.listarPorClub(idClub);
        return ResponseEntity.ok(players);
    }

    @GetMapping("/position/{position}")
    public ResponseEntity<?> listarPorPosicion(@PathVariable String position){
        List<Player> players = playerService.listarPorPosicion(position);
        return ResponseEntity.ok(players);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> registrarEnClub (@PathVariable Long id, @RequestBody Player player){
        Club club = clubService.listarPorId(id);
        if(club != null){
            player.setClub(club);
            Player playerCreate = playerService.registrar(player);
            return ResponseEntity.ok(playerCreate);
        }
        else{
            return ResponseEntity.ok(null);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar (@PathVariable Long id){
        playerService.eliminar(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar (@PathVariable Long id, @RequestBody Player playerDetails){
        Club club = playerService.ObtenerClubPorId(id);
        playerDetails.setId(id);
        playerDetails.setClub(club);
        Player playerUpdate = playerService.actualizar(playerDetails);
        return ResponseEntity.ok(playerUpdate);
    }

}
