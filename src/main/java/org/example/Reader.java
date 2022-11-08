package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reader {

    private static final Logger logger = Logger.getLogger(Reader.class.getName());

    public static List<University> readUniversity(String file) throws IOException {
        List<University> universities = new ArrayList<>();

        try {
            logger.log(Level.INFO, "Excel reader started");

            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("Университеты");

            Iterator<Row> rows = sheet.iterator();
            rows.next();

            while (rows.hasNext()) {
                Row row = rows.next();
                University university = new University();
                universities.add(university);
                university.setId(row.getCell(0).getStringCellValue());
                university.setFullName(row.getCell(1).getStringCellValue());
                university.setShortName(row.getCell(2).getStringCellValue());
                university.setYearOfFoundation((int) row.getCell(3).getNumericCellValue());
                university.setMainProfile(StudyProfile.valueOf(StudyProfile.class, row.getCell(4).getStringCellValue()));
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Excel reader failed", e);
            return universities;
        }

        logger.log(Level.INFO, "Excel reader finished successfully");
        return universities;
    }

    public static List<Student> readStudent(String file) {
        List<Student> students = new ArrayList<>();

        try {
            logger.log(Level.INFO, "Excel reader started");

            FileInputStream fis = new FileInputStream(file);
            //Создаём экземпляр класса XSSFWorkbook, передав его конструктору на вход стрим файла.
            // Для файлов XLS (более старый формат) используется аналогичный класс HSSFWorkbook.
            // Здесь Workbook — это сам документ Excel, его представление как объекта.
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            //Затем надо получить страницу/лист. Для этого используем метод workbook.getSheet(имя_страницы).
            // Метод возвращает экземпляр класса XSSFSheet (либо HSSFSheet, если мы работаем с XLS).
            // Этот класс — представление конкретного листа из файла Excel. Можно получать листы как по их
            // индексу (порядковый номер), так и по названию листа.
            XSSFSheet sheet = workbook.getSheet("Студенты");
            //С листом мы работаем при помощи итератора. Создаём итератор, который перебирает строки нашего листа.
            // Например, sheet.iterator()
            Iterator<Row> rows = sheet.iterator();
            //Если в файле есть заголовок, нам надо его пропустить. Для этого достаточно просто вызвать
            // iterator.next() перед тем, как мы будем обрабатывать информацию внутри цикла.
            rows.next();
            //Затем в цикле while перебираем строки, предоставляемые итератором (экземпляры класса Row).
            // Строки, очевидно, содержат в себе ячейки таблицы — элементы класса Cell.
            while (rows.hasNext()) {
                Row row = rows.next();
                // создаем объект для каждой строки
                Student student = new Student();
                // добавляем в коллекцию
                students.add(student);
                student.setUniversityId(row.getCell(0).getStringCellValue());
                student.setFullName(row.getCell(1).getStringCellValue());
                student.setCurrentCourseNumber((int) row.getCell(2).getNumericCellValue());
                student.setAvgExamScore((float) row.getCell(3).getNumericCellValue());
            }

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Excel reader failed", e);
            return students;
        }

        logger.log(Level.INFO, "Excel reader successfully");
        return students;
    }

    private Reader() {
    }
}

