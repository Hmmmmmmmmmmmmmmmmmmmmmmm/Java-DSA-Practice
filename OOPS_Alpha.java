import java.util.Arrays;

public class OOPS_Alpha {
    public static void main(String[] args) {
        System.out.println("Mew");
        Car car = new Car();//obj crated via construct who knows the fuck that is
        car.color= "Black";
        System.out.println(car.color);
        car.setGear('N');
        System.out.println(car.gear);
        Cat c1 = new Cat();
        c1.eats();
        c1.says();
        int[] arr =new int[3];
        Student s1 = new Student(1,"Vanitas");
        System.out.println(s1.getRollNo());
        System.out.println(s1.getName());
        s1.setMarks(arr);
        System.out.println(Arrays.toString(s1.getMarks()));
        s1.marks[0]=30;
        s1.marks[1]=30;
        s1.marks[2]=30;
        Student s2 = new Student(s1);
        Student s3 = new Student(s1);
        System.out.println("S1 marks         : "+ Arrays.toString(s1.getMarks()));
        System.out.println("S2 marks         : "+ Arrays.toString(s2.getMarks()));
        s1.marks[1]=50;
        System.out.println("S1 marks         : "+ Arrays.toString(s1.getMarks()));
        System.out.println("S2 marks(changed): "+ Arrays.toString(s2.getMarks()));
    }
}
class Animal{
    void eats(){
        System.out.println("munch munch chomp chomp");
    }
    void breath(){
        System.out.println("need oxygen");
    }
}
class Cat extends Animal{
    void says(){
        System.out.println("mew");
    }
}
class Student{
    private int rollNo;
    String name;
    int[] marks;

    Student(int rollNo, String name){
        this.rollNo=rollNo;
        this.name=name;
    }
//shallow copy
    Student(Student s1){
        marks = new int[3];
        this.rollNo=s1.rollNo;
        this.name=s1.name;
        this.marks=s1.marks;
    }
    //deep copy
//    Student(Student s1){
//        marks = new int[3];
//        this.rollNo=s1.rollNo;
//        this.name=s1.name;
//        System.arraycopy(s1.marks, 0, this.marks, 0, marks.length);
//    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }
}
class Car{
    protected char gear;
    public String color;
    private int regNo;

    void setGear(char newGear){
        gear = newGear;
    }
    void setColor(String newColor){
        color = newColor;
    }


}
class BankAcc{
    public String AccHolder;
    protected String Branch;
    protected int AccNo;
    private int pin;

    public void setAccHolder(String accHolder) {
        AccHolder = accHolder;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
