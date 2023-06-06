package db.model;

public class Condition {
    private int conditionId;
    private String condition;

    public Condition() {
    }

    public Condition(int conditionId, String condition) {
        this.conditionId = conditionId;
        this.condition = condition;
    }

    public int getConditionId() {
        return conditionId;
    }

    public void setConditionId(int conditionId) {
        this.conditionId = conditionId;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "conditionId=" + conditionId +
                ", condition='" + condition + '\'' +
                '}';
    }
}
