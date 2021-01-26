package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "likes")
@NamedQueries({
    @NamedQuery(
        name = "getAllLikes",
        query = "SELECT l FROM Report AS l ORDER BY l.id DESC"
    ),
    @NamedQuery(
        name = "getLikesCount",
        query = "SELECT COUNT(l) FROM Like AS l"
    ),
})
@Entity
public class Like {
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@ManyToOne
    @JoinColumn(name = "report_id", nullable = false)
    private Report report;

	@ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


}
