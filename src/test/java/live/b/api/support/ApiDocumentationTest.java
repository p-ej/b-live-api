package live.b.api.support;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

@WebMvcTest
@AutoConfigureRestDocs
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(RestDocumentationExtension.class)
public abstract class ApiDocumentationTest {

    @Autowired
    public MockMvcTester mockMvcTester;
}
