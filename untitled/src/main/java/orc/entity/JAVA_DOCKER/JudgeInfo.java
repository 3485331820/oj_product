package orc.entity.JAVA_DOCKER;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JudgeInfo {
    private String message;

    /**
     * 消耗内存
     */
    private Long memory;

    /**
     * 消耗时间（KB）
     */
    private Long time;
    public JudgeInfo(String message, Long memory, Long time) {
        this.message = message;
        this.memory = memory;
        this.time = time;
    }

}
