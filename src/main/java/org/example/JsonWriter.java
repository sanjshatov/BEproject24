package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonWriter {
    private static final Logger logger = Logger.getLogger(JsonWriter.class.getName());

    public JsonWriter() {
    }

    public static void writeJsonReq(Structure structure) {
        logger.log(Level.INFO, "JSON writer started");

        try {
            Files.createDirectory(Paths.get("jsonReqs"));
            logger.log(Level.INFO, "Directory created successfully");
        } catch (IOException e) {
            logger.log(Level.FINE, "Directory is already created", e);
        }

        writeStudents(structure);
        writeUniversities(structure);
        writeStatisticsList(structure);

        logger.log(Level.INFO, "JSON writer finished successfully");
    }

    private static void writeStatisticsList(Structure structure) {
        String studentsJson = JsonUtil.writeListToJson(structure.getStatisticsList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("jsonReqs/statistics" + structure.getProcessDate().getTime() + ".json");
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Statistics JSON writing failed", e);
        }
    }

    private static void writeUniversities(Structure structure) {
        String universitiesJson = JsonUtil.writeListToJson(structure.getUniversityList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("jsonReqs/universities" + structure.getProcessDate().getTime() + ".json");
            outputStream.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Universities JSON writer failed", e);
        }
    }

    private static void writeStudents(Structure structure) {
        String studentsJson = org.example.JsonUtil.writeListToJson(structure.getStudentList());
        try {
            FileOutputStream outputStream = new FileOutputStream("jsonReqs/students" + structure.getProcessDate().getTime() + ".json");
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Students JSON writing failed", e);
        }
    }

}
