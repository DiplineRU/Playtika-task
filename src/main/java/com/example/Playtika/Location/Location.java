package com.example.Playtika.Location;

import com.example.Playtika.Player.Player;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int xCoordinate;
    private int yCoordinate;

    @OneToMany(mappedBy = "location")
    private List<Player> players;

    @ManyToMany
    @JoinTable(
            name = "location_neighbors",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "neighbor_id")
    )
    private List<Location> neighbors;

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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Location> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Location> neighbors) {
        this.neighbors = neighbors;
    }
}
