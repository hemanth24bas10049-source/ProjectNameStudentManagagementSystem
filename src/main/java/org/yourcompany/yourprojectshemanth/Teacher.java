package org.yourcompany.yourprojectshemanth;

class Teacher extends Person {
    private String subject;
    public Teacher(int id, String name, String subject) {
        super(id, name); this.subject = subject;
    }
    @Override
    public void displayInfo() {
        System.out.println("Teacher: " + getName() + ", Subject: " + subject);
    }
}