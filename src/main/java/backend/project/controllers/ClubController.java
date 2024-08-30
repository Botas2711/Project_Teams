package backend.project.controllers;

import backend.project.entities.Club;
import backend.project.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
public class ClubController {
    @Autowired
    private ClubService clubService;

    @GetMapping
    public ResponseEntity<?> listarTodo(){
        List<Club> clubs = clubService.listarTodo();
        return ResponseEntity.ok(clubs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        Club club = clubService.listarPorId(id);
        return ResponseEntity.ok(club);
    }

    @PostMapping
    public ResponseEntity<?> registrar (@RequestBody Club club){
        Club clubCreate = clubService.registrar(club);
        return ResponseEntity.ok(clubCreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar (@PathVariable Long id, @RequestBody Club clubDetails){
        clubDetails.setId(id);
        Club clubUpdate = clubService.actualizar(clubDetails);
        return ResponseEntity.ok(clubUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar (@PathVariable Long id){
        clubService.eliminar(id);
        return ResponseEntity.ok(null);
    }
}
