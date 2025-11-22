package org.yourcompany.yourprojectshemanth;

class Admin extends Person {
    public Admin(int id, String name) {
        super(id, name);
    }
    @Override
    public void displayInfo() {
        System.out.println("Admin: " + getName());
    }
}