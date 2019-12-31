package sakila.address.model;

public class Store {
	private int StoreId;
	private int managerStaffId;
	private Address address;
	private String lastUpdate;
	public int getStoreId() {
		return StoreId;
	}
	public void setStoreId(int storeId) {
		StoreId = storeId;
	}
	public int getManagerStaffId() {
		return managerStaffId;
	}
	public void setManagerStaffId(int managerStaffId) {
		this.managerStaffId = managerStaffId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	@Override
	public String toString() {
		return "Store [StoreId=" + StoreId + ", managerStaffId=" + managerStaffId + ", address=" + address
				+ ", lastUpdate=" + lastUpdate + "]";
	}
	
}
