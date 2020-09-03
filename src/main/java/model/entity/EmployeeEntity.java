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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "employees", schema = "test_enterprise")
@SequenceGenerator(name = "employee_codes_gen", sequenceName = "test_enterprise.employee_codes_seq", allocationSize = 1)
public class EmployeeEntity extends AbstractEntity {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_codes_gen")
    private Integer id;

    @NotNull(message = "Name" + MANDATORY_ATTRIBUTE_MESSAGE)
    @Size(min = 3, max = 256, message = "Name must be between 3 characters and 256 characters")
    @Column(name = "name")
    private String name = "";

    @NotNull(message = "Age" + MANDATORY_ATTRIBUTE_MESSAGE)
    @Column(name = "age")
    private Integer age;

    @NotNull(message = "Branch " + MANDATORY_ATTRIBUTE_MESSAGE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", foreignKey = @ForeignKey(name = "branch_id_fkey"))
    private BranchEntity branch;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "employees")
    @Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL, region = "test_enterprise_collections")
    private List<WorkgroupEntity> workgroups = new LinkedList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BranchEntity getBranch() {
        return branch;
    }

    public void setBranch(BranchEntity branch) {
        this.branch = branch;
    }

    public List<WorkgroupEntity> getWorkgroups() {
        return workgroups;
    }

    public void setWorkgroups(List<WorkgroupEntity> workgroups) {
        this.workgroups = workgroups;
    }

    public Integer getId() {
        return id;
    }

}
