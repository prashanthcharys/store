package com.mobilize.core.domain.value;

import java.io.Serializable;

import com.mobilize.core.common.AUTOCONSTANTS;
import com.mobilize.core.exception.ReferenceDataException;

public class HomeAddressVO extends Address implements Serializable {

	private static final long serialVersionUID = 1L;
	
	{
		try {
			super.setType( AUTOCONSTANTS.HOME );
		} catch (ReferenceDataException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void setType(String type) throws ReferenceDataException {
		throw new ReferenceDataException("Reference to this data is not allowed");
	}
	
	public boolean isEqual( Address add2) {
		return this.getStreet1().equals( add2.getStreet1() ) ||
			this.getStreet2().equals( add2.getStreet2() ) ||
			this.getCity().equals(add2.getCity() ) ||
			this.getState().equals( add2.getState() ) ||
			this.getZip().equals( add2.getZip() ) ||
			this.getCounty().equals( add2.getCounty() ) ||
			this.getCountry().equals( add2.getCountry() );
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append( this.getType() );
		sb.append(" : ");
		sb.append( this.getStreet1() );
		sb.append( this.getStreet2() );
		sb.append( this.getCity() );
		sb.append( this.getState() );
		sb.append( this.getZip() );
		sb.append( this.getCounty() );
		sb.append( this.getCountry());
		
		return sb.toString();
	}

}
