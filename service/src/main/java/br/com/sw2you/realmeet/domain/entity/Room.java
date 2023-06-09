package br.com.sw2you.realmeet.domain.entity;

import javax.persistence.*;
import java.util.Objects;

import static java.util.Objects.isNull;

@Entity
@Table(name = "room")
public class Room {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String nome;

    @Column(name = "seats", nullable = false)
    private Integer seats;

    @Column(name = "active", nullable = false)
    private Boolean active;

    public Room() {

    }

    public Room(Long id, String nome, Integer seats, Boolean active) {
        this.id = id;
        this.nome = nome;
        this.seats = seats;
        this.active = active;
    }

    @PrePersist
    public void prePersist() {
        if(isNull(active)) {
            active = true;
        }
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getSeats() {
        return seats;
    }

    public Boolean getActive() {
        return active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return (
                Objects.equals(id, room.id) &&
                Objects.equals(nome, room.nome) &&
                Objects.equals(seats, room.seats) &&
                Objects.equals(active, room.active)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, seats, active);
    }

    @Override
    public String toString() {
        return (
                "Room{" +
                "id=" +
                id +
                ", nome='" +
                nome +
                '\'' +
                ", seats=" +
                seats +
                ", active=" +
                active +
                '}'
        );
    }
    public static Builder newBuild() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String nome;
        private Integer seats;
        private Boolean active;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder seats(Integer seats) {
            this.seats = seats;
            return this;
        }

        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }

        public Room build() {
            return new Room(id, nome, seats, active);
        }
    }
}
