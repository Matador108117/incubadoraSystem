package models.DTOS;

public class DepencyDto {
    private int port;
    private String host;
    private int delay;
    private int cycles;
    
    public DepencyDto(int port, String host, int delay, int cycles) {
        this.port = port;
        this.host = host;
        this.delay = delay;
        this.cycles = cycles;
    }
    
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public int getDelay() {
        return delay;
    }
    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getCycles() {
        return cycles;
    }

    public void setCycles(int cycles) {
        this.cycles = cycles;
    }
    
    
}
