package com.mobileserviceapi.model;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class MobileImpl implements Mobile {

	private List<Integer> checkBoxRowId;
	
	private int rowId;
	
	private int personId;
	
	private String mobileManufacturer;
	
	private String mobileModel;
	
	private String mobileSpecs;
	
	private String  mobileFreedescription;
	
	private double price;
	
	private String photo;
	
	public MobileImpl() {
		super();
	}
	
	/**
	 * @param checkBoxRowId
	 * @param rowId
	 * @param personId
	 * @param mobileManufacturer
	 * @param mobileModel
	 * @param mobileSpecs
	 * @param mobileFreedescription
	 * @param price
	 * @param photo
	 */
	public MobileImpl(List<Integer> checkBoxRowId, int rowId, int personId,
			String mobileManufacturer, String mobileModel, String mobileSpecs,
			String mobileFreedescription, double price, String photo) {
		super();
		this.checkBoxRowId = checkBoxRowId;
		this.rowId = rowId;
		this.personId = personId;
		this.mobileManufacturer = mobileManufacturer;
		this.mobileModel = mobileModel;
		this.mobileSpecs = mobileSpecs;
		this.mobileFreedescription = mobileFreedescription;
		this.price = price;
		this.photo = photo;
	}

	/**
	 * @param rowId
	 * @param personId
	 * @param mobileManufacturer
	 * @param mobileModel
	 * @param mobileSpecs
	 * @param mobileFreedescription
	 * @param photo
	 */
	public MobileImpl(int rowId, int personId, String mobileManufacturer,
			String mobileModel, String mobileSpecs,
			String mobileFreedescription, double price) {
		super();
		this.rowId = rowId;
		this.personId = personId;
		this.mobileManufacturer = mobileManufacturer;
		this.mobileModel = mobileModel;
		this.mobileSpecs = mobileSpecs;
		this.mobileFreedescription = mobileFreedescription;
		this.price = price;
	}

	/**
	 * @return the rowId
	 */
	public int getRowId() {
		return rowId;
	}

	/**
	 * @param rowId the rowId to set
	 */
	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	/**
	 * @return the personId
	 */
	public int getPersonId() {
		return personId;
	}

	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(int personId) {
		this.personId = personId;
	}

	/**
	 * @return the mobileManufacturer
	 */
	public String getMobileManufacturer() {
		return mobileManufacturer;
	}

	/**
	 * @param mobileManufacturer the mobileManufacturer to set
	 */
	public void setMobileManufacturer(String mobileManufacturer) {
		this.mobileManufacturer = mobileManufacturer;
	}

	/**
	 * @return the mobileModel
	 */
	public String getMobileModel() {
		return mobileModel;
	}

	/**
	 * @param mobileModel the mobileModel to set
	 */
	public void setMobileModel(String mobileModel) {
		this.mobileModel = mobileModel;
	}

	/**
	 * @return the mobileSpecs
	 */
	public String getMobileSpecs() {
		return mobileSpecs;
	}

	/**
	 * @param mobileSpecs the mobileSpecs to set
	 */
	public void setMobileSpecs(String mobileSpecs) {
		this.mobileSpecs = mobileSpecs;
	}

	/**
	 * @return the mobileFreedescription
	 */
	public String getMobileFreedescription() {
		return mobileFreedescription;
	}

	/**
	 * @param mobileFreedescription the mobileFreedescription to set
	 */
	public void setMobileFreedescription(String mobileFreedescription) {
		this.mobileFreedescription = mobileFreedescription;
	}
	
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the checkBoxRowId
	 */
	public List<Integer> getCheckBoxRowId() {
		return checkBoxRowId;
	}

	/**
	 * @param checkBoxRowId the checkBoxRowId to set
	 */
	public void setCheckBoxRowId(List<Integer> checkBoxRowId) {
		this.checkBoxRowId = checkBoxRowId;
	}
	
	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MobileImpl [checkBoxRowId=" + checkBoxRowId + ", rowId="
				+ rowId + ", personId=" + personId + ", mobileManufacturer="
				+ mobileManufacturer + ", mobileModel=" + mobileModel
				+ ", mobileSpecs=" + mobileSpecs + ", mobileFreedescription="
				+ mobileFreedescription + ", price=" + price + ", photo="
				+ photo + "]";
	}

}
