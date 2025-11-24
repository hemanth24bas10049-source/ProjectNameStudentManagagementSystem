package org.yourcompany.yourprojectshemanth; 
class Student extends Person {
    private String grade;
    public Student(int id, String name, String grade) {
        super(id, name); this.grade = grade;
    }
    public String getGrade() { return grade; }

    public void displayInfo() {
        System.out.println("Student: " + getName() + ", Grade: " + grade);
    }
}
