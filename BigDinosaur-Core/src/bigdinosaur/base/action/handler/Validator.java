package bigdinosaur.base.action.handler;



       

public class Validator
    implements ValidatorTask
{

            public Validator(ComponentParts field, String labelFieldId, String regExp)
            {
       this.field = field;
       this.labelFieldId = labelFieldId;
       this.regExp = regExp;
   }

            public Validator(ComponentParts field, String labelFieldId, String labelFieldText, String regExp)
            {
       this.field = field;
       this.labelFieldId = labelFieldId;
       this.labelFieldText = labelFieldText;
       this.regExp = regExp;
            }

           
   public boolean validate()
   {
       String value = field.getInternalValue();
       if(value == null || value.length() == 0)
           return true;
       return value.matches(regExp);
   }

   public ComponentParts[] getFields()
   {
       return (new ComponentParts[] {
           field
       });
   }

   public String getLabelFieldId()
   {
       return labelFieldId;
   }

   public String getLabelFieldText()
   {
       return labelFieldText;
   }

        
            private ComponentParts field;
            private String labelFieldId;
            private String labelFieldText;
            private String regExp;
			@Override
			public String getErrorMassageId() {
				
				return null;
			}

			@Override
			public void setInfo(Class result) {
				
			}

			@Override
			public void validateConfiguration() {
				
			}
}