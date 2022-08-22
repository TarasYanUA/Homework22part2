import org.testng.annotations.Test;
import taras.PetEndpoint;
import java.io.IOException;

public class PetTest {
    @Test
    public void petTest() throws IOException {
        new PetEndpoint().getPetById(112);
    }
}

