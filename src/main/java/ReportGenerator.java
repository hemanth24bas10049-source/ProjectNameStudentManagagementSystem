package org.yourcompany.yourprojectshemanth;

class ReportGenerator extends Thread {
    private List<Person> people;
    public ReportGenerator(List<Person> people) { this.people = people; }
    @Override
    public void run() {
        System.out.println("Generating report...");
        for (Person p : people) {
            p.displayInfo();
        } 
        System.out.println("Report completed.");
    }
}
