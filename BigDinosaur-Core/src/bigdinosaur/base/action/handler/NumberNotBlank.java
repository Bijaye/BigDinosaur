package bigdinosaur.base.action.handler;




import java.lang.annotation.Annotation;

public interface NumberNotBlank
    extends Annotation
{

    public abstract String errorCode();

    public abstract String message();

    public abstract String args();

    public abstract String applyIf();

    public abstract String[] contexts();
}

