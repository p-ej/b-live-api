package live.b.api.support;

import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;

public final class ApiDocumentUtils {

    private ApiDocumentUtils() {
    }

    public static OperationRequestPreprocessor getDocumentRequest() {
        return preprocessRequest(
                        modifyUris() // (1)
                                .scheme("https")
                                .host("api.ah.r-e.kr")
                                .removePort(),
                        prettyPrint()); // (2)
    }

    public static OperationResponsePreprocessor getDocumentResponse() {
        return preprocessResponse(prettyPrint()); // (3)
    }
}