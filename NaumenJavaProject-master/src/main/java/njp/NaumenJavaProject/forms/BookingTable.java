package njp.NaumenJavaProject.forms;

public class BookingTable {
    private String name;
    private String phone;
    private String date;
    private String time;
    private String tableNum;

    public BookingTable(String name, String phone, String date, String time, String tableNum){
        this.name=name;
        this.phone=phone;
        this.date=date;
        this.time=time;
        this.tableNum=tableNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTableNum(String tableNum) {
        this.tableNum = tableNum;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getPhone() {
        return phone;
    }

    public String getTableNum() {
        return tableNum;
    }

    public String getTime() {
        return time;
    }

}
