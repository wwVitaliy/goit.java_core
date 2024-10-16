package module8.interfacetests.defaultsmethods;

/*
Складні кейси та пріоритет

1-Якщо клас реалізує інтерфейс і наслідується від суперкласу, який містить метод із такою самою сигнатурою, що й у
методу в інтерфейсі, то реалізація методу суперкласу в підкласі не потрібна. Якщо в інтерфейсі цей метод був дефолтним,
тобто мав реалізацію, реалізація методу в суперкласі має пріоритет над методом інтерфейсу.
2- Якщо клас реалізує 2 інтерфейси із загальним предком, у якого визначено дефолтний метод, і один з інтерфейсів
перевизначає цей метод, то в класі буде ігноруватися дефолтний метод батьківського інтерфейсу.
3- Якщо клас реалізує 2 інтерфейси, що містять однакові за сигнатурою дефолтні методи, то клас повинен перевизначити
цей метод.

 */
public class DuplicatedMethodsTests {
    public static void main(String[] args) {
        //1
        SubClass1 subClass1 = new SubClass1();
        subClass1.duplicatedMethod();

        //2
        SubClass2 subClass2 = new SubClass2();
        subClass2.duplicatedMethod();

        //3
        SubClass3 subClass3 = new SubClass3();
        subClass3.duplicatedMethod();
    }

}
