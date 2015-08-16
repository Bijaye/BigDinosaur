package bigdinosaur.base.action.handler;

import java.util.List;



public interface ActionExecutor {
	public abstract EnumMessageInfo execute();

    public abstract void done();
    public abstract boolean isActionEnabled();
    abstract boolean isSystemError();
    abstract boolean isApplicationError();
    abstract boolean isErrorExists();
    ActionExecutor getActionExecutorLevel();
    List<ActionExecutor>getActionExecutorLevelAccumulated();
    ActionExecutor GetActionExecutorLevelController();
    ActionExecutor GetActionExecutorLevelService();
    ActionExecutor GetActionExecutorLevelDao();
    ActionExecutor GetActionExecutorLevelQuery();
    ActionExecutor GetJvmStatus();
    ActionExecutor GetMaxThreadsNoCpatured();
    ActionExecutor GetDetaiViewOfExecutionAllLayer();
    ActionExecutor GetDetaiViewOfLayer();
    ActionExecutor getAlertForResourceDeficiency();

}
