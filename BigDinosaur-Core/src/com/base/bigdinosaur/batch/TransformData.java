package com.base.bigdinosaur.batch;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("load")
public class TransformData {

	@XStreamImplicit
	private List<BusinessDataImpl> businessdata = new ArrayList<BusinessDataImpl>();

	@XStreamImplicit
	private List<DevelopmentDataImpl> developmentdata = new ArrayList<DevelopmentDataImpl>();

	@XStreamImplicit
	private List<MasteraccessImpl> masterdata = new ArrayList<MasteraccessImpl>();

	public List<Master> getObjects() {
		List Objects = new ArrayList<Master>();

		Objects.addAll(this.businessdata);
		Objects.addAll(this.developmentdata);
		Objects.addAll(this.masterdata);

		return Objects;
	}

	

	public static void process(String[] args) throws Exception {

		XStream xstream = setUpObject();
		String loadfile = "D://master.xml";
		TransformData loader = createLoader(loadfile, xstream);

		for (Master myObject : (loader).getObjects()) {
			myObject.Load();
		}

	}

	public static TransformData createLoader(String loadFile, XStream xstream)
			throws Exception {

		File file = new File(loadFile);
		TransformData Object = (TransformData) xstream.fromXML(file);
		return Object;
	}

	public static XStream setUpObject() {

		XStream xstream = new XStream();
		xstream.processAnnotations(TransformData.class);
		xstream.processAnnotations(DevelopmentDataImpl.class);
		xstream.processAnnotations(BusinessDataImpl.class);
		xstream.processAnnotations(MasteraccessImpl.class);

		return xstream;
	}

	public List<BusinessDataImpl> getBusinessdata() {
		return businessdata;
	}

	public List<DevelopmentDataImpl> getDevelopmentdata() {
		return developmentdata;
	}

	public List<MasteraccessImpl> getMasterdata() {
		return masterdata;
	}

	public void setBusinessdata(List<BusinessDataImpl> businessdata) {
		this.businessdata = businessdata;
	}

	public void setDevelopmentdata(List<DevelopmentDataImpl> developmentdata) {
		this.developmentdata = developmentdata;
	}

	public void setMasterdata(List<MasteraccessImpl> masterdata) {
		this.masterdata = masterdata;
	}

}
