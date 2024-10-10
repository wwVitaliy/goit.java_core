package module5;

class ClassNameExample {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();

        Class classFromInstance = testClass.getClass();
        Class classFromClass = TestClass.class;

        System.out.println("classFromInstance = " + classFromInstance);
        System.out.println("ClassFromClass = " + classFromClass);

        System.out.println("classFromInstance.equals(classFromClass) = "
                + classFromInstance.equals(classFromClass));

        System.out.println("testClass instanceof TestClass = "
                + (testClass instanceof TestClass));

    }
}
