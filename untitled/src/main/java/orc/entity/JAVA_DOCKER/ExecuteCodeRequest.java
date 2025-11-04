package orc.entity.JAVA_DOCKER;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ExecuteCodeRequest {

    private List<String> inputList;

    private String code;

    private String language;
    public ExecuteCodeRequest(List<String> inputList, String code, String language) {
        this.inputList = inputList;
    }
    public List<String> getInputList() {
        return inputList;
    }
    public void setInputList(List<String> inputList) {
        this.inputList = inputList;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
}
