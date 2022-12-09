package org.apache.dolphinscheduler.plugin.task.seatunnel.self;

import org.apache.dolphinscheduler.plugin.task.seatunnel.DeployModeEnum;
import org.apache.dolphinscheduler.plugin.task.seatunnel.SeatunnelParameters;

public class SeatunnelEngineParameters extends SeatunnelParameters {

    private DeployModeEnum deployMode;

    private String others;

    public DeployModeEnum getDeployMode() {
        return deployMode;
    }

    public void setDeployMode(DeployModeEnum deployMode) {
        this.deployMode = deployMode;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
}
