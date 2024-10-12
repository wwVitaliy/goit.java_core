package module6;

import java.util.Objects;

class ConstructorCheck {
    public static void main(String[] args) {

        Parent testParent = new Parent("kim");  //OK, Parent is static
        //Child testChild1 = new Child("Tim");  //Error, Child is not static

        ConstructorCheck constructorCheck = new ConstructorCheck();

        Child testChild1 = constructorCheck.new Child("Tim");
        System.out.println("testChild1.getChildName() = "
                + testChild1.getChildName());

        System.out.println("\n");

        Child testChild2 = constructorCheck.new Child("Jonny");
        System.out.println("testChild2.getChildName() = "
                + testChild2.getChildName());
    }

    // Static inner class
    static class Parent {
        //Static initialization block. Execute whe the class is loaded
        static {
            System.out.println("This is Parent static init block!");
        }

        private String parentName;

        public Parent(String parentName) {
            this.parentName = parentName;
            System.out.println("This is Parent constructor!");
        }

        public String getParentName() {
            return parentName;
        }

        public void setParentName(String parentName) {
            this.parentName = parentName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Parent parent = (Parent) o;
            return Objects.equals(parentName, parent.parentName);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(parentName);
        }

        @Override
        public String toString() {
            return "Parent{" +
                    "parentName='" + parentName + '\'' +
                    '}';
        }
    }

    //Non static inner class
    class Child extends Parent {
        //Initialization block. Executes before constructor.
        {
            System.out.println("This is Child init block!");
        }

        private String childName;

        public Child(String childName) {
            super("Tom"); //Parent constructor is mandatory here
            this.childName = childName;
            System.out.println("This is Child constructor!");
        }

        public String getChildName() {
            return childName;
        }

        public void setChildName(String childName) {
            this.childName = childName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Child child = (Child) o;
            return Objects.equals(childName, child.childName);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(childName);
        }

        @Override
        public String toString() {
            return "Child{" +
                    "childName='" + childName + '\'' +
                    '}';
        }
    }

}
