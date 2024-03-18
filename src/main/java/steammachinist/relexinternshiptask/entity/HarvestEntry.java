package steammachinist.relexinternshiptask.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="harvest_entry")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HarvestEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDateTime dateTime;
    @ManyToOne
    private User user;
    @ManyToOne
    private Product product;
    private double amount;

    public HarvestEntry(User user, Product product, double amount) {
        this.dateTime = LocalDateTime.now();
        this.user = user;
        this.product = product;
        if (product.isInteger()) {
            this.amount = (int)amount;
        } else {
            this.amount = amount;
        }
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        HarvestEntry that = (HarvestEntry) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
