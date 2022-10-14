package org.example;

public class Main {
    public static void main(String[] args) {
        University university1 = new University("001", "Уральский Федеральный Университет", "УрФУ", 1920);
        University university2 = new University("002", "Московский государственный университет", "МГУ", 1755);
        Student student1 = new Student("Кокшаров Виктор Анатольевич", "001", 5, 3.8f);
        Student student2 = new Student("Садовничий Виктор Антонович", "002", 3, 4.7f);
        System.out.println(university1);
        System.out.println(university2);
        System.out.println(student1);
        System.out.println(student2);
        }
}