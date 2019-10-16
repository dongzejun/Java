package cn.leon.reflect;

public class User {
    private String name;
    private int sex;
    public String address;

    public User(){
        System.out.println("使用了空的构造方法");
    }
    public User(String name){
        System.out.println("name:" + name);
    }
    public User(int sex){
        System.out.println("sex:"+sex);
    }
    public User(String name, int sex){
        System.out.println("name:" + name + ",sex:" + sex);
    }
    private User(String name, int sex, int age){
        System.out.println("private|name:" + name + ",sex:" + sex);
    }


    public void displayPersonalInformation(String name, int sex, String address){
        System.out.println("name:" + name + ",sex:" + sex + ",address:" + address);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args){
        System.out.println("执行了main方法");
    }

}
