public class Mortgage {

    public enum Gender {
        MALE, FEMALE;
    }
    
    public static int calculateMortgage(int age, int salary, Gender gender) {
        double factor = 0;
        if (gender == Mortgage.Gender.FEMALE) {
            if (18 <= age & age <= 35) {
                factor = 7;
            } else if (36 <= age & age < 45) {
                factor = 5;
            } else if (45 < age & age <= 55) {
                factor = 3;
            }
        } else if (gender == Mortgage.Gender.MALE) {
            if (18 <= age & age <= 35) {
                factor = 7.5;
            } else if (35 < age & age <= 45) {
                factor = 5.5;
            } else if (45 < age & age <= 55) {
                factor = 3.5;
            }
        }
        return (int)(salary * factor);
    }
}
