package module5;

class Developer extends Person{

    private String programingLanguage;

    public Developer(String name, int age, String programingLanguage) {
        super(name, age);
        this.programingLanguage = programingLanguage;
    }

    public String getProgramingLanguage() {
        return programingLanguage;
    }

    public void setProgramingLanguage(String programingLanguage) {
        this.programingLanguage = programingLanguage;
    }
}
