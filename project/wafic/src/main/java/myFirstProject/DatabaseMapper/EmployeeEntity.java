package myFirstProject.DatabaseMapper;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by root on 12/5/15.
 */

@Entity
@Table(name="employee")
public class EmployeeEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="company_id")
    private CompanyEntity companyEntity;

    @Column(name="name")
    private String name;

    @Column(name="position")
    private String position;

    @Column(name="created_at")
    private Date createdAt;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public CompanyEntity getCompanyEntity() {
        return companyEntity;
    }
    public void setCompanyEntity(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
