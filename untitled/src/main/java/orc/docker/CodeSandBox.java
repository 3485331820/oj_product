package orc.docker;

import orc.entity.JAVA_DOCKER.ExecuteCodeResponse;
import orc.entity.JAVA_DOCKER.ExecuteCodeRequest;

public interface CodeSandBox {
    ExecuteCodeResponse executeCode(ExecuteCodeRequest codeRequest);
}
