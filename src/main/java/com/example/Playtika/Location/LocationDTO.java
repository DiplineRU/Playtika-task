package com.example.Playtika.Location;

import com.example.Playtika.Player.PlayerDTO;
import lombok.Data;

import java.util.List;

@Data
public class LocationDTO {

    private Long id;
    private int xCoordinate;
    private int yCoordinate;
    private List<PlayerDTO> players;
    private List<Long> neighborIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDTO> players) {
        this.players = players;
    }

    public List<Long> getNeighborIds() {
        return neighborIds;
    }

    public void setNeighborIds(List<Long> neighborIds) {
        this.neighborIds = neighborIds;
    }
}
