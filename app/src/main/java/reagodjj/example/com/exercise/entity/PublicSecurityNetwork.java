package reagodjj.example.com.exercise.entity;

public class PublicSecurityNetwork {
    private int status;
    private Data data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PublicSecurityNetwork{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
