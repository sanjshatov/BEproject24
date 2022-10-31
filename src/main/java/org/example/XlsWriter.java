package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {
    public static void createTable(List<Statistics> statisticsList, String filePath) {
        // создаем workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        // создаем лист
        XSSFSheet sheet = workbook.createSheet("Статистика");
        // устанавливаем шрифт заголовка: ПОЛУЖИРНЫЙ
        Font headFont = workbook.createFont();
        headFont.setBold(true);
        // устанавливаем размер шрифта заголовка: 14, шрифт: Arial
        headFont.setFontHeightInPoints((short) 14);
        headFont.setFontName("Arial");
        // устанавливаем стиль заголовка
        CellStyle headStyle = workbook.createCellStyle();
        headStyle.setFont(headFont);
        // настройка содержимого и стиля ячеек заголовка
        int rowNumber = 0;
        Row headRow = sheet.createRow(rowNumber++);
        Cell profileCellHead = headRow.createCell(0);
        profileCellHead.setCellValue("Профиль обучения");
        profileCellHead.setCellStyle(headStyle);
        Cell avgExamScoreCellHead = headRow.createCell(1);
        avgExamScoreCellHead.setCellValue("Средний балл за экзамен");
        avgExamScoreCellHead.setCellStyle(headStyle);
        Cell numberOfStudentsCellHead = headRow.createCell(2);
        numberOfStudentsCellHead.setCellValue("Количество студентов по профилю");
        numberOfStudentsCellHead.setCellStyle(headStyle);
        Cell numberOfUniversitiesCellHead = headRow.createCell(3);
        numberOfUniversitiesCellHead.setCellValue("Количество университетов по профилю");
        numberOfUniversitiesCellHead.setCellStyle(headStyle);
        Cell fullNameCellHead = headRow.createCell(4);
        fullNameCellHead.setCellValue("Наименование университета по профилю");
        fullNameCellHead.setCellStyle(headStyle);

  //      int rowNumber = 0;
        for (Statistics statistics : statisticsList) {
            Row dataRow = sheet.createRow(rowNumber++);
            Cell profileCell = dataRow.createCell(0);
            profileCell.setCellValue(statistics.getStudyProfile().getProfileName());
            Cell avgExamScoreCell = dataRow.createCell(1);
            avgExamScoreCell.setCellValue(statistics.getAvgExamScore());
            Cell numberOfStudentsCell = dataRow.createCell(2);
            numberOfStudentsCell.setCellValue(statistics.getNumberOfStudents());
            Cell numberOfUniversitiesCell = dataRow.createCell(3);
            numberOfUniversitiesCell.setCellValue(statistics.getNumberOfUniversities());
            Cell fullNameCell = dataRow.createCell(4);
            fullNameCell.setCellValue(statistics.getFullName());
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            workbook.write(fileOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
