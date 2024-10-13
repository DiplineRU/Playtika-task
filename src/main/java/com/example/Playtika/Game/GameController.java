package com.example.Playtika.Game;

import com.example.Playtika.Location.LocationDTO;
import com.example.Playtika.Player.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/players/{id}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable Long id) {
        PlayerDTO playerDTO = gameService.getPlayerById(id);
        return ResponseEntity.ok(playerDTO);
    }

    @PostMapping("/players/{playerId}/move/{locationId}")
    public ResponseEntity<String> movePlayer(@PathVariable Long playerId, @PathVariable Long locationId) {
        gameService.movePlayer(playerId, locationId);
        return ResponseEntity.ok("Player moved successfully");
    }

    @GetMapping("/locations/{id}")
    public ResponseEntity<LocationDTO> getLocationById(@PathVariable Long id) {
        LocationDTO locationDTO = gameService.getLocationById(id);
        return ResponseEntity.ok(locationDTO);
    }
}

