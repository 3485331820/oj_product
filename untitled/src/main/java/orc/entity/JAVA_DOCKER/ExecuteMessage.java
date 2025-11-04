package orc.entity.JAVA_DOCKER;


import lombok.Data;

@Data
public class ExecuteMessage {

        private Integer exitValue;

        private String message;

        private String errorMessage;

        private Long time;

        private Long memory;
        public void setExitValue(Integer exitValue) {
                this.exitValue = exitValue;
        }
        public Integer getExitValue() {
                return exitValue;
        }
        public void setMessage(String message) {
                this.message = message;
        }
        public String getMessage() {
                return message;
        }
        public void setErrorMessage(String errorMessage) {
                this.errorMessage = errorMessage;
        }
        public String getErrorMessage() {
                return errorMessage;
        }
        public void setTime(Long time) {
                this.time = time;
        }
        public Long getTime() {
                return time;
        }
        public void setMemory(Long memory) {
                this.memory = memory;
        }
        public Long getMemory() {
                return memory;
        }
}
