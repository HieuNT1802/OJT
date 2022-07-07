package fa.training.entities;

import java.time.LocalDate;

public class Working_History {
    private int deptId;
    private int empId;
    private LocalDate fromDate;
    private LocalDate toDate;

    public Working_History() {
    }

    public Working_History(int deptId, int empId, LocalDate fromDate, LocalDate toDate) {
        this.deptId = deptId;
        this.empId = empId;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }
}
