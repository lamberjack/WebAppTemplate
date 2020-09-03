package model.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "workgroups", schema = "test_enterprise")
@SequenceGenerator(name = "workgroup_codes_gen", sequenceName = "test_enterprise.workgroup_codes_seq", allocationSize = 1)
public class WorkgroupEntity extends AbstractEntity {

    @Id
    @Column(name = "workgroup_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workgroup_codes_gen")
    private Integer id;

    @NotNull(message = "Name" + MANDATORY_ATTRIBUTE_MESSAGE)
    @Size(min = 3, max = 256, message = "Name must be between 3 characters and 256 characters")
    @Column(name = "name")
    private String name = "";

    @Size(max = 256, message = "Name must be between 3 characters and 256 characters")
    @Column(name = "description")
    private String description = "";

    @ManyToMany(fetch = FetchType.LAZY)
    @Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL, region = "test_enterprise_collections")
    @JoinTable(name = "test_enterprise.workgroups_to_employees", joinColumns = {
            @JoinColumn(name = "workgroup_id", foreignKey = @ForeignKey(name = "workgroup_id_fkey")) }, inverseJoinColumns = {
                    @JoinColumn(name = "employee_id", foreignKey = @ForeignKey(name = "employee_id_fkey")) })
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }

}
