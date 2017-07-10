package pro.mrgr3n.env.info;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AemInstanceInfoManager {
    private static final String GET_ALL_PROCESS_INFO_COMMAND = "ps -few";
    private static final String N_A = "N/A";
    private static final String ADDRESS = "address";
    private static final String DSLING_RUN_MODES = "Dsling.run.modes";
    private AemInstanceInfoValidator validator = new AemInstanceInfoValidator();

    public static BufferedReader runConsoleCommand(String getAllProcessInfoCommand) throws IOException {
        Process p = Runtime.getRuntime().exec(getAllProcessInfoCommand);
        return new BufferedReader(new InputStreamReader(p.getInputStream()));
    }

    public List<AemInstanceInfo> find() throws IOException {
        return getAllAemInstancesInfo(runConsoleCommand(GET_ALL_PROCESS_INFO_COMMAND));
    }

    private List<AemInstanceInfo> getAllAemInstancesInfo(BufferedReader input) throws IOException {
        List<AemInstanceInfo> aemInstancesList = new ArrayList<>();
        String processStr;
        while ((processStr = input.readLine()) != null) {
            if (isAemProcess(processStr)) {
                AemInstanceInfo aemInstanceInfo = getAemInstanceInfo(getParams(processStr));
                if (validator.isValid(aemInstanceInfo)) {
                    aemInstancesList.add(aemInstanceInfo);
                }
            }
        }

        return aemInstancesList;
    }

    private boolean isAemProcess(String processStr) {
        return processStr.toLowerCase().contains("crx-quickstart");
    }

    private AemInstanceInfo getAemInstanceInfo(String[] params) throws IOException {
        AemInstanceInfo aemInstanceInfo = new AemInstanceInfo();
        String pid = params[1];
        aemInstanceInfo.setPid(pid);
        aemInstanceInfo.setRunMods(getRunMods(params));
        aemInstanceInfo.setPort(getPort(params));
        aemInstanceInfo.setPath(getProcessFolder(pid));
        aemInstanceInfo.setDebugPort(getDebugPort(params));

        return aemInstanceInfo;
    }

    private String getDebugPort(String[] params) {
        for (String param : params) {
            if (param.contains(ADDRESS)) {
                String debugPort = param.substring(param.indexOf(ADDRESS + "=") + (ADDRESS + "=").length());
                if (debugPort.length() > 0) {
                    return debugPort;
                }
            }
        }
        return N_A;
    }

    private String[] getParams(String processStr) {
        return processStr.replaceAll("\\s+", " ").split(" ");
    }

    private String getRunMods(String[] params) {
        for (String param : params) {
            if (param.contains(DSLING_RUN_MODES)) {
                return param.split("=")[1];
            }
        }
        return N_A;
    }

    private String getProcessFolder(String pid) throws IOException {
        BufferedReader input = runConsoleCommand("pwdx " + pid);
        String consoleOut = input.readLine();

        return consoleOut.toString().split(":")[1].trim();
    }


    private String getPort(String[] params) {
        for (int i = 0; i < params.length; i++) {
            if (params[i].contains("-p")) {
                return params[i + 1];
            }
        }
        return N_A;
    }

}
