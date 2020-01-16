import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileIOTest {

    @Test
    void save() {
    }

    @Test
    void load() throws IOException {
        String name = "Roni";
        String surname = "Thanyni";
        String file =("visitor_Roni_Thanyani.txt");
        String res = FileIO.read(file);
        assertEquals("visitor_Roni_Thanyani.txt",res);
    }
}