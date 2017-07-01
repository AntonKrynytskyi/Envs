package pro.mrgr3n.env.info;

public class AemInstanceInfo {
    private String pid;
    private String port;
    private String runMods;
    private String path;
    private String debugPort;

    public String getDebugPort() {
        return debugPort;
    }

    public void setDebugPort(String debugPort) {
        this.debugPort = debugPort;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getRunMods() {
        return runMods;
    }

    public void setRunMods(String runMods) {
        this.runMods = runMods;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
