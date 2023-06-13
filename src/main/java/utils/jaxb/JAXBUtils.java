package utils.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class JAXBUtils {

    public static <T> T unmarshal(File file, Class<T> clazz) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz, DateAdapter.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return clazz.cast(unmarshaller.unmarshal(file));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> void marshal(T object) throws JAXBException {
        try {
            Class<?> clazz = object.getClass();
            String className = clazz.getSimpleName();
            String fileName = "./src/main/resources/" + className + ".xml";
            File file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass(), DateAdapter.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(object, file);
            System.out.println("XML written to file: " + file.getAbsolutePath());
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}