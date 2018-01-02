package homework;

public class User {

    private String uname;
    private String age;
    private String loc;
    private String uid;

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", age='" + age + '\'' +
                ", loc='" + loc + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}