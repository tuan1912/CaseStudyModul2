package model;

import java.util.Date;

public class Computer {
    public static int id = 0;
    private int computerId;
    private String computerName = "Computer ";
    private boolean status = false;
    private long startTime;
    private long endTime;

    public Computer() {
        computerId = ++id;
        this.computerName += computerId;
    }

    public boolean getStatus() {
        return status;
    }

    public void isOnOrOff() {
        this.status = !this.status; // phai check status nhap vao
        if (status) startCounter();
        else stopCounter();
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName +" "+ this.computerId;
    }

    public int getComputerId() {
        return computerId;
    }

    public long startCounter() {
        Date date = new Date();
        this.startTime = date.getTime();
        return startTime;
    }

    public long stopCounter() {
        Date date = new Date();
        this.endTime = date.getTime();
        return endTime;
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "computerId=" + computerId +
                ", computerName='" + computerName + '\'' +
                ", status=" + status +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
