package com.example.Playtika.Game;

import com.example.Playtika.Location.LocationDTO;
import com.example.Playtika.Player.PlayerDTO;

public interface GameService {

    PlayerDTO getPlayerById(Long id);

    void movePlayer(Long playerId, Long locationId);

    LocationDTO getLocationById(Long id);
}

