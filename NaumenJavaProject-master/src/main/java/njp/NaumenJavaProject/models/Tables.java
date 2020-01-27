package njp.NaumenJavaProject.models;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table( name = "Tables")
public class Tables {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int numt;
    private String date;
    private String name;
    private String phone;
    private String time;

    public Tables(){}

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNumT(int numt) {
        this.numt = numt;
    }

    public long getId() {
        return id;
    }

    public int getNumT() {
        return numt;
    }
}
