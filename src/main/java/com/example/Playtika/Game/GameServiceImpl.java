package com.example.Playtika.Game;

import com.example.Playtika.Location.Location;
import com.example.Playtika.Location.LocationDTO;
import com.example.Playtika.Location.LocationRepository;
import com.example.Playtika.Player.Player;
import com.example.Playtika.Player.PlayerDTO;
import com.example.Playtika.Player.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    private final PlayerRepository playerRepository;
    private final LocationRepository locationRepository;
    public GameServiceImpl(PlayerRepository playerRepository,LocationRepository locationRepository){
        this.locationRepository = locationRepository;
        this.playerRepository = playerRepository;
    }
    @Override
    public PlayerDTO getPlayerById(Long id) {
        Player player = playerRepository.findById(id).orElse(null);
        if (player == null) {
            throw new NoSuchElementException("Player not found");
        }
        return convertPlayerToDTO(player);
    }

    @Override
    public void movePlayer(Long playerId, Long locationId) {
        Player player = playerRepository.findById(playerId).orElse(null);
        Location location = locationRepository.findById(locationId).orElse(null);
        if (player == null || location == null) {
            throw new NoSuchElementException("Player or location not found");
        }
        player.setLocation(location);
        playerRepository.save(player);
    }

    @Override
    public LocationDTO getLocationById(Long id) {
        Location location = locationRepository.findById(id).orElse(null);
        if (location == null) {
            throw new NoSuchElementException("Location not found");
        }
        return convertLocationToDTO(location);
    }

    private PlayerDTO convertPlayerToDTO(Player player) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(player.getId());
        playerDTO.setName(player.getName());
        playerDTO.setLocationId(player.getLocation().getId());
        return playerDTO;
    }

    private LocationDTO convertLocationToDTO(Location location) {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(location.getId());
        locationDTO.setXCoordinate(location.getXCoordinate());
        locationDTO.setYCoordinate(location.getYCoordinate());
        locationDTO.setPlayers(location.getPlayers().stream()
                .map(this::convertPlayerToDTO)
                .collect(Collectors.toList()));
        locationDTO.setNeighborIds(location.getNeighbors().stream()
                .map(Location::getId)
                .collect(Collectors.toList()));
        return locationDTO;
    }
}
