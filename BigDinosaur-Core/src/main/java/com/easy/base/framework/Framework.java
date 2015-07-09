package com.easy.base.framework;

import com.base.bigdinosaur.core.Cachable;


public abstract class Framework {
    public Framework() {
        mainmodule = null;
    }
    private Module mainmodule;
    public abstract String getFrameworkId();
    protected abstract void mainModuleCallAfterInitialization();
    protected abstract void CallFrameworkInitializaton();
    
    public void prefetchFieldNamesOfWebModule(Cachable webfieldnamecache) {
    }
}
abstract class Frameworklevelextend extends Framework {

	Frameworklevelextend(Framework framework){
    framework.mainModuleCallAfterInitialization();
    }
	 protected abstract void CallFrameworkClientInitialization();
	 protected abstract void CallFrameworkClientsecurityInitialization();
	 protected abstract void CallFrameworkClientPreferenceInitialization();
	 protected abstract void CallFrameworkClientServiceInitialization();
	 
    
@Override
public String getFrameworkId() {
    return null;
}
@Override
protected void mainModuleCallAfterInitialization() {
	// To DO Perform Initialization Part for framework client
	// Look up Preference setting and Set  ORM provider Or Native Or Data Mappper 
	// Look Up Security and  Setting whether Framework client has right to get  started for operation and Set UP User Authentication and Authorization
	// Set UP process Date and Module Preference options like currency 
	//Set UP Module ID for services
	// SetUP session of the Modules by overriding from default  and Create a new session for user,group,workstation,cluster ,menu bar info
    
}
@Override
protected void CallFrameworkInitializaton() {
	
}
public void afterInitialize() {
	
}
}
class  MainClientFramework extends Frameworklevelextend {
    private Framework superframework;
    MainClientFramework(Framework framework){
    	 super(framework);
        this.superframework=framework;
     
        }

    @Override
    public String getFrameworkId() {
        return null;
    }

    @Override
    protected void mainModuleCallAfterInitialization() {
        super.afterInitialize();// mainModuleCallAfterInitialization is called first 
        
        
    }

	@Override
	protected void CallFrameworkClientInitialization() {
		
	}

	@Override
	protected void CallFrameworkClientsecurityInitialization() {
		
	}

	@Override
	protected void CallFrameworkClientPreferenceInitialization() {
		
	}

	@Override
	protected void CallFrameworkClientServiceInitialization() {
		
	}
    }
class  MainClientFrameworkModule extends MainClientFramework {
	

    MainClientFrameworkModule(Framework framework) {
		super(framework);
	}

	@Override
    public String getFrameworkId() {
        return null;
    }

    @Override
    protected void mainModuleCallAfterInitialization() {
        super.afterInitialize();// mainModuleCallAfterInitialization is called first 
        
        
    }
    
@Override
protected void CallFrameworkClientInitialization() {
	
}
@Override
protected void CallFrameworkClientsecurityInitialization() {
	
}
@Override
protected void CallFrameworkClientPreferenceInitialization() {
	
}
@Override
protected void CallFrameworkClientServiceInitialization() {
	
}
}
