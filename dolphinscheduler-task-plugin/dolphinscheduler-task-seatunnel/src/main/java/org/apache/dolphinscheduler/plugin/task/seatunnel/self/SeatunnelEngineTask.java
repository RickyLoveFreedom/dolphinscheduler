package org.apache.dolphinscheduler.plugin.task.seatunnel.self;

import org.apache.dolphinscheduler.common.utils.JSONUtils;
import org.apache.dolphinscheduler.plugin.task.api.TaskExecutionContext;
import org.apache.dolphinscheduler.plugin.task.seatunnel.Constants;
import org.apache.dolphinscheduler.plugin.task.seatunnel.SeatunnelTask;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;

public class SeatunnelEngineTask extends SeatunnelTask {

    private SeatunnelEngineParameters seatunnelParameters;
    public SeatunnelEngineTask(TaskExecutionContext taskExecutionContext) {
        super(taskExecutionContext);
    }

    @Override
    public void init() {
        seatunnelParameters =
                JSONUtils.parseObject(taskExecutionContext.getTaskParams(), SeatunnelEngineParameters.class);
        setSeatunnelParameters(seatunnelParameters);
        super.init();
    }

    @Override
    public List<String> buildOptions() throws Exception {
        List<String> args = super.buildOptions();
        if (!Objects.isNull(seatunnelParameters.getDeployMode())) {
            args.add(Constants.DEPLOY_MODE_OPTIONS);
            args.add(seatunnelParameters.getDeployMode().getCommand());
        }
        if (StringUtils.isNotBlank(seatunnelParameters.getOthers())) {
            args.add(seatunnelParameters.getOthers());
        }
        return args;
    }

}
