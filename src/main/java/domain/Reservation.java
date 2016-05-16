package domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by mrdezzods on 27/02/16.
 */
@Entity
@Table(name = "reservations")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @ManyToOne()
    @JoinColumn(name = "restaurant_id")
    @JsonProperty
    private Restaurant restaurant;


    @Valid
    @ManyToOne()
    @JoinColumn(name = "client_id")
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    @NotNull(message = "{validation.reservation.people.notnull}")
    @Max(value = 10, message = "{validation.reservation.people.max}")
    @Min(value = 1, message = "{validation.reservation.people.min}")
    private int people = 2;

    @Column(name = "reservation_for")
    @NotNull(message = "{validation.date.not.null}")
    private Date reservationFor;


    private String note;

    @NotNull
    private String status = "Pending";

    public int getId() {
        return id;
    }


    public Restaurant getRestaurant() {
        return restaurant;
    }


    public int getPeople() {
        return people;
    }

    public Date getReservationFor() {
        return reservationFor;
    }

    public String getNote() {
        return note;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


    public void setPeople(int people) {
        this.people = people;
    }

    public void setReservationFor(Date reservationFor) {
        this.reservationFor = reservationFor;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
