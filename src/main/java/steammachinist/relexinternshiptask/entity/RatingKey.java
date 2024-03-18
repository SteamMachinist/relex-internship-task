package steammachinist.relexinternshiptask.entity;

import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class RatingKey implements Serializable {
    private User user;
    private LocalDate date;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        RatingKey ratingKey = (RatingKey) o;
        return user != null && Objects.equals(user, ratingKey.user)
                && date != null && Objects.equals(date, ratingKey.date);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(user, date);
    }
}
