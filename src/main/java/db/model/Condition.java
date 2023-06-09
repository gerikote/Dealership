package db.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.*;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Condition {

    @JsonProperty("conditionID")
    @XmlAttribute
    private int conditionID;

    @JsonProperty("condition")
    @XmlElement
    private String condition;

    public Condition() {
    }

    public Condition(String condition) {
        this.condition = condition;
    }

    public int getConditionID() {
        return conditionID;
    }

    public void setConditionID(int conditionID) {
        this.conditionID = conditionID;
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
                "conditionId=" + conditionID +
                ", condition='" + condition + '\'' +
                '}';
    }
}
