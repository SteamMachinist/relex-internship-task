package steammachinist.relexinternshiptask.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name="harvest_entry")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HarvestPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate date;
    @OneToOne
    private User user;

    @ElementCollection
    @CollectionTable(
            name = "plan_product_mapping",
            joinColumns = @JoinColumn(name = "plan_id"))
    @MapKeyJoinColumn(name = "product_id")
    @Column(name = "amount")
    private Map<Product, Double> productsAmount = new HashMap<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        HarvestPlan that = (HarvestPlan) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
