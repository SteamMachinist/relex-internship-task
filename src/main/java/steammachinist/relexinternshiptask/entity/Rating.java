package steammachinist.relexinternshiptask.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@IdClass(RatingKey.class)
@Table(name = "rating")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Rating {
    @Transient
    private final int MAX_POINTS = 5;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Id
    private LocalDate date;
    private int points;

    public Rating(User user, LocalDate date, int points) {
        this.user = user;
        this.date = date;
        this.points = Math.min(points, MAX_POINTS);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Rating rating = (Rating) o;
        return getUser() != null && Objects.equals(getUser(), rating.getUser())
                && getDate() != null && Objects.equals(getDate(), rating.getDate());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(user, date);
    }
}
