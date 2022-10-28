import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

public class urinalsTest {
    @Test
    void checkInputFileExists()
    {
        File file = new File("urinal.dat");
        assertTrue(file.exists());
    }
    @Test
    void checkOutputFileExists()
    {
        File file = new File("rule.txt");
        assertTrue(file.exists());
    }
}
