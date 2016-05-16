package domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrdezzods on 27/02/16.
 */
@Entity
@Table(name = "restaurants")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Restaurant {

    @Id
    private Integer id;

    private String slug;

    private String name;

    private String logo;

    private String address;

    @Column(name = "reservation_opens_at")
    private String reservationOpensAt;

    @Column(name = "reservation_closes_at")
    private String reservationClosesAt;

    @Column(name = "max_reservations")
    private int maxReservations;

    @OneToMany(mappedBy = "restaurant")
    private List<Reservation> reservations;


    public List<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(Reservation reservation) {
        if (this.reservations == null) {
            this.reservations = new ArrayList<Reservation>();
        }
        this.reservations.add(reservation);
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getLogo() {
        return logo;
    }

    public String getAddress() {
        return address;
    }

    public String getReservationOpensAt() {
        return reservationOpensAt;
    }

    public String getReservationClosesAt() {
        return reservationClosesAt;
    }

    public int getMaxReservations() {
        return maxReservations;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setReservationOpensAt(String reservationOpensAt) {
        this.reservationOpensAt = reservationOpensAt;
    }

    public void setReservationClosesAt(String reservationClosesAt) {
        this.reservationClosesAt = reservationClosesAt;
    }

    public void setMaxReservations(int maxReservations) {
        this.maxReservations = maxReservations;
    }
}
