package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlWriter {

    private static final Logger logger = Logger.getLogger(XmlWriter.class.getName());

    private XmlWriter() {
    }

    public static void generateXmlReq(Structure structure) {

        try {
            logger.log(Level.INFO, "XML marshalling started");

            JAXBContext jaxbContext = JAXBContext.newInstance(Structure.class);

            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            try {
                Files.createDirectory(Paths.get("xmlReqs"));
                logger.log(Level.INFO, "Directory created successfully");
            } catch (IOException e) {
                logger.log(Level.FINE, "Directory already created", e);
            }
            File requestFile = new File("xmlReqs/infoReq" + new Date().getTime() + ".xml");

            marshaller.marshal(structure, requestFile);
        } catch (JAXBException jaxbEx) {
            logger.log(Level.SEVERE, "XML marshalling failed", jaxbEx);
            return;
        }

        logger.log(Level.INFO, "XML marshalling finished successfully");
    }
}
