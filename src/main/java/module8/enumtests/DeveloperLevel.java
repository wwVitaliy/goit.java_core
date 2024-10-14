package module8.enumtests;

public enum DeveloperLevel {
    Junior(){
        @Override
        public boolean isJunior() {
            return true;
        }
    },
    Middle(2){
        @Override
        public boolean isMiddle() {
            return true;
        }
    },
    Senior(5){
        @Override
        public boolean isSenior() {
            return true;
        }
    };

    private int experienceYears;

    //constructor enum
    DeveloperLevel() {
        this.experienceYears = 0;
    }

    DeveloperLevel(int experienceYears) {
    this.experienceYears = experienceYears;
    }

    //static method
    public static void sayHello(){
        System.out.println("static Hello");
    }

    //non-static methods
    public boolean isJunior(){
        return false;
    }
    public boolean isMiddle(){
        return false;
    }
    public boolean isSenior(){
        return false;
    }

    
}
