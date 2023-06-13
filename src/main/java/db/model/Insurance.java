package db.model;

public class Insurance {

    private int insuranceId;
    private String insuranceCompany;
    private int coverage;

    public Insurance() {
    }

    public Insurance(String insuranceCompany, int coverage) {
        this.insuranceCompany = insuranceCompany;
        this.coverage = coverage;
    }

    public int getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(int insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public int getCoverage() {
        return coverage;
    }

    public void setCoverage(int coverage) {
        this.coverage = coverage;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "insuranceId=" + insuranceId +
                ", insuranceCompany='" + insuranceCompany + '\'' +
                ", coverage=" + coverage +
                '}';
    }
}
