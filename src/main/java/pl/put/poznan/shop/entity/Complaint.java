package pl.put.poznan.shop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "complaints", schema = "online_shop")
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "complaint_date", nullable = false)
    private LocalDate complaintDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status", referencedColumnName = "id", nullable = false)
    private ComplaintType complaintType;

}
