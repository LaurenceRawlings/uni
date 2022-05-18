public class Patient implements Comparable<Patient> {
    private String firstName;
    private String lastName;
    private String illness;
    private int severity;

    public Patient(String firstName, String lastName, String illness, int severity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.illness = illness;
        this.severity = severity;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    @Override
    public int compareTo(Patient otherPatient) {
        if (severity > otherPatient.getSeverity()) {
            return -1;
        } else if (severity < otherPatient.getSeverity()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ": " + illness + " (" + severity + ")";
    }
}
