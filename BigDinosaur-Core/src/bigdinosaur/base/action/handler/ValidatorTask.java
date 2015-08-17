package bigdinosaur.base.action.handler;



public interface ValidatorTask
{

    public abstract boolean validate();

    public abstract String getErrorMassageId();

    public abstract ComponentParts[] getFields();

    public abstract String getLabelFieldId();

    public abstract String getLabelFieldText();
    public abstract void setInfo( Class result);
    public abstract void validateConfiguration();
    
}


