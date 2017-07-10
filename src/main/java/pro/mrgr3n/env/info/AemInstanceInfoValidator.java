package pro.mrgr3n.env.info;


public class AemInstanceInfoValidator {
    private AemInstanceInfo aemInstanceInfo;
    private boolean isValid = true;

    public boolean isValid(AemInstanceInfo aemInstanceInfo) {
        this.aemInstanceInfo = aemInstanceInfo;

        return this.isValidDebugPort()
                .isValidPath()
                .isValidPort()
                .validate();
    }

    private boolean validate() {
        boolean result = isValid;
        isValid = true;

        return result;
    }

    private AemInstanceInfoValidator isValidPort() {
        String port = aemInstanceInfo.getPort();
        if (port.isEmpty() || !port.matches("^[1-9][0-9]*$")) {
            isValid = false;
        }
        return this;
    }

    private AemInstanceInfoValidator isValidPath() {
        String path = aemInstanceInfo.getPath();
        if (path.isEmpty() || !path.matches("^/.*/.*")) {
            isValid = false;
        }
        return this;
    }

    private AemInstanceInfoValidator isValidDebugPort() {
        String debugPort = aemInstanceInfo.getDebugPort();
        if (!debugPort.equals("N/A") && (debugPort.isEmpty() || !debugPort.matches("^[1-9][0-9]*$"))) {
            isValid = false;
        }

        return this;
    }
}
