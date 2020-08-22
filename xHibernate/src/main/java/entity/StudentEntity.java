package entity;

import javax.persistence.*;

@Table(name = "student", schema = "qlsvv", catalog = "")
public class StudentEntity {
    private String id;
    private String fullName;
    private Boolean gender;
    private ClasssEntity clazzByClassId;

    public StudentEntity(String id, String fullName, Boolean gender, ClasssEntity clazzByClassId) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.clazzByClassId = clazzByClassId;
    }

    public StudentEntity() {
    }

    @Id
    @Column(name = "id", nullable = false, length = 10)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "full_name", nullable = false, length = 45)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "gender", nullable = true)
    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id", nullable = false)
    public ClasssEntity getClazzByClassId() {
        return clazzByClassId;
    }

    public void setClazzByClassId(ClasssEntity clazzByClassId) {
        this.clazzByClassId = clazzByClassId;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", gender=" + gender +
                ", clazzByClassId=" + clazzByClassId.getId() +
                '}';
    }
}
