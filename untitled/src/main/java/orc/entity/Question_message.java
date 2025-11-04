package orc.entity;

public class Question_message {
    private String QuestionId;
    private String Level;               //难度
    private String Content;             //题目描述
    private String Answer;             //答案
    private String Title;//题目类型
    private String Object;
    public String getQuestionId(){
        return QuestionId;
    }
    public void setQuestionId(String questionId) {
        this.QuestionId = questionId;
    }
    public String getLevel() {
        return Level;
    }
    public void setLevel(String level) {
        this.Level = level;
    }
    public String getContent() {
        return Content;
    }
    public void setContent(String content) {
        this.Content = content;
    }
    public String getAnswer() {
        return Answer;
    }
    public void setAnswer(String answer) {
        this.Answer = answer;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        this.Title = title;
    }
    public String getObject() {
        return Object;
    }
    public void setObject(String object) {
        this.Object = object;
    }
    @Override
    public String toString() {
        return "Question_message{" +
                "QuestionId='" + QuestionId + '\'' +
                ", Level='" + Level + '\'' +
                ", Content='" + Content + '\'' +
                ", Answer='" + Answer + '\'' +
                ", Title='" + Title + '\'' +
                ", Object='" + Object + '\'' +
                '}';
    }
}
