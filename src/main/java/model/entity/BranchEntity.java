package model.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import model.enumerated.BranchTypeEnum;

@Entity
@Table(name = "branches", schema = "test_enterprise")
@SequenceGenerator(name = "branch_codes_gen", sequenceName = "test_enterprise.branch_codes_seq", allocationSize = 1)
public class BranchEntity extends AbstractEntity {

    @Id
    @Column(name = "branch_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "branch_codes_gen")
    private Integer id;

    @NotNull(message = "Legal Name" + MANDATORY_ATTRIBUTE_MESSAGE)
    @Size(min = 3, max = 256, message = "Legal Name must be 3 characters")
    @Column(name = "legal_name")
    private String name = "";

    @Enumerated(EnumType.STRING)
    @Column(name = "branch_type")
    private BranchTypeEnum type = null;

    @OneToMany(mappedBy = "branch", fetch = FetchType.LAZY)
    @Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL, region = "test_enterprise_collections")
    private List<EmployeeEntity> employees = new LinkedList<>();

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }

}
